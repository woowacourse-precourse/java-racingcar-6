package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Trial;
import racingcar.utils.Validation;

public class MyTest {
    @Test
    void splitNames() {
        // 이름은 쉼표(,)를 기준으로 나눈다.
        String input = "abc,cde,qwe";
        String[] result = Cars.splitBy(input, ",");
        assertThat(Arrays.toString(result)).isEqualTo("[abc, cde, qwe]");
    }

    @Test
    void isValidName1() {
        // 이름은 1~5글자이며 특수문자를 제외한 숫자 영어의 조합이 가능하다.
        String name1 = "a333b";
        Validation.validateName(name1);
    }

    @Test
    void isValidName2() {
        // 이름에 특수문자가 있다면 IllegalArgumentException 을 발생시킨다.
        String name2 = "a@ ()";
        assertThatThrownBy(() -> Validation.validateName(name2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidName3() {
        // 이름은 1~5글자이며 그렇지 않으면 IllegalArgumentException 을 발생시킨다.
        String name3 = "abcdef";
        assertThatThrownBy(() -> Validation.validateName(name3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void distinctNames() {
        // 이름이 중복되면 안된다.
        String input = "abc,abc,edf";
        String[] splitInput = Cars.splitBy(input, ",");
        assertThatThrownBy(() -> Validation.isDistinctNames(splitInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carStatusIsCorrect() {
        // Car class 를 출력하면 이름과 전진상태를 확인할 수 있다.
        // 아래 테스트는 전진 2번했을때 예상과 실제값을 비교했다.
        String input = "abc";
        Car car = new Car(input);
        car.moveForward();
        car.moveForward();
        String result = car.toString();
        assertThat(result).isEqualTo("abc : --");
    }

    @Test
    void isValidTrial1() {
        // 시행 횟수 입력값의 길이는 1이상이어야 한다.
        String input = "";
        assertThatThrownBy(() -> new Trial(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidTrial2() {
        // 시행 횟수 입력값에는 숫자 이외 문자가 포함되면 안된다.
        String input = " 3";
        assertThatThrownBy(() -> new Trial(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
