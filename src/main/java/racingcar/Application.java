package racingcar;

public class Application {
    static CarsManage carsManage = new CarsManage();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        carsManage.inputCars();
        carsManage.straightCars();
        for (Car car: carsManage.cars
             ) {
            System.out.println(car.getName() + " "+car.getStraight());
        }
    }
}
