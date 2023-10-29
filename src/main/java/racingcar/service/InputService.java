package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.validate.InputValueValidate;
import racingcar.view.OutputView;

import java.util.List;

public class InputService {
    private final CarRepository carRepository;
    private final OutputView outputView;

    public InputService(CarRepository carRepository, OutputView outputView) {
        this.carRepository = carRepository;
        this.outputView = outputView;
    }

    public List<Car> inputCarName() {
        outputView.inputCarName();
        String[] inputNames = Console.readLine().split(",");
        return carRepository.save(inputNames);
    }

    public int inputTimes() {
        outputView.howManyTime();
        int times = InputValueValidate.checkTimesException(Console.readLine());
        return times;
    }
}
