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

        IntStream.range(0, runningCount).forEach(i -> progressOneRound(cars));
    }

    private void progressOneRound(Cars cars) {
        cars.moveAllCars();

        OutputView.printCarStatus(cars.convertCarToMap());
    }

    private void announceFinalResult(Cars cars) {

        OutputView.noticeFinalWinner();
        OutputView.printWinnerNames(cars.findWinnerCars());
    }
}
