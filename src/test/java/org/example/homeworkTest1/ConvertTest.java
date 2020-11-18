package org.example.homeworkTest1;

import org.example.homework1.Convert;
import org.junit.Assert;
import org.junit.Test;

public class ConvertTest {

    @Test
    public void convert()
    {
        Assert.assertTrue("The set second during conversion does not match the time format!", Convert.convertSeconds(86399));
    }

    @Test
    public void rnd()
    {
        Assert.assertEquals("The resulting number is not 2!", Convert.randomNumber(3), 2);
    }

}
