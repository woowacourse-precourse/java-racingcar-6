package racingcar.view;

import racingcar.domain.dto.CarProgressDTO;
import racingcar.domain.dto.RacingCarWinnerDTO;

public class OutputView {
    public void printWelcomeMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printForNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printProgress(CarProgressDTO progress) {
        for (String car : progress.cars()) {
            System.out.println(car);
        }
        System.out.println();
    }


    public void outputResultHeader() {
        System.out.println("실행 결과");
        System.out.println();
    }
}
