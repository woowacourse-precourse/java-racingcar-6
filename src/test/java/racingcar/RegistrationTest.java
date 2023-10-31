package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class RegistrationTest {

    @Test
    void getCarNames_메서드가_문자열을_받아_쉼표를_기준으로_자동차_이름들을_분리() {
        String input = "po bi,woni, jun";
        Registration registration = new Registration();

        String[] actual = registration.getCarNames(input);

        assertThat(actual).containsExactly("po bi", "woni", " jun");
    }

    @Test
    void createCarList_메서드가_문자열_배열을_받아_Car_타입_객체의_배열을_생성() {
        String[] carNames = {"pobi", "woni", "jun"};
        Registration registration = new Registration();

        List<Car> carList = registration.createCarList(carNames);
        List<String> actualName = new ArrayList<>();
        for (Car car : carList) {
            actualName.add(car.getName());
        }
        Set<Integer> actualPosition = new HashSet<>();
        for (Car car : carList) {
            actualPosition.add(car.getPosition());
        }

        assertThat(carList.size()).isEqualTo(3);
        assertThat(actualName).containsExactly("pobi", "woni", "jun");
        assertThat(actualPosition).containsExactly(0);
    }

}
