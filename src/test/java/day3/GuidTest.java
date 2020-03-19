package day3;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;

public class GuidTest extends TestCase {

    @Test
    public void testGetUniqueId() {

        Guid guid1 = mock(Guid.class);
        assertNotSame("Same UUID ",guid1.getUniqueId(),guid1.getUniqueId());

    }
}