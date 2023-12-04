package yk.jcommon.match2;

import yk.jcommon.utils.BadException;
import yk.ycollections.YList;
import yk.ycollections.YMap;
import yk.ycollections.YSet;

import static yk.ycollections.YArrayList.al;
import static yk.ycollections.YHashSet.hs;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 12/09/16
 * Time: 09:48
 */
public class MatchOr implements MatchCustom {
    public YList<Object> variants;

    public MatchOr() {
    }

    public MatchOr(Object... variants) {
        if (variants.length < 2) BadException.die("Variants size should be > 1");
        this.variants = al(variants);
    }

    public MatchOr setVariants(YList<Object> variants) {
        if (variants.size() < 2) BadException.die("Variants size should be > 1");
        this.variants = variants;
        return this;
    }

    @Override
    public YSet<YMap<String, Object>> match(Matcher matcher, Object data, YMap<String, Object> cur) {
        for (Object variant : variants) {
            YSet<YMap<String, Object>> result = matcher.match(data, variant, cur);
            if (result.notEmpty()) return result;
        }
        return hs();
    }

    @Override
    public String toString() {
        return "MatchOr{" +
                "variants=" + variants +
                '}';
    }
}
