package racingcar;

import java.util.ArrayList;

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
        return null;
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
