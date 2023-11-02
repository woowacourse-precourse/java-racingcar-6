package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ApplicationTestFromHereokay {

    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");
    }

    @Test
    void 모든_차량이_동일한_이동_횟수를_가질_때() {
        car1.setMoveCount(3);
        car2.setMoveCount(3);
        car3.setMoveCount(3);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        int maxMoveCount = Application.findMaxMoveCount(cars);

        assertThat(maxMoveCount).isEqualTo(3);
    }

    @Test
    void 한_차량이_다른_차량들보다_더_많은_이동_횟수를_가질_때() {
        car1.setMoveCount(2);
        car2.setMoveCount(5);
        car3.setMoveCount(3);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        int maxMoveCount = Application.findMaxMoveCount(cars);

        assertThat(maxMoveCount).isEqualTo(5);
    }

    @Test
    void 입력_리스트가_비어_있을_때() {
        List<Car> cars = Collections.emptyList();
        int maxMoveCount = Application.findMaxMoveCount(cars);

        assertThat(maxMoveCount).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void 공백만_포함된_이름은_예외가_발생해야한다() {
        String nameWithSpaces = " ";
        assertThatThrownBy(() -> Application.validateName(nameWithSpaces))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 이름이 포함되어 있습니다. 이름을 다시 입력하세요.");
    }

    @Test
    void 길이가_5자_이상인_이름은_예외가_발생해야한다() {
        String longName = "abcdef";
        assertThatThrownBy(() -> Application.validateName(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 이름이 포함되어 있습니다. 이름을 다시 입력하세요.");
    }

    @Test
    void 이름_내부에_공백이_포함되면_예외가_발생해야한다() {
        String nameWithInternalSpace = "ab c";
        assertThatThrownBy(() -> Application.validateName(nameWithInternalSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 이름이 포함되어 있습니다. 이름을 다시 입력하세요.");
    }

    @Test
    void 유효한_이름은_예외가_발생하지_않아야한다() {
        String validName = "abc";
        // 아무런 예외도 발생하지 않아야 하므로 특별한 assert가 필요하지 않습니다.
        Application.validateName(validName);
    }
}