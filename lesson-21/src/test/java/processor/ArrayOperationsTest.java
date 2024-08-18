package processor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.bublinoid.processor.ArrayOperations;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


public class ArrayOperationsTest {

    @Test
    public void testOperationArray() {
        int[] inputArray1 = {1, 2, 1, 2, 2};
        int[] resultArray1 = ArrayOperations.operationArray(inputArray1);
        assertArrayEquals(new int[]{2, 2}, resultArray1);

        int[] inputArray2 = {2, 2, 2, 2};
        assertThrows(RuntimeException.class, () -> ArrayOperations.operationArray(inputArray2));
    }
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public void testIsArrayValid(int[] inputArray, boolean expected) {
        assertEquals(expected, ArrayOperations.isArrayValid(inputArray));
    }

    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, true),
                Arguments.of(new int[]{1, 1}, false),
                Arguments.of(new int[]{1, 3}, false),
                Arguments.of(new int[]{1, 2, 2, 1}, true)
        );
    }
}
