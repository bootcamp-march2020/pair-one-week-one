package part1.solution;

abstract class Box {

    protected double w, h;

    public void setWidth(double w) {
        this.w = w;
    }

    public void setHeight(double h) {
        this.h = h;
    }

    public double getWidth() {
        return w;
    }

    public double getHeight() {
        return h;
    }

    protected double getArea() {
        return getWidth()*getHeight();
    }
}

class Rectangle extends Box {

}

class Square extends Box {
    @Override
    public void setHeight(double h) {
        super.setHeight(h);
        setWidth(h);
    }

    @Override
    public void setWidth(double w) {
        super.setWidth(w);
        setHeight(w);
    }
}


class Test {
    boolean test(Box box, int width, int height) {
        box.setWidth(width);
        box.setHeight(height);
        return (width*height) == box.getArea();
    }
}
