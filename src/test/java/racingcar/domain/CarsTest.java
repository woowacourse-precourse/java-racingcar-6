package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차의 이름은 반드시 존재해야 한다.")
    @Test
    void createCars_exception_hasBlankName() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.from(List.of(" ", "", "  ")))
                .withMessageContaining("자동차의 이름은 반드시 존재해야 합니다.");
    }

    @DisplayName("자동차의 이름은 중복될 수 없다.")
    @Test
    void createCars_exception_hasDuplicatesName() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.from(List.of("aaa", "aaa", "bbb")))
                .withMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("자동차는 2대 이상 등록해야 합니다.")
    @Test
    void createCars_exception_notEnoughCars() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.from(List.of("aaa")))
                .withMessageContaining("자동차는 2대 이상 등록해야 합니다");
    }

    @DisplayName("등록한 자동차는 변경할 수 없다.")
    @Test
    void tryChangingCar_exception() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("aaa");
        carNames.add("bbb");

        // when
        Cars cars = Cars.from(carNames);
        List<Car> carObjects = cars.cars();

        // then
        assertThatThrownBy(() -> carObjects.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("자동차는 MOVABLE_OFFSET 이상의 값이 입력되면 전진할 수 있다.")
    @Test
    void moveAllForward() {
        // given
        List<String> carNames = List.of("aaa", "bbb");
        Cars cars = Cars.from(carNames);
        Supplier<Integer> moveNumberSupplier = ForwardCondition.MOVABLE_OFFSET::getValue;

        // when
        cars.moveAllForward(moveNumberSupplier);
        boolean moveResult = cars.cars()
                .stream()
                .map(Car::getPosition)
                .allMatch(position -> position == 1);

        // then
        assertThat(moveResult).isTrue();
    }

    @DisplayName("전진 횟수가 가장 큰 자동차가 여러대라면 모두 우승자다")
    @Test
    void findAllWinnerNames() {
        // given
        Cars cars = Cars.from(List.of("aaa", "bbb"));
        Supplier<Integer> moveNumberSupplier = ForwardCondition.MOVABLE_OFFSET::getValue;

        // when
        cars.moveAllForward(moveNumberSupplier);
        List<String> winnerNames = cars.findAllWinnerNames();

        // then
        assertThat(winnerNames).containsExactly("aaa", "bbb");
    }

}