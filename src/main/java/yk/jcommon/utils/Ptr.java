package yk.jcommon.utils;

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
}
