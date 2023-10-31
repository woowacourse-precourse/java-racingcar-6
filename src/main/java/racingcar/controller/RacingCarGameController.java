package racingcar.controller;

import racingcar.domain.RacingCar;

import java.util.List;

import static racingcar.service.OutputService.*;
import static racingcar.service.GameService.*;

public class RacingCarGameController {
    public static void startGame() {
        // 자동차 이름 입력
        printRacingCarNameInputForm();
        List<RacingCar> racingCars = createRacingCars();

        // 횟수 입력
        printTimesInputForm();
        long times = readTimes();

        // 게임 진행 및 회차 별 결과 출력
        printGameOutcomeMessage();
        playGameForTimes(times, racingCars);

        // 최종 우승자 출력
        List<RacingCar> winners = findWinners(racingCars);
        printWinners(winners);
    }
}
