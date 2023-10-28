package racingcar;

import java.util.ArrayList;
import javax.xml.validation.Validator;

public class Controller {

    private static final Controller instance = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return instance;
    }

    public void settingGame() {
        saveCars(getCarsName());
    }


    private static ArrayList<String> getCarsName() {
        String inputString = InputView.inputCarsName();
        ArrayList<String> carNameArrayList = GetNameValidator.validateCarsName(inputString);
        return carNameArrayList;
    }


    private void saveCars(ArrayList<String> carsName) {
    }

    public void startGame() {
        int trialNumber = getTrialNumber();
        while (trialNumber-- > 0) {
            runTrack();
            printEachTrackResult();
        }
    }

    private void runTrack() {
    }

    private void printEachTrackResult() {
    }


    private int getTrialNumber() {
        return 0;
    }

    public void printFianlResult() {
        OutView.printWinner();
    }
}
