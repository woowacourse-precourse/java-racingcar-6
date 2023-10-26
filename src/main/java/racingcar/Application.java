package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.GameConfig;
import racingcar.domain.Race;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameConfig gameConfig = new GameConfig();
        Race race = new Race();
        List<Car> cars = gameConfig.createCars("민지,형빈,민호,jinho");

        System.out.print("시도할 횟수를 입력해주세요 : ");
        gameConfig.setMoveCount(Integer.parseInt(Console.readLine()));

        System.out.println("시도 횟수 = " + gameConfig.moveCount);

        race.startRace(cars, gameConfig.moveCount);


//        for (Car car : cars) {
//            System.out.println(car.getName() + car.getForward());
//        }
    }
}
