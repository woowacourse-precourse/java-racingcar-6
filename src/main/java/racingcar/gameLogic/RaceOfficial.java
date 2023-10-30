package racingcar.gameLogic;

import java.util.List;
import racingcar.models.ScoreBoard;
import racingcar.views.OutputViewer;

public class RaceOfficial {
    private final ScoreBoard scoreBoard = new ScoreBoard();

    public void setDrivers(List<Driver> drivers, List<String> carNames) {
        for (String carName : carNames) {
            drivers.add(new Driver(carName));
        }
    }

    public int setRounds(int numberOfTry) {
        requestPrintNoticeResultWillBePrinted();
        return numberOfTry;

    }

    public void showScore(Driver driver) {
        requestPrintMovedDistance(driver);
    }

    public void setHighestScore(Driver driver) {
        int highestScore = Math.max(driver.sayMovedDistance(), scoreBoard.getHighScore());
        scoreBoard.setHighScore(highestScore);
    }

    public void separateRounds() {
        requestPrintRoundSeparator();
    }

    public void announceWinners(List<Driver> drivers) {
        determineWinners(drivers);
        requestPrintWinners();
    }

    public void determineWinners(List<Driver> drivers) {
        for (Driver driver : drivers) {
            if (isWinner(driver)) {
                addToWinnerList(driver);
            }
        }
    }

    public boolean isWinner(Driver driver) {
        return driver.sayMovedDistance() == scoreBoard.getHighScore();
    }

    public void addToWinnerList(Driver driver) {
        scoreBoard.addWinner(driver.sayCarName());
    }

    public int showHighestScore() {
        return scoreBoard.getHighScore();
    }

    public List<String> showWinnerList() {
        return scoreBoard.getWinners();
    }

    private void requestPrintNoticeResultWillBePrinted() {
        OutputViewer.printNoticeResultWillBePrinted();
    }

    private void requestPrintMovedDistance(Driver driver) {
        String carName = driver.sayCarName();
        int movedDistance = driver.sayMovedDistance();

        OutputViewer.printMovedDistanceOfCar(carName, movedDistance);
    }

    private void requestPrintRoundSeparator() {
        OutputViewer.printBlank();
    }

    private void requestPrintWinners() {
        OutputViewer.printWinners(scoreBoard.getWinners());
    }
}
