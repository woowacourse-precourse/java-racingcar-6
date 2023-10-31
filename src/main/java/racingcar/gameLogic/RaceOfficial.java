package racingcar.gameLogic;

import java.util.List;
import racingcar.models.ScoreBoard;
import racingcar.views.OutputViewer;

public class RaceOfficial {
    private final ScoreBoard scoreBoard = new ScoreBoard();

    public void enrollDrivers(List<Driver> drivers, List<String> carNames) {
        for (String carName : carNames) {
            drivers.add(new Driver(carName));
        }
    }

    public void announceRaceWillBeStarted() {
        OutputViewer.printNoticeResultWillBePrinted();
    }

    public void showScore(Driver driver) {
        String carName = driver.sayCarName();
        int movedDistance = driver.sayMovedDistance();

        OutputViewer.printMovedDistanceOfCar(carName, movedDistance);
    }

    public void setHighestScore(Driver driver) {
        int highestScore = compareScores(driver.sayMovedDistance(), scoreBoard.getHighScore());
        scoreBoard.setHighScore(highestScore);
    }

    private int compareScores(int driverScore, int highestScore) {
        return Math.max(driverScore, highestScore);
    }

    public void separateRounds() {
        OutputViewer.printBlank();
    }

    public void announceWinners(List<Driver> drivers) {
        rankDrivers(drivers);
        OutputViewer.printWinners(scoreBoard.getWinners());
    }

    private void rankDrivers(List<Driver> drivers) {
        for (Driver driver : drivers) {
            rankDriver(driver);
        }
    }

    private boolean isWinner(Driver driver) {
        return driver.sayMovedDistance() == scoreBoard.getHighScore();
    }

    private void rankDriver(Driver driver) {
        if (isWinner(driver)) {
            scoreBoard.addWinner(driver.sayCarName());
        }
    }

    public int showHighestScore() {
        return scoreBoard.getHighScore();
    }

    public List<String> showWinnerList() {
        return scoreBoard.getWinners();
    }

}
