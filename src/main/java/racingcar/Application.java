package racingcar;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        Racing racing = new Racing();
        racing.printSetCarName();
        car.setCarName();

        racing.printSetCount();
        racing.setCount();

        racing.printTotalRacing(car.getCarInfo(), racing.getCount());
    }
}
