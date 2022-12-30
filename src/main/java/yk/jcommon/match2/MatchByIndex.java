package yk.jcommon.match2;

import yk.jcommon.collections.YMap;
import yk.jcommon.collections.YSet;
import yk.jcommon.utils.BadException;

import java.lang.reflect.Array;
import java.util.List;

import static yk.jcommon.collections.YHashSet.hs;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 28/10/15
 * Time: 16:43
 */
public class MatchByIndex implements MatchCustom {
    public Object index;
    public Object value;

    public MatchByIndex(Object value) {
        index = new MatchAny();
        this.value = value;
    }

    public MatchByIndex() {
        index = new MatchAny();
    }

    //TODO assert index either Int or Var
    public MatchByIndex(Object index, Object value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public YSet<YMap<String, Object>> match(Matcher matcher, Object data, YMap<String, Object> cur) {
        return match(matcher, data, cur, this.value, this.index);
    }

    private static YSet<YMap<String, Object>> match(Matcher matcher, Object data, YMap<String, Object> cur, Object pattern, Object index) {
        if (data instanceof List) {
            List l = (List) data;
            Object resolvedIndex = matcher.resolve(index, cur);

            if (index instanceof Number) return matcher.match(l.get(((Number) resolvedIndex).intValue()), pattern, cur);
            YSet<YMap<String, Object>> result = hs();
            for (int i = 0; i < l.size(); i++) {
                for (YMap<String, Object> m : matcher.match(l.get(i), pattern, cur)) {
                    if (index == null) result.add(m);
                    else result.addAll(matcher.match(i, resolvedIndex, m));
                }
            }
            return result;
        }
        if (data.getClass().isArray()) {
            Object resolvedIndex = matcher.resolve(index, cur);
            if (resolvedIndex instanceof Number) return matcher.match(Array.get(data, ((Number) resolvedIndex).intValue()), pattern, cur);
            YSet<YMap<String, Object>> result = hs();
            if (!(resolvedIndex instanceof MatchVar) && !(resolvedIndex instanceof MatchAny)) BadException.shouldNeverReachHere("" + resolvedIndex);

            for (int i = 0; i < Array.getLength(data); i++) {
                for (YMap<String, Object> m : matcher.match(Array.get(data, i), pattern, resolvedIndex instanceof MatchVar ? cur.with(((MatchVar) resolvedIndex).name, i) : cur)) {
//                    if (pattern.index == null) result.add(m);
//                    else result.addAll(match(i, index, m));
                    result.add(m);
                }
            }
            return result;
        }
        return hs();
    }
}
