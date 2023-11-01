package racingcar.view.outputview;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import racingcar.controller.RegisterCarNamesController;
import racingcar.controller.RegisterRoundController;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.Round;

public class DisplayRoundOutputView implements OutputView {
    private static final String DASH = "-";
    private static final String NAME_DASH_FORMAT = "%s : %s\n";
    private static final String DISPLAY_START_MESSAGE = "실행 결과";
    private static final int START_WITH_ZERO = 0;

    @Override
    public void print(Map<String, Object> model) {
        System.out.println(DISPLAY_START_MESSAGE);

        Round round = (Round) model.get(RegisterRoundController.ROUND_KEY);
        RacingCars racingCars = (RacingCars) model.get(RegisterCarNamesController.RACING_CARS_KEY);

        IntStream.range(START_WITH_ZERO, round.getRound())
                .forEach((num) -> displayRoundResult(racingCars));
    }

    private void displayRoundResult(RacingCars racingCars) {
        racingCars.checkEachCar();
        List<Car> cars = racingCars.getRacingCars();
        cars.stream()
                .forEach((car) -> displayCarNameAndPosition(car));
        System.out.println();
    }

    private void displayCarNameAndPosition(Car car) {
        String carName = car.getCarName();
        int distance = car.getDistance();

        System.out.printf(NAME_DASH_FORMAT, carName, convertDistanceToDash(distance));
    }

    private String convertDistanceToDash(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(START_WITH_ZERO, distance)
                .forEach((num) -> stringBuilder.append(DASH));
        return stringBuilder.toString();
    }
}
