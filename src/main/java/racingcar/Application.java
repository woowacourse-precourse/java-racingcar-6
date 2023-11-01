package racingcar;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        car.setCarName();
        System.out.println(car.getCarInfo());
    }
}
