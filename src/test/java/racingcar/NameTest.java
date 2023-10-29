package racingcar;

import domain.Car;
import domain.CarName;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("문자열을 구분하는 기능")
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

        List<String> nameList = InputView.inputCarNames();

        assertThat(answer).isEqualTo(nameList);
    }

    @DisplayName("자동차 저장 테스트")
    @Test
    void insertCarTest() {
        List<String> names = new ArrayList<>() {
            {
                add("pobi");
                add("woni");
                add("jun");
            }
        };
        Cars answer = new Cars() {
            {
                insertCar(new Car(new CarName("pobi")));
                insertCar(new Car(new CarName("woni")));
                insertCar(new Car(new CarName("jun")));
            }
        };

        Cars result = new Cars();
        names.forEach(name -> result.insertCar(new Car(new CarName(name))));

        List<String> answerCarNames = answer.getCars().stream()
                .map(Car::getName)
                .toList();
        List<String> resultCarNames = answer.getCars().stream()
                .map(Car::getName)
                .toList();
        assertThat(answerCarNames).isEqualTo(resultCarNames);
    }

    @DisplayName("[예외] 자동차 이름 글자수 예외 테스트")
    @Test
    void validateLengthTest() {
        System.setIn(new ByteArrayInputStream("pobiii,woni,jun".getBytes()));

        assertThatThrownBy(() -> InputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 1자 이상, 5자 이하의 이름을 입력해 주세요.");
    }

    @DisplayName(("[예외] 허용되지 않는 문자 포함 예외 테스트"))
    @Test
    void validateContainTest() {
        System.setIn(new ByteArrayInputStream("po bi,woni,jun".getBytes()));

        assertThatThrownBy(() -> InputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 포함될 수 없는 문자가 포함되어 있습니다.");
    }

    @DisplayName("[예외] 중복된 이름 예외 테스트")
    @Test
    void validateNameDupTest() {
        System.setIn(new ByteArrayInputStream("pobi,pobi,woni,jun".getBytes()));

        assertThatThrownBy(() -> InputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }
}
