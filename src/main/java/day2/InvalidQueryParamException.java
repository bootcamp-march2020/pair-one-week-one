package day2;

public class InvalidQueryParamException extends RuntimeException {

    InvalidQueryParamException(){
        super("Invalid Query Param passed");
    }
}
