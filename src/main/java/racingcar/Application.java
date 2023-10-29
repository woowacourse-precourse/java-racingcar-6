package racingcar;

import racingcar.Model.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car car = new Car();
        Car car2 = new Car();
        car.setCarName("1번");
        car2.setCarName("2번");
        System.out.println(car.getCarName());
        System.out.println(car2.getCarName());
        car.addProgress();
        car.addProgress();
        System.out.println(car.g);
    }
}
