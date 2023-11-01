package racingcar;

public class RacingGame {
    public void start() {
        String userInput = InputView.requestUserInputNames();

        Cars cars = Cars.createCarList(userInput);

        String runningNumber = InputView.requestRunningCount();

        progressRound(cars, runningNumber);

        announceFinalResult(cars);
    }

    private void progressRound(Cars cars, String runningNumber) {

        Integer runningCount = Integer.parseInt(runningNumber);

        OutputView.noticeRunningResult();

        cars.printCarsGameResult(runningCount);
    }

    private void announceFinalResult(Cars cars) {

        OutputView.noticeFinalWinner();
        OutputView.printWinnerNames(cars.findWinnerCars());
    }
}
