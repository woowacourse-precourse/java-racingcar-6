package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.ExceptionUtil;

public class RacingServiceImpl implements RacingService {

    private final String EMPTY_INPUT_MESSAGE = "자동차 이름을 하나 이상 입력하세요.";
    private static RacingServiceImpl gameService;
    private final CarService carService;

    public RacingServiceImpl(CarService carService) { //TODO: 파라미터가 많아질경우 builder 등 고려하기
        this.carService = carService;
    }

    public static RacingServiceImpl getInstance(CarService carService) {
        if (gameService == null) {
            gameService = new RacingServiceImpl(carService);
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

    @Override
    public void processTryCountInput(String input) {

    }

    private void validateEmptyInput(String input, List<Car> carList) {
        input = input.trim();
        if (input.isEmpty() || carList.isEmpty()) {
            ExceptionUtil.throwInvalidValueException(EMPTY_INPUT_MESSAGE);
        }
    }



}
