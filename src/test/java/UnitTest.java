import com.google.common.collect.Maps;
import day2.ex1.InvalidQueryParamException;
import day2.ex1.QueryParamParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class UnitTest {

    @Test
    public void parseValidInputQueryTest(){
        QueryParamParser parser = new QueryParamParser();
        Map<String, String> output =  parser.parseQueryParam("arg1=val1&arg2=val2");
        Map<String, String> expected = new HashMap<>();
        expected.put("arg1","val1");
        expected.put("arg2","val2");
       assertTrue(Maps.difference(expected, output).areEqual());
    }

    @Test(expected = InvalidQueryParamException.class)
    public void invalidQueryParamTest(){
        QueryParamParser parser = new QueryParamParser();
         parser.parseQueryParam("arg1asda");
    }
}
