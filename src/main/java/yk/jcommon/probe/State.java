package yk.jcommon.probe;

import yk.ycollections.YList;
import yk.ycollections.YMap;
import yk.ycollections.YSet;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 01/11/15
 * Time: 19:31
 */
public class State {

    public YList<String> stackTrace;
    public Object data;
    public YSet<YMap<String, Object>> match;

    public State(YList<String> stackTrace, Object data) {
        this.stackTrace = stackTrace;
        this.data = data;
    }

    public State(YList<String> stackTrace, Object data, YSet<YMap<String, Object>> match) {
        this.stackTrace = stackTrace;
        this.data = data;
        this.match = match;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        return !(data != null ? !data.equals(state.data) : state.data != null);

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
