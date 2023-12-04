package yk.jcommon.match2;

import yk.ycollections.YMap;
import yk.ycollections.YSet;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 04/05/16
 * Time: 09:45
 */
public interface MatchVarCalc {
    YSet<YMap<String, Object>> calc(YMap<String, Object> cur);
}
