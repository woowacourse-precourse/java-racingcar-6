package racingcar;

import racingcar.domain.Car;
import racingcar.method.RacingCar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar racingCar = new RacingCar();
        ArrayList<Car> car_list = racingCar.createCarList();
        Integer count = racingCar.countRacingGame();

        System.out.println("\n실행결과");
        while (count-- != 0) {
            racingCar.playRacingGame(car_list);
        }
    }
}
