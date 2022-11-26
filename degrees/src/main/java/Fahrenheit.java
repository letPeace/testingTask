public class Fahrenheit extends Degrees{
    public Fahrenheit(double fahrenheit) {
        super(fahrenheit);
    }
    public Fahrenheit() {
        this(0);
    }
    @Override
    public Convertible convert(double celsius) {
        double fahrenheit = celsius*1.8 + 32;
        setDegrees(fahrenheit);
        return this;
    }
}
