package ru.job4j.oop;

public class Triangle {
    private final Point first;
    private final Point second;
    private final Point third;

    public Triangle(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double bc, double ac) {
        return ab + bc > ac && bc + ac > ab && ab + ac > bc;
    }

    public double area() {
        double result = -1;
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ac = first.distance(third);
        double p = period(ab, bc, ac);
        if (this.exist(ab, bc, ac)) {
            result = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return result;
    }
}
