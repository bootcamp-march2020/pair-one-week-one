package day5;

class Phone {

    private final String areaCode;
    private final String prefix;
    private final String number;

    public Phone(String unformattedNumber) {
        if (unformattedNumber.length() < 10) {
            throw new IllegalArgumentException("Mobile number length is invalid");
        }
        this.areaCode = unformattedNumber.substring(0, 3);
        this.prefix = unformattedNumber.substring(3, 6);
        this.number = unformattedNumber.substring(6, 10);
    }

    public String getMobilePhoneNumber() {
        return "(" +
                areaCode + ") " +
                prefix+ "-" +
                number;
    }

}

public class Customer {
    private Phone mobilePhone;

    public Customer(String phoneNumber) {
        mobilePhone = new Phone(phoneNumber);
    }

    public String getMobileNumber() {
        return mobilePhone.getMobilePhoneNumber();
    }
}