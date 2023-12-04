package yk.jcommon.utils;

import yk.ycollections.YList;

import java.util.function.Function;

import static yk.ycollections.YArrayList.al;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 12/15/13
 * Time: 10:06 PM
 *
 * Utility methods here try their best to be useful for ad-hoc solutions, simple tests, and experiments.
 * But will fail to support production-ready solutions as it would bring much complexity
 * and still will not satisfy all corner-cases.
 */
@SuppressWarnings("BusyWait")
public class Threads {
    //TODO always store last X lines for exception handling and debugging? (non malloc style)
    public static YList<String> debugLines;

    public static void thread(Executable executable) {
        thread(executable, 100);
    }

    //must return event dispatcher object, so I can listen for Exception?
    //pass this dispatcher to execute as argument, so I can dispatch new events on demand?
    public static void thread(final Executable executable, final long sleepMs) {
        thread(sleepMs, false, executable);
    }

    public static void thread(long sleepMs, boolean daemon, final Executable executable) {
        Thread thread = new Thread(() -> {
            try {
                while (executable.execute()) {
                    Thread.sleep(sleepMs);
                }
            } catch (Throwable t) {
                System.err.println("Error occurred.");
                t.printStackTrace();
            }
        });
        thread.setDaemon(daemon);
        thread.start();
    }

    public static void tick(Tickable tickable, long minDtMs) {
        tick(tickable, minDtMs, 1, null);
    }

    /**
     * Creates a thread. Calls tickable. Provides actual time passed from the last call in seconds (dt).
     * Tries to call it not more often than minDtMs.
     * Will stop the thread if the 'exit' field is set.
     * Will stop the thread if any exception is thrown.
     * If exceptionHandler is provided, then it can decide if the thread should be stopped.
     */
    public static void tick(Tickable tickable, long minDtMs, long sleepMs, Function<Throwable, Boolean> exceptionHandler) {
        if (tickable.exit) BadException.die("tickable should have exit==false on the start");
        Thread result = new Thread(() -> {
            long lastTickMs = System.currentTimeMillis() - minDtMs;//first tick will be executed instantly
            long nextTickAtMs = lastTickMs + minDtMs;
            while (true) {
                try {
                    long curTimeMs = System.currentTimeMillis();
                    if (nextTickAtMs <= curTimeMs) {
                        tickable.tick((curTimeMs - lastTickMs) / 1000f);
                        if (tickable.exit) break;
                        lastTickMs = curTimeMs;
                        nextTickAtMs = lastTickMs + minDtMs;
                    }
                    Thread.sleep(Math.max(sleepMs, nextTickAtMs - curTimeMs));
                } catch (Throwable t1) {
                    try {
                        if (debugLines != null) debugLines.add(stackTraceToLine(t1));
                        if (exceptionHandler != null) {
                            if (exceptionHandler.apply(t1)) continue;
                        } else {
                            System.err.println("Error occurred, no exception handler is defined.");
                            t1.printStackTrace();
                        }
                    } catch (Throwable t2) {
                        System.err.println("Error occurred while handling an exception.");
                        t1.printStackTrace();
                        t2.printStackTrace();
                    }
                    break;
                }
            }
        });
        result.start();
    }

    /**
     * <br>Calls a <b>tickable</b> when a fixed time has passed.
     * <br>The method tries the actual time passed to be equal to <b>dt</b>.
     * But will reset if too much difference (if a lag is accumulating, or the PC was sleeping)
     * <br><b>dt</b> provided to <b>tickable</b> is always equal to <b>dt</b> supplied to this method.
     * <br>It became a little complicated because of the exception handling.
     * <br>If no <b>exceptionHandler</b> is provided - any error will be printed to <b>System.out</b> and the thread will be stopped.
     * <br>If <b>exceptionHandler</b> is provided - then it will be called. If it returns false - the thread will be stopped.
     */
    public static void fixedTick(float dt, boolean daemon, Tickable tickable, Function<Throwable, Boolean> exceptionHandler) {
        if (tickable.exit) BadException.die("tickable should have exit==false on the start");
        Thread thread = new Thread(() -> {
                long lastTickMs = System.currentTimeMillis();
                long dtMs = (long) (dt * 1000f);
                long tooLongMs = -dtMs * 100;
                while (true) {
                    try {
                        if (debugLines != null) debugLines.add(String.format("Exit: %s, time since last tick: %s", tickable.exit, System.currentTimeMillis() - lastTickMs));
                        long timeToTick = lastTickMs + dtMs - System.currentTimeMillis();
                        if (timeToTick < tooLongMs) {
                            String message = String.format("Too big time miss: %s, was expected not more than %s. Resetting.", timeToTick, tooLongMs);
                            if (debugLines != null) debugLines.add(message);
                            System.out.println(message);
                            timeToTick = 0;
                            lastTickMs = System.currentTimeMillis() - dtMs;
                        }

                        if (timeToTick <= 0) {
                            if (debugLines != null) debugLines.add("ticking " + dt);
                            tickable.tick(dt);
                            if (tickable.exit) break;
                            lastTickMs += dtMs;
                            if (debugLines != null) debugLines.add("sleeping 1");
                            Thread.sleep(1);
                        } else {
                            if (debugLines != null) debugLines.add("sleeping " + MyMath.max(1, timeToTick));
                            Thread.sleep(MyMath.max(1, timeToTick));
                        }

                    } catch (Throwable t1) {
                        try {
                            if (debugLines != null) debugLines.add(stackTraceToLine(t1));
                            if (exceptionHandler != null) {
                                if (exceptionHandler.apply(t1)) continue;
                            } else {
                                System.err.println("Error occurred, no exception handler is defined.");
                                t1.printStackTrace();
                            }
                        } catch (Throwable t2) {
                            System.err.println("Error occurred while handling an exception.");
                            t1.printStackTrace();
                            t2.printStackTrace();
                        }
                        break;
                    }
                }
        });
        thread.setDaemon(daemon);
        thread.start();
    }

    public static abstract class Tickable {
        public boolean exit;

        abstract public void tick(float dt) throws Exception;
    }

    public interface Executable {
        boolean execute() throws Exception;
    }

    private static String stackTraceToLine(Throwable t) {
        return al(t.getStackTrace()).toStringPrefixInfix("stacktrace: ", "\n");
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            if (debugLines != null) debugLines.add(stackTraceToLine(e));
            throw new RuntimeException(e);
        }
    }

}
