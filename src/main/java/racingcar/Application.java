package racingcar;

import racingcar.enums.Instructions;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String nameInput = inputView.readCarNames();
        RacingCars racingCars = new RacingCars(nameInput);

        int count = inputView.readCount();
        RacingGame racingGame = new RacingGame(racingCars);
        System.out.println(Instructions.RESULT.getInstruction());
        while (count > 0) {
            racingGame.play();
            outputView.printResult(racingCars.getRacingCars());
            count--;
        }

        outputView.printWinners(racingCars.findWinners());
    }
}
