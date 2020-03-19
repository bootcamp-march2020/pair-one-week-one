package day3;

import java.util.UUID;

public class Guid implements IGuid{

    public Guid(){

    }
    @Override
    public String getUniqueId() {
        return String.valueOf(UUID.randomUUID());
    }

    public void someOtherMethod() {
    }
}