public class Circle {
    protected double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

   
    public String toString() {
        return "Circle: radius=" + radius;
    }
}

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super(); // Invoke the default constructor of the superclass Circle
        this.height = 1.0;
    }

    public Cylinder(double radius, double height) {
        super(radius); // Invoke the constructor of the superclass Circle with the radius parameter
        this.height = height;
    }

    public double getHeight() {
        return height;
    }


    public double getArea() {
        return 2 * Math.PI * radius * height + 2 * super.getArea();
    }

    public double getVolume() {
        return super.getArea() * height;
    }


    public String toString() {
        return "Cylinder: subclass of " + super.toString() + " height=" + height;
    }
}

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println(c1.toString());
        System.out.println("Area: " + c1.getArea());
        System.out.println("Volume: " + c1.getVolume());

        Cylinder c2 = new Cylinder(10.0, 1.0);
        System.out.println(c2.toString());
        System.out.println("Area: " + c2.getArea());
        System.out.println("Volume: " + c2.getVolume());

        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println(c3.toString());
        System.out.println("Area: " + c3.getArea());
        System.out.println("Volume: " + c3.getVolume());
    }
}
