package yk.lang.yads;

import yk.jcommon.collections.YMap;

import java.util.Objects;

import static yk.jcommon.collections.YHashMap.hm;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 02/11/16
 * Time: 16:49
 */
public class NamedMap {
    public String name;
    public YMap map;

    public NamedMap(String name) {
        this.name = name;
        map = hm();
    }

    public NamedMap(String name, YMap map) {
        this.name = name;
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedMap namedMap = (NamedMap) o;
        return Objects.equals(name, namedMap.name) && Objects.equals(map, namedMap.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, map);
    }

    @Override
    public String toString() {
        return "NamedMap{" +
               "name='" + name + '\'' +
               ", map=" + map +
               '}';
    }
}
