package racingcar.innout;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.TryCount;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputPrint {

    private final OutputPrint outputPrint;

    public InputPrint(OutputPrint outputPrint) {
        this.outputPrint = outputPrint;
    }

    public CarList inputCarName() {
        outputPrint.printInputRacing();
        String input = Console.readLine();
        String[] split = input.split(",");

        List<Car> cars = Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());

        return new CarList(cars);
    }

    public TryCount inputTryCount() {
        outputPrint.printInputTryCount();
        String input = Console.readLine();
        return new TryCount(input);
    }
}
