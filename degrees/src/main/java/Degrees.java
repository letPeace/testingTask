import lombok.ToString;

@ToString
public abstract class Degrees implements Convertible{
    private double degrees;
    public Degrees(double degrees) {
        this.degrees = degrees;
    }
    public double getDegrees() {
        return degrees;
    }
    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }
}
