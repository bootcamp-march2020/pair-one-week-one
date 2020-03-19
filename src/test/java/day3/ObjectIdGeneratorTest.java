package day3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ObjectIdGeneratorTest extends TestCase {

    @Test
    public void testGenerateIdUniqueness() {

        Guid mock = mock(Guid.class);
        when(mock.getUniqueId()).thenCallRealMethod();

        ObjectIdGenerator objectIdGenerator = new ObjectIdGenerator(mock);

        String firstUUID = objectIdGenerator.generateId();
        String secondUUID = objectIdGenerator.generateId();

        assertNotSame("Should not be same",firstUUID,secondUUID);
    }
}