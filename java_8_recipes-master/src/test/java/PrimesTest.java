import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PrimesTest {
    private Primes calculator = new Primes();

    @Test // Iterative
    public void testIsPrime() {
        IntStream.of(2, 3, 5, 7, 11, 13, 17, 19)
                .forEach(n -> assertTrue(calculator.isPrime(n)));

        assertFalse(calculator.isPrime(4));
    }

    @Test // Functional :)
    public void testIsPrimeWithStreams() {
        assertTrue(Stream.of(2, 3, 5, 7, 11, 13, 17, 19)
                .allMatch(calculator::isPrime));
    }

    @Test
    public void testIsPrimeWithComposites() {
        assertFalse(IntStream.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20)
                .anyMatch(calculator::isPrime));
        assertTrue(IntStream.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20)
                .noneMatch(calculator::isPrime));
    }

    @Test
    public void testNextPrime() {
        assertEquals(2, calculator.nextPrime(1));
        assertEquals(3, calculator.nextPrime(2));
        assertEquals(5, calculator.nextPrime(3));
        assertEquals(5, calculator.nextPrime(4));
        assertEquals(7, calculator.nextPrime(5));
        assertEquals(7, calculator.nextPrime(6));
    }

    @Test
    public void testNextPrimeUsingMap() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 5, 7, 7);

        List<Integer> computed = Stream.of(1, 2, 3, 4, 5, 6)
                .map(calculator::nextPrime)
                .collect(Collectors.toList());

        assertTrue(expected.equals(computed));
    }

    @Test
    public void emptyStreamsDanger() {
        assertTrue(Stream.empty().allMatch(e -> false));
        assertTrue(Stream.empty().noneMatch(e -> true));
        assertFalse(Stream.empty().anyMatch(e -> true));
    }
}