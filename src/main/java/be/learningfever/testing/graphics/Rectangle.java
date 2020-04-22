package be.learningfever.testing.graphics;

import be.learningfever.testing.graphics.exceptions.NegativeNumberException;

import java.util.Objects;

public class Rectangle {
    private int x;
    private int y;
    private double height;
    private double width;

    public Rectangle(int x, int y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public Rectangle(double height, double width) {
        this(0, 0, height, width);
    }

    public Rectangle() {
        this(4, 2);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new NegativeNumberException("Height can't be 0 or lower");
        }
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new NegativeNumberException("Width can't be 0 or lower");
        }
        this.width = width;
    }

    public double getPerimeter() {
        return 2 * ( getHeight() + getWidth() );
    }

    public double getArea() {
        return getHeight() * getWidth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return getX() == rectangle.getX() &&
                getY() == rectangle.getY() &&
                Double.compare(rectangle.getHeight(), getHeight()) == 0 &&
                Double.compare(rectangle.getWidth(), getWidth()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getHeight(), getWidth());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rectangle{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }
}
