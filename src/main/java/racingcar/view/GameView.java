package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class GameView {
    public void displayUserInputCarNamePrompt() {
        displayMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void displayUserInputRoundPrompt() {
        displayMessage("시도할 회수는 몇회인가요?");
    }

    public void displayResultMessage() {
        displayMessage("실행 결과");
    }

    public void displayOneRoundResultMessage(List<Car> cars) {
        for (Car car : cars) {
            car.printStatus();
        }
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }
}
