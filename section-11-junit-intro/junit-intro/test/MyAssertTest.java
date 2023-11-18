import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Different assert methods
class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {
        boolean test = todos.contains("AWS"); // Result
        assertEquals(true, test);
        assertTrue(test, "Somthing went wrong");  // Only for booleans
        assertEquals(3, todos.size(), "Error message");
        assertArrayEquals(new int[] {1, 2}, new int[] {2, 1});  // array contents differ at index [0], expected: <1> but was: <2>
    }
}
