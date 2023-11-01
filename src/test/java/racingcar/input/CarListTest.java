package racingcar.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.input.CarTest.Car;
import racingcar.input.InputValidatorTest.InputValidator;
import racingcar.output.MessageTypeTest.MessageType;
import racingcar.output.OutputCarRaceTest.OutputCarRace;

public class CarListTest {
    private static String 차이름들;
    private static String 차이름;

    private static void 차이름_n개_입력하라(int count) {
        차이름 = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(i).append(",");
        }

        차이름들 = sb.toString();
    }

    public static class CarList {
        private List<Car> cars = new ArrayList<>();

        public static CarList inputCarList(final String stringCarNames) {
            return new CarList(stringCarNames);
        }

        private CarList(final String stringCarNames) {
            OutputCarRace.print(MessageType.INPUT_CAR_NAME_PRINT);

            List<String> carNameList = Arrays.asList(stringCarNames.split(","));
            cars = carNameList.stream()
                    .map(Car::inputCarname)
                    .collect(Collectors.toList());

            InputValidator.validateCarList(cars);

            OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, stringCarNames);
        }

        public List<Car> getCarList() {
            return Collections.unmodifiableList(cars);
        }

    }

    @Test
    void 자동차이름_쉼표_구분_정상() {
        차이름_n개_입력하라(1000);

        CarList carList = CarList.inputCarList(차이름들);
        List<Car> cars = carList.getCarList();

        assertThat(cars.size()).isEqualTo(1000);
    }
}
