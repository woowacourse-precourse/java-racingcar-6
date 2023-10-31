package racingcar.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.input.CarTest.Car;

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

        public static CarList inputCarList(String stringCarNames) {
            return new CarList(stringCarNames);
        }

        private CarList(String stringCarNames) {
            List<String> carNameList = Arrays.asList(stringCarNames.split(","));
            cars = carNameList.stream()
                    .map(Car::inputCarname)
                    .collect(Collectors.toList());
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
