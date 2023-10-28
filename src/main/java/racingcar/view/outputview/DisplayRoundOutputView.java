package racingcar.view.outputview;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.Round;

public class DisplayRoundOutputView implements OutputView {
    private static final String DASH = "-";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println("실행 결과");

        Round round = (Round) model.get("round");
        RacingCars racingCars = (RacingCars) model.get("racingCars");

        IntStream.range(0, round.getRound())
                .forEach((num) -> displayRoundResult(racingCars));


    }

    private void displayRoundResult(RacingCars racingCars) {
        // car name, position 구해야 한다
        racingCars.checkEachCar();
        List<Car> cars = racingCars.getRacingCars();
        cars.stream()
                .forEach((car) -> displayCarNameAndPosition(car));
        System.out.println();
    }

    //
    private void displayCarNameAndPosition(Car car) {
        String carName = car.getCarName();
        int distance = car.getDistance();

        System.out.printf("%s : %s\n", carName, convertDistanceToDash(distance));
    }

    private String convertDistanceToDash(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, distance)
                .forEach((num) -> stringBuilder.append(DASH));
        return stringBuilder.toString();
    }
}
