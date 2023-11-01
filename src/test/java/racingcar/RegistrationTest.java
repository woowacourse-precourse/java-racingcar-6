package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class RegistrationTest {

    @Test
    void getCarNames_메서드가_문자열을_받아_쉼표를_기준으로_분리해_자동차_이름들의_리스트를_반환() {
        String input = "po bi,woni, jun";
        Registration registration = new Registration();

        List<String> actual = registration.getCarNames(input);

        assertThat(actual).containsExactly("po bi", "woni", " jun");
    }

    @Test
    void createCarList_메서드가_문자열_리스트를_받아_Car_타입_객체의_배열을_생성() {
        List<String> carNameList = Arrays.asList("pobi", "woni", "jun");
        Registration registration = new Registration();

        List<Car> carList = registration.createCarList(carNameList);
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

    @Test
    void getCarNames_메서드가_validateCompetitor_메서드를_호출해_주어진_문자열에_쉼표_구분자가_없으면_예외_발생() {
        String input = "pobi woni jun";
        Registration registration = new Registration();

        assertThatThrownBy(() -> registration.getCarNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getCarNames_메서드가_validateNameLength_메서드를_호출해_자동차_이름이_5자를_넘으면_예외_발생() {
        String input = "pobi,woni,saerayook";
        Registration registration = new Registration();

        assertThatThrownBy(() -> registration.getCarNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getCarNames_메서드가_checkDuplicateName_메서드를_호출해_자동차_이름에_중복이_있으면_예외_발생() {
        String input = "pobi,woni,pobi,saera";
        Registration registration = new Registration();

        assertThatThrownBy(() -> registration.getCarNames(input)).isInstanceOf(IllegalArgumentException.class);
    }

}
