package racingcar.view;

import racingcar.domain.dto.RaceResult;

public class OutputView {
    public void printRequestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRequestTotalRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRaceResult(RaceResult raceResult) {
        System.out.println(raceResult);
    }
}
