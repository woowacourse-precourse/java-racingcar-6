package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarGarage;
import racingcar.domain.TryCount;
import racingcar.util.TypeConverter;

import java.util.List;

import static racingcar.util.ErrorMessage.ONLY_NUMERIC_ERROR;

public class InputView {

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final TypeConverter converter;

    public InputView(TypeConverter converter) {
        this.converter = converter;
    }

    public CarGarage getCars() {
        System.out.println(INPUT_NAME_MESSAGE);
        String input = Console.readLine();
        List<String> nameList = converter.convertToNameList(input);
        List<Car> cars = converter.convertToCarList(nameList);
        return new CarGarage(cars);
    }

    public TryCount getTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String input = Console.readLine();
        try {
            return new TryCount(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_ERROR.getMessage());
        }
    }
}
