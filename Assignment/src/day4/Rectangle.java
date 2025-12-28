package day4;
public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 10;
        this.height = 10;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        if(width <= 0) return;
        this.width = width;
    }   

    public void setHeight(double height) {
        if(height <= 0) return;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }


    public static void main(String[] args) {
        Rectangle r = new Rectangle();

        r.setHeight(5);
        r.setWidth(10);
        System.out.println(r.area());
        System.out.println(r.perimeter());
        System.out.println(r.getWidth());
        System.out.println(r.getHeight());

        r.setHeight(0);
        r.setWidth(-14);
        System.out.println(r.getWidth());
        System.out.println(r.getHeight());
    }
    
}
