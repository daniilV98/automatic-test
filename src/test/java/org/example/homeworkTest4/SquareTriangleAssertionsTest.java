package org.example.homeworkTest4;

import org.example.homework4.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTriangleAssertionsTest {

    private static Logger logger = LoggerFactory.getLogger(SquareTriangleAssertionsTest.class);

    private final Square sq = new Square();

    @BeforeEach
    void setUpBeforeEach() {
        logger.debug("@BeforeEach - Executed before each test method in this class.");
    }

    @Test
    void findSquareTriangleGroupAssertion() {
        assertAll("all",
//                () -> assertEquals(2,sq.squareTriangle(1,1,4)),
                () -> assertEquals(6, sq.squareTriangle(5, 4,3)),
                () -> assertEquals(0, sq.squareTriangle(5, 2,3)),
                () -> assertEquals(NaN,sq.squareTriangle(1,1,5))/*,
                () -> assertEquals(1,sq.squareTriangle(0,0,0))*/
        );
    }
}
