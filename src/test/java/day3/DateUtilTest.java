package day3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilTest extends TestCase {

    @Test
    public void testTomorrowDate() {
        DateUtil mocked = mock(DateUtil.class);
        when(mocked.tomorrow()).thenCallRealMethod();

        Calendar cal = Calendar.getInstance();
        when(mocked.getCurrentDate()).thenReturn(cal.getTime());
        cal.add(Calendar.DATE, 1);

        assertEquals("Wrong tomorrow date", cal.getTimeInMillis(), mocked.tomorrow().getTime());
    }

}