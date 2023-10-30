package racingcar.gameLogic;

import java.util.List;
import racingcar.views.OutputViewer;

public class RaceOfficial {
    public int highestScore = 0;

    public void setHighestScore(Driver driver) {
        highestScore = Math.max(driver.sayMovedDistance(), highestScore);
    }

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

    public void separateRounds() {
        requestPrintRoundSeparator();
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
}
