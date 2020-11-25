package org.example.homeworkTest4;

import org.example.homework4.Square;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTriangleRepetitionTest {

    private final Square sq = new Square();

    @RepeatedTest(value = 3, name = "Iteration {currentRepetition} of {totalRepetitions}")
    void findSquareTriangle() {
        assertEquals(6, sq.squareTriangle(5, 4,3));
    }
}
