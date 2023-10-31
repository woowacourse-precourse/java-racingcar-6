package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.ExceptionUtil;

public class RacingServiceImpl implements RacingService {

    private final String EMPTY_INPUT_MESSAGE = "자동차 이름을 하나 이상 입력하세요.";
    private final CarService carService;
    private final CarRepository carRepository;
    private final RacingRepository racingRepository;

    public RacingServiceImpl(CarRepository carRepository, RacingRepository racingRepository) {
        this.carRepository = carRepository;
        this.racingRepository = racingRepository;
    }

    @Override
    public Racing generateRacing(String carNames, String strTryCount) {
        List<Car> carList = processCarNamesInput(carNames); //TODO: 기능분리 리팩터링하기
        Participations participations = new Participations(carList);
        int tryCount = processTryCountInput(strTryCount);

        return Racing.create(participations, tryCount);
    }


    public RacingServiceImpl(CarService carService) { //TODO: 파라미터가 많아질경우 builder 등 고려하기
        this.carService = carService;
    }

    public void processCarNamesInput(String input) {
        List<Car> carList = Arrays.stream(input.split(","))
                .map(carName -> Car.create(carName))
                .collect(Collectors.toList());

        validateEmptyInput(input, carList);

        carList.forEach(car -> carService.join(car));
    }

    private int processTryCountInput(String input) {
        input = StringUtil.trimSpaces(input);
        IntegerValidator.validateInteger(input);

        return Integer.parseInt(input);
    }

    private void validateEmptyInput(String input, List<Car> carList) {
        input = StringUtil.trimSpaces(input);
        if (input.isEmpty() || carList.isEmpty()) {
            ExceptionUtil.throwInvalidValueException(EMPTY_INPUT_MESSAGE);
        }
    }


}
