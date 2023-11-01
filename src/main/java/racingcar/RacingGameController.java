package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    private GameData gameData;
    private List<Car> cars;

    // GameDate 초기화
    private void initializeGameData() {
        try {
            String carNamesInput = InputView.receiveCarNames();
            String[] carNames = carNamesInput.split(",");
            int tryCount = Integer.parseInt(InputView.getRound());
            gameData = new GameData(carNames, tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
    // Cars 초기화.
    private void initializeCars() {
        cars = new ArrayList<>();
        for (String name : gameData.getCarNames()) {
            cars.add(new Car(name.trim()));
        }
    }

}