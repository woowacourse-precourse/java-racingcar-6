package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class GameView {
    public void promptForCarNames() {
        displayMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void promptForRoundCount() {
        displayMessage("시도할 회수는 몇회인가요?");
    }

    public void displayExecutionResults() {
        displayMessage("실행 결과");
    }

    public void displayRoundResults(List<Car> cars) {
        for (Car car : cars) {
            car.printStatus();
        }
    }

    public void displayWinners(List<String> winnerNames) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", winnerNames);
        System.out.print(result);
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }
}
