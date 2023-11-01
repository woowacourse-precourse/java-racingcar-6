package racingcar;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        car.setCarName();
        System.out.println(car.getCarInfo());
        Racing racing = new Racing();
        racing.printSetCount();
        racing.setCount();
        System.out.println(racing.getCount());
    }
}
