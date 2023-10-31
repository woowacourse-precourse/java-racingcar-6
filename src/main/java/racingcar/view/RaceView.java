package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputValidator;

public class RaceView {
    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int inputRaceRound() {
        System.out.println("시도할 횟수는 몇회인가요?");

        String raceRoundString = Console.readLine();
        InputValidator.validateRaceRoundString(raceRoundString);

        int raceRound = Integer.parseInt(raceRoundString);
        InputValidator.validateRaceRound(raceRound);

        Console.close();
        return raceRound;
    }

    public void outputRacingResults() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void outputRacingStatus(String racingStatus) {
        System.out.println(racingStatus);
    }

    public void outputRaceWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
