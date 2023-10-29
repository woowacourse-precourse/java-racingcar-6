package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Car> readCarNames() {
        String input = Console.readLine();
        return Arrays.stream(input.split(",")).map(Car::new).toList();
    }

    public AttemptCount readAttemptCount() {
        String input = Console.readLine();
        return new AttemptCount(Integer.parseInt(input));
    }
}
