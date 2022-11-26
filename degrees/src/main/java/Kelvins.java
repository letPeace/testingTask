public class Kelvins extends Degrees{
    public Kelvins(double kelvins) {
        super(kelvins);
    }
    public Kelvins() {
        this(0);
    }
    @Override
    public Convertible convert(double celsius) {
        double kelvins = celsius + 273;
        setDegrees(kelvins);
        return this;
    }
}
