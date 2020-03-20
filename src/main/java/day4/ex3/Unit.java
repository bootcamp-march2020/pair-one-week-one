package day4.ex3;

public enum Unit {

    INCHES("Inches",2.54D),
    CM("Centi meters",1D);

    String metricSystemName;
    double conversionMultiplier;

    Unit(String metricSystemName, double conversionMultiplier) {
        this.metricSystemName = metricSystemName;
        this.conversionMultiplier = conversionMultiplier;
    }

    double toCentimeters(Length length) {
        return length.getValue() * conversionMultiplier;
    }
}