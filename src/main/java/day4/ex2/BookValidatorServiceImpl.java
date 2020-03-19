package day4.ex2;

public class BookValidatorServiceImpl implements BookValidatorService {

    @Override
    public boolean isValid(Book book) {
        if (book == null) return false;
        if ("bot".equals(book.getName())) {
            return false;
        } else {
            return true;
        }
    }
}
