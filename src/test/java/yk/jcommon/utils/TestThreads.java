package yk.jcommon.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static yk.jcommon.utils.Threads.*;
import static yk.ycollections.YArrayList.al;

public class TestThreads {

    @Test
    public void testTick() {
        final int[] counter = {0};
        tick(new Threads.Tickable() {
            @Override
            public void tick(float dt) {
                System.out.println("tick");
                counter[0]++;
                if (counter[0] > 2) exit = true;
            }
        }, 1, 1, null);
        sleep(100);

        assertEquals(3, counter[0]);
    }

    @Test
    public void testFixedTick() {
        Threads.debugLines = al();
        final int[] counter = {0};
        fixedTick(0.01f, false, new Threads.Tickable() {
            @Override
            public void tick(float dt) {
                System.out.println("tick");
                Assert.assertTrue(dt == 0.01f);
                counter[0]++;
                if (counter[0] > 2) exit = true;
            }
        }, null);
        sleep(100);

        assertEquals(3, counter[0]);

        System.out.println(Threads.debugLines.toString("\n"));

        assertEquals(14, debugLines.size());

        Threads.debugLines = null;
    }
}