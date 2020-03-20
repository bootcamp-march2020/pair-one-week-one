package day4.ex3;

import java.util.Objects;

public final class Length {

    private final double value;

    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        if (unit == length.unit)
            return Double.compare(value, length.value) == 0;
        double value1InCm = unit.toCentimeters(this);
        double value2InCm = length.unit.toCentimeters(length);
        return Double.compare(value1InCm, value2InCm) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}

enum Unit {

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

