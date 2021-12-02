package bgu.spl.mics;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

class FutureTest {



    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Future<Integer> future = new Future<Integer>();
    }
    @org.junit.jupiter.api.Test
    /**
     * basic query
     * **/
    public void testGet() {
        assertNull(future.get());
        Integer result = future.get() + 1;
        future.Resolve(result);
        assertEquals("Expected: future.get() == result.",future.get(),result);

    }

    @org.junit.jupiter.api.Test
    public void testResolve() {
        assertNull("future is initialized with null",future.get());
        Integer result = future.get() + 1;
        future.Resolve(result);
        assertNotNull("future result member should not be null after",future.get());
    }

    @org.junit.jupiter.api.Test
    public void testIsDone() {
        assertTrue("The isResolved field didn't change",isResolved);
        assertNotNull("After using Resolve result field shouldn't be null",future.get());
    }

    @org.junit.jupiter.api.Test
    public void testGet() {
        Integer result = future.get() + 1;
        future.Resolve(result);
        assertNotNull(future.get(0,TimeUnit.MILLISECONDS));
    }
}