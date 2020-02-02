package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundedSumTest {

    public static final double MULTIPLE_OF_100 = 200.0;
    public static final double NOT_MULTIPLE_OF_100 = 1256.56;

    @Test
    public void given_multiple_of_100_roundedSum_should_return_same_input(){
        RoundedSum roundedSum = new RoundedSum(MULTIPLE_OF_100);
        assertEquals(200, roundedSum.getValue());
    }

    @Test
    public void given_not_multiple_of_100_roundedSum_should_return_rounded_value_to_upper_hundred(){
        RoundedSum roundedSum = new RoundedSum(NOT_MULTIPLE_OF_100);
        assertEquals(1300, roundedSum.getValue());
    }

}