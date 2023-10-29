package racingcar.domain.race;

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
        System.out.println(RaceView.printGuideRaceCarInput());

        // 입력에 따른 자동차들 생성
        String raceCarNames = Console.readLine();
        List<Car> cars = raceService.getCarsFromInput(raceCarNames);

        // 시도횟수 입력 안내 뷰
        System.out.println(RaceView.printGuideRoundInput());

        // 입력에 따른 시도횟수 생성
        String roundInput = Console.readLine();
        int round = raceService.getRoundFromInput(roundInput);

        // 시도 횟수만큼 게임 진행
        System.out.println(RaceView.printGuideResult());
        raceService.raceForRounds(cars, round);

        // 우승자 구하기
        List<Car> winners = raceService.getWinners(cars);
        System.out.println(RaceView.printWinners(winners));
    }
}
