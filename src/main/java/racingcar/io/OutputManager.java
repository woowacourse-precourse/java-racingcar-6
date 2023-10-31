package racingcar.io;



import racingcar.game.Car;

import javax.sound.midi.Soundbank;
import java.util.List;

public class OutputManager {

    public void printReamNames() {
        System.out.println(CommonMessages.READ_NAMES.getMessage());
    }

    public void printReadTrial() {
        System.out.println(CommonMessages.READ_TRIAL.getMessage());
    }

    public void printResult() {
        System.out.println(CommonMessages.GAME_RESULT.getMessage());
    }

    public void printRoundResult(List<Car> carList) {
        System.out.println(CommonMessages.roundResult(carList));
    }

    public void printWinner(List<String> winnerList) {
        System.out.println(CommonMessages.printWinner(winnerList));
    }
}
