package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class InputView {

    public static final String INPUT_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)";
    public static final String INPUT_TRYCOUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String REGEX = ",";

    public Cars inputCarName() {
        System.out.println(INPUT_CARNAME_MESSAGE);
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
