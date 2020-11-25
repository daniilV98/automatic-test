package org.example.homeworkTest4;

import org.example.homework4.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

public class SquareTriangleAssumptionTest {

    Square sq = new Square();

    @Test
    void findSquareTriangleTestAssumption() {
        assumeTrue(false);
        assertEquals(sq.squareTriangle(6, 4, 5), 9.921567416492215);
    }

    @Test
    void trueAssumption() {
        assumeTrue(9.93 > 9.22);
        assertEquals(sq.squareTriangle(6, 4, 5), 9.921567416492215);
    }

    @Test
    void falseAssumption() {
        assumeFalse(9.93 < 9.22);
        assertEquals(sq.squareTriangle(6, 4, 5), 9.921567416492215);
    }
}
