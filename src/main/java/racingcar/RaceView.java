package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RaceView {
    private final CarRaceManager raceManager;

    public RaceView(CarRaceManager raceManager) {
        this.raceManager = raceManager;
    }

    public void start() {
        Input input = new Input();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = input.inputCarName();
        raceManager.createCarList(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = input.inputAttemptNumber();
        int attemptNumber = Integer.parseInt(tryNumber);;

        System.out.println("\n실행 결과");
        raceManager.runRace(attemptNumber);

        raceManager.printWinner();
        Console.close();
    }
}