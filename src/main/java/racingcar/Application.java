package racingcar;

import racingcar.domain.Car;
import racingcar.domain.GameConfig;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameConfig gameConfig = new GameConfig();
        List<Car> cars = gameConfig.createCars("민지,윤호,민겸,지희,지볌우시,바나바나,보노보노보,하이젠버그,한,민지");

        for (Car car : cars) {
            System.out.println(car.getName());
        }
    }
}
