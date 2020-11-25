package org.example.homeworkTest4;

import org.example.homework4.Square;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTriangleNestedTest {

    private final Square sq = new Square();

    @Nested
    class Calculation {

        @Test
        void findSquareTriangleWithEquals() {
            assertEquals(6, sq.squareTriangle(5, 4,3));
            assertEquals(0, sq.squareTriangle(5, 2,3));
            assertEquals(0, sq.squareTriangle(0, 0,0));
            assertEquals(NaN,sq.squareTriangle(1,1,5));
            assertEquals(sq.squareTriangle(6, 4, 5), 9.921567416492215);
        }

        @Test
        void findSquareTriangleWithTrue() {
            assertTrue(sq.squareTriangle(6,4,5) < 9.93);
            assertTrue(sq.squareTriangle(6,4,5) > 9.92);
            assertTrue(sq.squareTriangle(6,4,5) != 9.93);
        }

        @Test
        void findSquareTriangleWithFalse() {
            assertFalse(sq.squareTriangle(2,2,3) > 2);
            assertFalse(sq.squareTriangle(2,2,3) < 1);
            assertFalse(sq.squareTriangle(2,2,3) != 1.984313483298443);
        }
    }
}
