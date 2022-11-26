public class FahrenheitFactory extends DegreesFactory{
    @Override
    public Convertible create() {
        return new Fahrenheit();
    }
}
