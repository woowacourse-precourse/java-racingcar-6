package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.convert.ConverterHolder;
import racingcar.domain.car.Car;
import racingcar.domain.CarGarage;
import racingcar.domain.TryCount;

import java.util.List;

public class InputView {

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public CarGarage getCars() {
        System.out.println(INPUT_NAME_MESSAGE);
        String input = Console.readLine();
        List<Car> carList = ConverterHolder.convert(input, List.class);
        return new CarGarage(carList);
    }

    public TryCount getTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, TryCount.class);
    }
}
