package racingcar;

import racingcar.game.Racing;
import racingcar.game.Winner;
import racingcar.input.InputManager;
import racingcar.output.OutputManager;

public class Application {
    public static void main(String[] args) {
        Racing racing = setupRacing();
        playRacing(racing);
        Winner winner = new Winner(racing.getRacingCars());
        OutputManager.printRacingResult(winner);
    }

    private static Racing setupRacing() {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carNames = InputManager.readCarNames();
        return new Racing(carNames);
    }

    private static void playRacing(Racing racing){
        System.out.printf("시도할 회수는 몇회인가요?\n");
        final int numberOfAttempts = InputManager.readNumberOfAttempts();
        System.out.printf("\n실행 결과\n");
        for (int lap = 0; lap < numberOfAttempts; lap++) {
            racing.moveAllCarsForward();
            OutputManager.printRacingStatus(racing);
        }
    }
}