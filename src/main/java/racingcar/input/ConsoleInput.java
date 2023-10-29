package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.Car;
import racingcar.validator.Validator;

public class ConsoleInput implements Input {

    private final Validator validator;

    public ConsoleInput(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<Car> receiveCarNamesAndMakeList() {
        String input = validator.validateInputCarName(Console.readLine());
        return getCarList(input);
    }

    @Override
    public int receiveTotalCountOfExecution() {
        String input = validator.validateInputCount(Console.readLine());
        return Integer.parseInt(input);
    }

    private List<Car> getCarList(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .toList();
    }
}
