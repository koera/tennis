package com.tdd.tennis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    @Test
    void testLabel__point_zero_should_be_love(){
        assertEquals("LOVE", Score.getLabel(0));
    }

    @Test
    void testLabel__point_one_should_be_fifteen(){
        assertEquals("FIFTEEN", Score.getLabel(1));
    }

    @Test
    void testLabel__point_two_should_be_thirty(){
        assertEquals("THIRTY", Score.getLabel(2));
    }

    @Test
    void testLabel__point_three_should_be_forty(){
        assertEquals("FORTY", Score.getLabel(3));
    }

    @Test
    void testLabel__other_point_should_be_null(){
        assertNull(Score.getLabel(4));
    }

}
