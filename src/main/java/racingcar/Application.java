package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;
import racingcar.domain.RacingCar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RaceController race = new RaceController();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        List<RacingCar> racingCarList = race.ready(carInput);

        System.out.println("시도할 회수는 몇회인가요?");
        String roundInput = Console.readLine();
        race.setRound(Integer.parseInt(roundInput));

        race.start(racingCarList);
        race.finish(racingCarList);
    }
}
