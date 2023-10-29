package racingcar;

import domain.Car;
import domain.CarName;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.NameValidator;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("문자열을 구분하고 자동차 객체를 저장하는 기능")
    @Test
    void inputCarNamesTest() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun".getBytes()));
        List<String> answer = new ArrayList<>() {
            {
                add("pobi");
                add("woni");
                add("jun");
            }
        };
        Cars cars = new Cars();

        InputView.inputCarNames()
                .forEach(name -> cars.insertCar(new Car(new CarName(name))));
        List<String> carNames = cars.getCars().stream()
                .map(Car::getName)
                .toList();

        assertThat(answer).isEqualTo(carNames);
    }

    @DisplayName("[예외] 자동차 이름 개수 예외 테스트")
    @Test
    void validateCountOfNameTest() {
        List<String> nameList = new ArrayList<>() {
            {
                add("pobi");
            }
        };

        assertThatThrownBy(() -> NameValidator.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 두 개 이상의 이름을 입력해 주세요.");
    }

    @DisplayName("[예외] 자동차 이름 글자수 예외 테스트")
    @Test
    void validateLengthTest() {
        List<String> nameList = new ArrayList<>() {
            {
                add("pobiii");
                add("woni");
                add("jun");
            }
        };

        assertThatThrownBy(() -> NameValidator.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 1자 이상, 5자 이하의 이름을 입력해 주세요.");
    }

    @DisplayName(("[예외] 허용되지 않는 문자 포함 예외 테스트"))
    @Test
    void validateContainTest() {
        List<String> nameList = new ArrayList<>() {
            {
                add("po bi");
                add("woni");
                add("jun");
            }
        };

        assertThatThrownBy(() -> NameValidator.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 포함될 수 없는 문자가 포함되어 있습니다.");
    }

    @DisplayName("[예외] 중복된 이름 예외 테스트")
    @Test
    void validateNameDupTest() {
        List<String> nameList = new ArrayList<>() {
            {
                add("pobi");
                add("pobi");
                add("woni");
                add("jun");
            }
        };

        assertThatThrownBy(() -> NameValidator.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }
}
