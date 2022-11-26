public abstract class DegreesFactory {
    public Convertible convert(double degrees){
        Convertible c = create();
        return c.convert(degrees);
    }
    public abstract Convertible create();
}
