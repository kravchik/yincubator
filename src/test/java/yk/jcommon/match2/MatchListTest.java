package yk.jcommon.match2;

import org.junit.Test;
import yk.jcommon.utils.StopWatch;
import yk.ycollections.YArrayList;
import yk.ycollections.YList;
import yk.ycollections.YMap;
import yk.ycollections.YSet;

import static org.junit.Assert.assertEquals;
import static yk.jcommon.match2.MatcherShortNames.listFiller;
import static yk.jcommon.match2.MatcherShortNames.var;
import static yk.ycollections.YArrayList.al;
import static yk.ycollections.YHashMap.hm;
import static yk.ycollections.YHashSet.hs;

/**
 * Created by Yuri Kravchik on 18/11/16.
 */
public class MatchListTest {

    @Test
    public void testList() {
        assertEquals("[{before=a}]", new Matcher().match(al("a", "b", "c"), new MatchList(al(var("before"), "b", "c"))).toString());
        assertEquals("[{before=a, after=c}]", new Matcher().match(al("a", "b", "c"), new MatchList(al(var("before"), "b", var("after")))).toString());

        assertEquals("[{before=[a], between=[]}]", new Matcher().match(al("a", "b", "c"), new MatchList(al(listFiller("before"), "b", listFiller("between"), "c"))).toString());
        assertEquals("[{before=[a], between=[], after=[]}]", new Matcher().match(al("a", "b", "c"), new MatchList(al(listFiller("before"), "b", listFiller("between"), "c", listFiller("after")))).toString());

        assertEquals("[{v=name0, before=[], between=[[first, name1]], after=[[second, name1]]}, " +
                      "{v=name1, before=[[first, name0]], between=[[second, name0]], after=[]}]",
                new Matcher().match(genCommands(2), new MatchList(al(
                        listFiller("before"),
                        al("first", var("v")),
                        listFiller("between"),
                        al("second", var("v")),
                        listFiller("after"))
                )).toString());
    }

    public static void main(String[] args) {
        testPerformance(50);
        testPerformance(100);
        testPerformance(200);
        testPerformance(500);
        testPerformance(1000);
        testPerformance(2000);
        testPerformance(10000);

    }
    
    private static void testPerformance(int count) {
        YList l = genCommands(count);

        StopWatch sw = new StopWatch();
        YSet<YMap<String, Object>> result = new Matcher().match(l, new MatchList(al(listFiller("before"), al("first", var("var")), listFiller("between"), al("second", var("var")), listFiller("after"))));
        System.out.println(result.size());
        sw.stop();
        System.out.println(count + " took: " + sw.toString());
    }

    private static YList genCommands(int count) {
        YList l = al();
        for (int i = 0; i < count; i++) l.add(al("first", "name" + i));
        for (int i = 0; i < count; i++) l.add(al("second", "name" + i));
        return l;
    }

    private static void testPerformance2(int count) {
        YList l = genCommands(count);

        StopWatch sw = new StopWatch();

        YArrayList<Object> first = al("first", var("var"));
        YArrayList<Object> second = al("second", var("var"));
        Matcher matcher = new Matcher();
        YSet<YMap> result1 = hs();
        YSet<YMap> result2 = hs();

        YMap<String, Boolean> res = hm();
        for (int i = 0; i < l.size(); i++) {
            for (YMap m : result1) result2.addAll(matcher.match(l.get(i), second, m));
            result1.addAll(matcher.match(l.get(i), first));
        }

        System.out.println(result2.size());
        sw.stop();
        System.out.println(count + " took: " + sw.toString());
    }

    private static void testPerformance2b(int count) {
        YList l = genCommands(count);

        StopWatch sw = new StopWatch();

        YArrayList<Object> first = al("first", var("var"));
        YArrayList<Object> second = al("second", var("var"));
        Matcher matcher = new Matcher();
        YSet<YMap> result1 = hs();
        YSet<YMap> result2 = hs();

        YMap<String, Boolean> res = hm();
        for (int i = 0; i < l.size(); i++) {
            YMap<String, Object> s = matcher.matchOne(l.get(i), second);
            if (s != null) {
                a:
                for (YMap r1 : result1) {
                    for (String k : s.keySet()) {
                        if (r1.containsKey(k) && !r1.get(k).equals(s.get(k))) {
                            continue a;
                        }
                    }
                    result2.add(r1.with(s));
                }
            }
            result1.addAll(matcher.match(l.get(i), first));
        }

        System.out.println(result2.size());
        sw.stop();
        System.out.println(count + " took: " + sw.toString());
    }

    private static void testPerformance3(int count) {
        YList l = genCommands(count);

        StopWatch sw = new StopWatch();

        YArrayList<Object> first = al("first", var("var"));
        YArrayList<Object> second = al("second", var("var"));
        Matcher matcher = new Matcher();
        YMap<String, Boolean> res = hm();
        for (int i = 0; i < l.size(); i++) {

            YMap<String, Object> f = matcher.matchOne(l.get(i), first);
            if (f != null) {
                String varName = (String) f.get("var");
                res.put(varName, false);
            }

            YMap<String, Object> s = matcher.matchOne(l.get(i), second);
            if (s != null) {
                String varName = (String) s.get("var");
                if (res.containsKey(varName)) {
                    res.put(varName, true);
                }
            }
        }

        System.out.println(res.size());
        sw.stop();
        System.out.println(count + " took: " + sw.toString());
    }

}