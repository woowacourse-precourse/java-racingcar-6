package racingcar.gameLogic;

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
        roundCount = 0;
    }

    public void run() {
        setCars();
        runRace();
        announceWinners();
    }

    private void setCars() {
        raceOfficial.setDrivers(drivers, user.inputCarName());
    }

    private void runRace() {
        setRounds();
        while (roundCount > 0) {
            runRound();
            roundCount--;
        }
    }

    private void setRounds() {
        roundCount = raceOfficial.setRounds(user.inputNumberOfTry());
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
