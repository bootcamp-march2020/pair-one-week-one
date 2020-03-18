package part1;

class Rectangle {
    double w, h;

    void setWidth(double w) {
        this.w = w;
    }

    void setHeight(double h) {
        this.h = h;
    }

    double getWidth() {
        return w;
    }

    double getHeight() {
        return h;
    }
}

class Square extends Rectangle {
    void setWidth(double w) {
        this.w = w;
        this.h = w;
    }

    void setHeight(double h) {
        this.w = h;
        this.h = h;
    }

    double getWidth() {
        return w;
    }

    double getHeight() {
        return h;
    }
}

class Test {
    boolean test(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        return 5 * 4 == r.getWidth() * r.getHeight();
    }
}
