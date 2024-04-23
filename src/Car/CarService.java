package Car;

public class CarService {

    public Car[] getAllCar(){
        return CarDao.getCars();
    }
    //all electric cars
    public Car[] getAllElectricCar(){

        Car[] cars = CarDao.getCars();
        int electricCarCount = 0;
        for (Car car:cars){
            if(car.isElectric())
                electricCarCount=+1;
        }

        Car[] electricCars = new Car[electricCarCount];
        int index =0;

        for (int i=0;i<cars.length;i++){
            if (cars[i].isElectric()){
                electricCars[index] = cars[i];
                index++;
            }
        }
        return electricCars;
    }

    public Car getCar(String registerNumber){
        for (Car car: getAllCar()){
            if (car.getRegisterNumber().equals(registerNumber)){
                return car;
            }
        }
        return null;
    }
}
