package racingcar.io;



import racingcar.game.Car;

import javax.sound.midi.Soundbank;
import java.util.List;

public class OutputManager {

    public void printReamNames() {
        System.out.println(CommonMessages.READ_NAMES);
    }

    public void printReadTrial() {
        System.out.println(CommonMessages.READ_TRIAL);
    }

    public void printRoundResult(List<Car> carList) {
        System.out.println(CommonMessages.roundResult(carList));
    }
}
