package part2;

import java.util.Map;

public class Ex2 {

    class CsvValidation {
        public void validateProduct(Map<String, String> product) throws Exception {
            for (String key: product.keySet()){
                if (product.get(key).isEmpty())
                    throw new Exception(String.format("Import fail: the product attribute %s is missing",key));
            }
        }
    }
}
