package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNamesList = Collections.singletonList(inputView.getCarNames());
        String carNamesInput = String.join(",", carNamesList);
        String[] carNames = carNamesInput.split(",");
        int tryCount = inputView.getTryCount();

        List<Cars> cars = Arrays.stream(carNames)
                .map(Cars::new)
                .collect(Collectors.toList());

        Race race = new Race(cars, tryCount);
        ResultView resultView = new ResultView(cars);
        race.startRace(resultView);

        ResultView.printWinners(race.getWinners());
    }
}
