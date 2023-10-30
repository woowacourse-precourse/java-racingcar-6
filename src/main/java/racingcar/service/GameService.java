package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.UserUtil;
import racingcar.validation.CarNameValidator;
import racingcar.validation.GameCountValidator;

public class GameService {

    private static final String DIVISION_STANDARD = ",";

    private final CarNameValidator carNameValidator;
    private final GameCountValidator gameCountValidator;
    private final List<Car> carList;
    private int gameCount;

    public GameService(CarNameValidator carNameValidator, GameCountValidator gameCountValidator) {
        this.carNameValidator = carNameValidator;
        this.gameCountValidator = gameCountValidator;
        carList = new ArrayList<>();
    }

    public void getCarList() {
        String userInput = UserUtil.getUserInput();
        List<String> userInputList = convertStrToList(userInput);
        carNameValidator.validateCarName(userInputList);
        userInputList.stream()
                .forEach(carName -> carList.add(Car.nameFrom(carName)));
    }

    public void getGameCount() {
        String userInput = UserUtil.getUserInput();
        gameCountValidator.validateGameCount(userInput);
        gameCount = Integer.parseInt(userInput);
    }

    public void playGame() {
        for (int count = 0; count < gameCount; count++) {
            for (Car carList : carList) {
                carList.play();
                carList.printGameProceed();
            }
            System.out.println();
        }
    }

    private List<String> findWinner() {
        int maxPosition = carList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<String> convertStrToList(String userInput) {
        return Arrays.stream(userInput.split(DIVISION_STANDARD))
                .collect(Collectors.toList());
    }
}
