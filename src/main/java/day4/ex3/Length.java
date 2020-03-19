package day4.ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Length {

    private double value;

    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public enum Unit {

        INCHES("Inches"),
        CM("Centi meters");

        String metricSystemName;

        Unit(String metricSystemName) {
            this.metricSystemName = metricSystemName;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        if (unit == length.unit)
            return Double.compare(value, length.value) == 0;
        double value1InCm = Converter.toCentimeters(this);
        double value2InCm = Converter.toCentimeters(length);
        return Double.compare(value1InCm, value2InCm) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }


    public static final class Converter {
        private static final Map<Unit, Double> CONVERSION_MULTIPLIER_MAP = new HashMap<>();

        static {
            CONVERSION_MULTIPLIER_MAP.put(Unit.INCHES, 2.54);
            CONVERSION_MULTIPLIER_MAP.put(Unit.CM, 1.0);
        }

        static double toCentimeters(Length length) {
            Double multiplier = CONVERSION_MULTIPLIER_MAP.get(length.unit);
            if (null == multiplier)
                throw new RuntimeException("Unknown unit type " + length.unit);
            return length.value * multiplier;
        }
    }
}

