package day2;

import java.util.HashMap;
import java.util.Map;

public class QueryParamParser {

    public Map<String, String> parseQueryParam(String query){
        Map<String,String> output = new HashMap<>();
        String[] pairs = query.split("&");
        for (String pair:pairs){
            String[] keyValue = pair.split("=");
            if (keyValue.length==2)
            output.put(keyValue[0],keyValue[1]);//Not covering edge cases
            else
                throw  new InvalidQueryParamException();

        }
        return output;
    }
}
