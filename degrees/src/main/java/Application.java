public class Application {
    public static void main(String[] args){
        Application application = new Application();
        application.init();
    }
    private void init(){
        double celsius = 42;
        // init kelvin factory
        DegreesFactory kelvinFactory = new KelvinsFactory();
        Convertible kelvins = kelvinFactory.convert(celsius);
        // init fahrenheit factory
        DegreesFactory fahrenheitFactory = new FahrenheitFactory();
        Convertible fahrenheit = fahrenheitFactory.convert(celsius);
        // print the result
        print(kelvins);
        print(fahrenheit);
    }
    private void print(Convertible degrees){
        final int n = 10;
        degrees.setDegrees((double)((int)(degrees.getDegrees()*n))/n); // to have 'n' decimal places
        System.out.println(degrees);
    }
}
