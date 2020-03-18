package day2.ex1;

public class InvalidQueryParamException extends RuntimeException {

    InvalidQueryParamException(){
        super("Invalid Query Param passed");
    }
}
