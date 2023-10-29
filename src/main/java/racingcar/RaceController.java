package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.car.Car;

public class RaceController {
    private RaceController() {
    }

    private RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    private static RaceController raceController;
    private RaceService raceService;

    public static RaceController createRaceController(RaceService raceService) {
        if (raceController == null) {
            raceController = new RaceController(raceService);
        }
        return raceController;
    }

    public void startRaceGame() {
        // 자동차 이름들 입력 안내 뷰
        RaceView.guideRaceCarInput();

        // 입력에 따른 자동차들 생성
        String raceCarNames = Console.readLine();
        List<Car> cars = raceService.getCarsFromInput(raceCarNames);

        // 시도횟수 입력 안내 뷰
        RaceView.guideRoundInput();

        // 입력에 따른 시도횟수 생성
        String roundInput = Console.readLine();
        int round = raceService.getRoundFromInput(roundInput);
    }
}
