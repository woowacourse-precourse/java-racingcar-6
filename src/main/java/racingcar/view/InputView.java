package racingcar.view;

import static racingcar.message.MessageConstants.INPUT_CAR_NAME_MESSAGE;
import static racingcar.message.MessageConstants.INPUT_TRYCOUNT_MESSAGE;
import static racingcar.message.MessageConstants.REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class InputView {

    public Cars inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String inputCarName = Console.readLine();

        String[] nameSplit = inputCarName.split(REGEX);
        List<Car> carList = Arrays.stream(nameSplit)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(carList);
    }

    public int inputTryCount() {
        System.out.println(INPUT_TRYCOUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

}
