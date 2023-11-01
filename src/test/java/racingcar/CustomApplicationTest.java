package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.ConsoleInput;

public class CustomApplicationTest {

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 이름이_6자_이상일_경우_오류() {
        assertThatThrownBy(() -> {
            Car car = Car.nameOf("이름이6글자");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름을_입력하지_않았을_경우_오류() {
        assertThatThrownBy(() -> {
            Car car = Car.nameOf("");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_중복될_경우_오류() {
        assertThatThrownBy(() -> {
            systemIn("pobi,pobi,hello");
            ConsoleInput.carNamesInput();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_포함_문자열_입력_시_공백제거() {
        systemIn("pobi     ,pedro  ,hello");
        List<Car> carList = ConsoleInput.carNamesInput();
        List<String> carNameList = carList.stream()
                .map(car -> car.getName())
                .toList();
        assertThat(carNameList).containsExactly("pobi", "pedro", "hello");
    }

    @Test
    void 구분자만_명확하면_한글_기호_상관없이_입력가능() {
        systemIn("한글1호,한글2호!,thisi");
        List<Car> carList = ConsoleInput.carNamesInput();
        List<String> carNameList = carList.stream()
                .map(car -> car.getName())
                .toList();
        assertThat(carNameList).containsExactly("한글1호", "한글2호!", "thisi");
    }


}
