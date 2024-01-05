package yk.jcommon.utils;

import java.util.Objects;

/**
 * Like a pointer in CPP.
 * Can be used instead of T[] in lambdas.
 * @param <T>
 */
public class Ptr<T> {
    public T value;

    public Ptr() {
    }

    public Ptr(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Ptr{value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ptr<?> ptr = (Ptr<?>) o;
        return Objects.equals(value, ptr.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
