package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import java.util.List;

public class OutputView {
    public final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public void displayGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void displayRaceStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + getFormattedPosition(car.getPosition()));
        }
        System.out.println();
    }


    public String getFormattedPosition(int position) {
        return "-".repeat(position);
    }
}
