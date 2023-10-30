package racingcar.gameLogic;

import static racingcar.utils.Constants.NO_ROUND;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private RaceOfficial raceOfficial;
    private User user;
    private List<Driver> drivers;
    int roundCount;

    public void init() {
        raceOfficial = new RaceOfficial();
        user = new User();
        drivers = new ArrayList<>();
        roundCount = NO_ROUND;
    }

    public void run() {
        enrollCars();
        runRace();
        announceWinners();
    }

    private void enrollCars() {
        List<String> carNames = user.inputCarName();
        raceOfficial.enrollDrivers(drivers, carNames);
    }

    private void runRace() {
        setRounds();
        while (roundCount > NO_ROUND) {
            runRound();
            roundCount--;
        }
    }

    private void setRounds() {
        roundCount = user.inputNumberOfTry();
        raceOfficial.announceRaceWillBeStarted();
    }

    private void runRound() {
        for (Driver driver : drivers) {
            moveCar(driver);
            handleScore(driver);
        }
        separateRoundOnScreen();
    }

    private void moveCar(Driver driver) {
        driver.pushPedal();
    }

    private void handleScore(Driver driver) {
        raceOfficial.showScore(driver);
        raceOfficial.setHighestScore(driver);
    }

    private void separateRoundOnScreen() {
        raceOfficial.separateRounds();
    }

    private void announceWinners() {
        raceOfficial.announceWinners(drivers);
    }

}
