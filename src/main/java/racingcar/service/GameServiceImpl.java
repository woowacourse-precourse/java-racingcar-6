package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.ExceptionUtil;

public class GameServiceImpl implements GameService {

    private final String EMPTY_INPUT_MESSAGE = "자동차 이름을 하나 이상 입력하세요.";
    private static GameServiceImpl gameService;
    private final CarService carService;

    private GameServiceImpl(CarService carService) { //TODO: 파라미터가 많아질경우 builder 등 고려하기
        this.carService = carService;
    }

    public static GameServiceImpl getInstance(CarService carService) {
        if (gameService == null) {
            gameService = new GameServiceImpl(carService);
        }
        return gameService;
    }

    public void processCarNamesInput(String input) {
        List<Car> carList = Arrays.stream(input.split(","))
                .map(carName -> Car.create(carName))
                .collect(Collectors.toList());

        validateEmptyInput(input, carList);

        carList.forEach(car -> carService.join(car));
    }

    private void validateEmptyInput(String input, List<Car> carList) {
        input = input.trim();
        if (input.isEmpty() || carList.isEmpty()) {
            ExceptionUtil.throwInvalidValueException(EMPTY_INPUT_MESSAGE);
        }
    }

}
