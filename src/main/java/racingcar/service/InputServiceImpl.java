package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.repository.Repository;
import racingcar.validate.InputValueValidate;
import racingcar.view.InputView;

import java.util.List;

public class InputServiceImpl implements InputService<Car> {
    private final Repository repository;

    public InputServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> inputCarName() {
        InputView.inputCarName();
        String[] inputNames = Console.readLine().split(",");
        return repository.save(inputNames);
    }

    @Override
    public int inputTimes() {
        InputView.howManyTime();
        int times = InputValueValidate.checkTimesException(Console.readLine());
        return times;
    }
}
