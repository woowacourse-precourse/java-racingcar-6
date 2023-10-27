package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.model.RaceTrackHistory;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_POSITION_FORMAT = "%s : %s";
    private static final String POSITION_REPRESENTATION = "-";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printGameResult(RaceTrackHistory raceTrackHistory) {
        System.out.println(GAME_RESULT_MESSAGE);
        List<CarGroup> raceSteps = raceTrackHistory.getHistorySteps();
        for (CarGroup currentStepCars : raceSteps) {
            List<Car> cars = currentStepCars.getCars();
            printCarsPosition(cars);
            printEmptyLine();
        }
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
    }

    private void printCarPosition(Car car) {
        String resultString = formatCarPosition(car.getName(), car.getPosition());
        System.out.println(resultString);
    }

    private String formatCarPosition(String name, int position) {
        return String.format(CAR_POSITION_FORMAT, name, POSITION_REPRESENTATION.repeat(position));
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
