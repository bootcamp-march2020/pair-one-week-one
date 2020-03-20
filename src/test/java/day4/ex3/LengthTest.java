package day4.ex3;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class LengthTest  {

    @Test
    public void testComparingDifferentLengthOfDifferentMetricsShouldPass(){
        Length lengthInInches = new Length(1D, Unit.INCHES);
        Length lengthInCM = new Length(2.54D, Unit.CM);

        assertTrue("Should both length be same",lengthInCM.equals(lengthInInches));
        assertTrue("Should both length be same",lengthInInches.equals(lengthInCM));
    }

    @Test
    public void testComparingSameLengthOfDifferentMetricsShouldFail(){
        Length lengthInInches = new Length(1D,Unit.INCHES);
        Length lengthInCM = new Length(1D,Unit.CM);

        assertNotEquals("Both length be not be same",lengthInCM,lengthInInches);
    }




}