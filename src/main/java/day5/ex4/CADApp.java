package day5.ex4;

import java.awt.*;

interface Shape {
    void draw(Graphics graphics);
}

class Circle implements Shape {

    Point center;
    int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawCircle(center, radius);
    }
}

class Rectangle implements Shape {

    Point p1;
    Point p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRectangle(p1, p2);
    }
}

class Line implements Shape {

    Point p1;
    Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawLine(p1, p2);
    }
}

class Graphics {
    public void drawLine(Object point1, Object point2) {
        System.out.println("Line!");
    }

    public void drawRectangle(Object point1, Object point2) {
        System.out.println("Rectangle!");
    }

    public void drawCircle(Object point, Object radius) {
        System.out.println("Circle!");
    }
}

public class CADApp {
    void drawShapes(Graphics graphics, Shape[] shapes) {
        for (Shape shape : shapes)
            shape.draw(graphics);
    }
}