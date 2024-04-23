package Car;

public class CarDao {
    private static final Car[] CARS ={
        new Car("1234",10.50,"TESLA" ,true),
            new Car("3302",3.90,"BMW" ,true),
        new Car("2293",5.9,"HONDA",false),
            new Car("4444",4.76,"TOYOTA",false),
            new Car("2293",5.9,"AUDI",true),
    };

    public static Car[] getCars(){
        return CARS;
    }
}
