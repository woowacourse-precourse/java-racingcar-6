package racingcar;

import racingcar.game.Racing;
import racingcar.input.InputManager;
import racingcar.output.OutputManager;

public class Application {
    public static void main(String[] args) {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carNames = InputManager.readCarNames();
        Racing racing = new Racing(carNames);
        System.out.printf("시도할 회수는 몇회인가요?\n");
        int numberOfAttempts = InputManager.readNumberOfAttempts();

        System.out.printf("\n실행 결과\n");
        for (int i = 0; i < numberOfAttempts; i++) {
            racing.moveAllCarsForward();
            OutputManager.printRacingStatus(racing);
        }
        racing.determineWinningCars();
        OutputManager.printRacingResult(racing);
    }
}