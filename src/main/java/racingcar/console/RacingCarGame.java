package racingcar.console;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarGame {
    public int start = 0;
    public RacingCarService racingCarService;

    public void playGame() {

        racingCarService = new RacingCarService();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<RacingCar> racingCars = racingCarService.initRacingCarMembers();

        System.out.println("시도할 회수는 몇회인가요?");
        int number = racingCarService.initNumberOfAttempts();

        System.out.println("실행 결과");

        while (start < number) {
            racingCars = racingCarService.movingForward(racingCars);
            racingCarService.getRaceResult(racingCars);

            start = racingCarService.addTime(start);
        }

        racingCarService.getFinalWinner(racingCars);
    }
}
