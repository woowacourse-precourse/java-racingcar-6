package racingcar;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        Racing racing = new Racing();
        racing.printSetCarName();
        car.setCarName();
        System.out.println(car.getCarInfo());

        racing.printSetCount();
        racing.setCount();
        System.out.println(racing.getCount());

        racing.printTotalRacing(car.getCarInfo(), racing.getCount());
    }
}
