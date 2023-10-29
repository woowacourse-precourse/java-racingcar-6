package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayGame {
    public static void runGame() {
        InputView inputView = new InputView();
        List<String> carNamesList = Collections.singletonList(inputView.getCarNameInput());
        String carNamesInput = String.join(",", carNamesList);
        String[] carNames = carNamesInput.split(",");
        int tryCount = inputView.getTryCount();

        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());

        Race race = new Race(cars, tryCount);
        ResultView resultView = new ResultView(cars);
        race.startRace(resultView);

        ResultView.printWinners(race.getWinners());
    }
}
