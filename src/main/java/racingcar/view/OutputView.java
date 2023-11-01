package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RaceGameService;

public class OutputView {

    public void printCarNameInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCarProgressCountInputPrompt() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getProgressCount()));
        }
        System.out.println();
    }


    public void printGameWon(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}