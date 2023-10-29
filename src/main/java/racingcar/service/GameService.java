package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.UserUtil;
import racingcar.validation.CarNameValidator;
import racingcar.validation.GameCountValidator;

public class GameService {

    private static final String DIVISION_STANDARD = ",";

    private final List<Car> carList;
    private int gameCount;

    CarNameValidator carNameValidator = new CarNameValidator();
    GameCountValidator gameCountValidator = new GameCountValidator();

    public GameService() {
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

    private List<String> convertStrToList(String userInput) {
        return Arrays.stream(userInput.split(DIVISION_STANDARD))
                .collect(Collectors.toList());
    }
}
