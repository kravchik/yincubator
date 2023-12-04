package yk.jcommon.match2;

import yk.ycollections.YMap;
import yk.ycollections.YSet;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 19/08/16
 * Time: 11:02
 */
//TODO rename -> MatchCustomPattern / CustomPattern / MatchPatternCustom
public interface MatchCustom {
    YSet<YMap<String, Object>> match(Matcher matcher, Object data, YMap<String, Object> cur);
}
