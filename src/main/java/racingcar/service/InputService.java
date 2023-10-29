package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.validate.InputValueValidate;
import racingcar.view.InputView;

import java.util.List;

public class InputService {
    private final CarRepository carRepository;

    public InputService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> inputCarName() {
        InputView.inputCarName();
        String[] inputNames = Console.readLine().split(",");
        return carRepository.save(inputNames);
    }

    public int inputTimes() {
        InputView.howManyTime();
        int times = InputValueValidate.checkTimesException(Console.readLine());
        return times;
    }
}
