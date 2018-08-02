package driver;


import java.util.Scanner;

public class Driver {

    public static void main(String... str) {
        int choice = 0;
        int c2 = 0;
        int c3 = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter");
        System.out.println("1)Two dimensional shape");
        System.out.print("2)Three dimensional shape:");
        choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Enter");
            System.out.println("1)Circle");
            System.out.println("2)Square");
            System.out.print("3)Triangle:");
            c2 = sc.nextInt();

            
            switch (c2) {
                case 1:
                    System.out.print("Enter radius of circle:");
                    double rad = sc.nextDouble();
                   
                    TwoDimensionalShape c = new Circle(rad);
                    
                    System.out.println("Area: " + c.getArea() + " ");
                    System.out.println("Perimeter:v" + String.format("%.2f", c.getPerimeter()));
                    break;

                case 2:
                    System.out.print("Enter side of square:");
                    double side1 = sc.nextDouble();

                    TwoDimensionalShape s = new Square(side1);

                    System.out.println("Area: " + s.getArea());
                    System.out.println("Perimeter:" + String.format("%.2f", s.getPerimeter()));
                    break;

                case 3:
                    System.out.print("Enter side of triangle:");
                    double s1 = sc.nextDouble();
                    

                    System.out.print("Enter side of triangle:");
                    double s2 = sc.nextDouble();
                    

                    System.out.print("Enter side of triangle:");
                    double s3 = sc.nextDouble();
                    

                    
                    

                    TwoDimensionalShape r = new Triangle(s1, s2, s3);
                    System.out.println("Area: " + r.getArea() + " ");
                    System.out.println("Perimeter: " + String.format("%.2f", r.getPerimeter()));
                    break;
            }
        } else if (choice == 2) {
            System.out.println("Enter");
            System.out.println("1)Sphere");
            System.out.println("2)Cube");
            System.out.print("3)Tetrahedron:");
            c3 = sc.nextInt();

            
            switch (c3) {
                case 1:
                    System.out.print("Enter radius of sphere:");
                    double radx = sc.nextDouble();
                    

                    ThreeDimensionalShape cc2 = new Sphere(radx);

                    System.out.println("Surface area: " +  String.format("%.2f", cc2.getArea()) + " ");
                    System.out.println("Volume: " + String.format("%.2f", cc2.getVolume()));
                    break;

                case 2:
                    
				System.out.print("Enter side of cube: ");
                    double sx = sc.nextDouble();
                   

                    ThreeDimensionalShape cc1 = new Cube(sx);

                    System.out.println("Area: " + String.format("%.2f", cc1.getArea()) + " ");
                    System.out.println("Volume: " + String.format("%.2f", cc1.getVolume()));
                    break;

                case 3:
                    System.out.print("Enter side of tetrahedron: ");
                    double tx = sc.nextDouble();
                    

                    ThreeDimensionalShape cc3 = new Tetrahedron(tx);

                    System.out.println("Area: " + cc3.getArea() + " ");
                    System.out.println("Volume: " + cc3.getVolume());
                    break;
            }
        } else {
            System.out.println("choice is invalid");
        }
        sc.close();
    }

}

abstract class Shape {

}

abstract class TwoDimensionalShape extends Shape {
    abstract double getArea();

    abstract double getPerimeter();
}

abstract class ThreeDimensionalShape extends Shape {

    public abstract double getArea();

    public abstract double getVolume();

}

class Circle extends TwoDimensionalShape {
    private double radius;

    Circle(double r) {
        radius = r;
    }

    public double getArea() {
        double area = Math.PI * Math.pow(radius, 2);
        
        return Math.round(area * 100.00) / 100.00;
    }

    public double getPerimeter() {
        double peri = 2 * Math.PI * radius;
        return Math.round(peri * 100.00) / 100.00;
    }
}

class Square extends TwoDimensionalShape {
    private double side;

    Square(double s) {
        side = s;
    }

    public double getArea() {
        double area = Math.pow(side, 2);
        return Math.round(area * 100.0) / 100.0;
    }

    public double getPerimeter() {
        double peri = side + side + side + side;
        return Math.round(peri * 100.0) / 100.0;
    }
}

class Triangle extends TwoDimensionalShape {
    private double base;
    private double side2;
    private double side3;
    

    Triangle(double s1, double s2, double s3) {
        base = s1;
        side2 = s2;
        side3 = s3;
        
        
    }

    public double getArea() {
    	double s = (base + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - base) * (s - side2) * (s - side3)); 
        return Math.round(area * 100.0) / 100.0;
    }

    public double getPerimeter() {
        double peri = base + side2 + side3;
        return Math.round(peri * 100.0) / 100.0;
    }
}

class Cube extends ThreeDimensionalShape {
    private double side;

    Cube(double s) {
        side = s;
    }

    public double getArea() {
        double area = 6 * Math.pow(side, 2);
        return area;
    }

    public double getVolume() {
        double volume = Math.pow(side, 3);
        return Math.round(volume * 100.00) / 100.00;
    }
}

class Sphere extends ThreeDimensionalShape {
    private double radius;

    Sphere(double r) {
        radius = r;
    }

    public double getArea() {
        double area = 4 * Math.PI * Math.pow(radius, 2);
        return Math.round(area * 100.0) / 100.0;
    }

    public double getVolume() {
        double volume = (1.33333 * Math.PI * Math.pow(radius, 3));
        return Math.round(volume * 100.0) / 100.0;
    }
}

class Tetrahedron extends ThreeDimensionalShape {
    private double edge;

    Tetrahedron(double s) {
        edge = s;
    }

    public double getArea() {
        double area =  Math.sqrt(3) * Math.pow(edge, 2);
        return Math.round(area * 100.00) / 100.00;
    }

    public double getVolume() {
        double volume = Math.pow(edge, 3) / (6 * Math.sqrt(2));
        return Math.round(volume * 100.00) / 100.00;
    }
}