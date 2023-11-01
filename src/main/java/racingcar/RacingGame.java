package racingcar;

public class RacingGame {
    public void start() {
        String userInput = InputView.requestUserInputNames();

        Cars cars = Cars.createCarList(userInput);

        String runningNumber = InputView.requestRunningCount();

        Integer runningCount = Integer.parseInt(runningNumber);

        progressRound(cars, runningCount);

        announceFinalResult(cars);
    }

    private void progressRound(Cars cars, Integer runningCount) {
        OutputView.noticeRunningResult();

        cars.printCarsGameResult(runningCount);
    }

    private void announceFinalResult(Cars cars) {
        OutputView.noticeFinalWinner();
        OutputView.printWinnerNames(cars.findWinnerCars());
    }
}
