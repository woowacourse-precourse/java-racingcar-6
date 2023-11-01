package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarListFactoryTest {
    @Test
    @DisplayName("자동차 이름은 쉼표로 구분한다.")
    void 자동차_이름을_쉼표로_구분하여_이름_배열을_만듦() {
        final CarList expected = new CarList(
                List.of(
                        new Car("pobi"),
                        new Car("woni"),
                        new Car("jun")
                )
        );
        final CarList actual = CarListFactory.create("pobi,woni,jun");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("각 자동차 이름의 좌우 공백을 제거한다.")
    void getCarNameListFromCarNames_메서드에서_trim_메소드로_좌우_공백을_제거() {
        final List<String> expected = List.of("pobi", "woni", "jun");

        final String actualInput = " pobi,woni, jun ";
        final List<String> actual = CarListFactory.getCarNameListFromCarNames(actualInput);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getCarNameListFromCarNames_메서드에서_받은_리스트는_수정이_불가능() {
        final List<String> carNameList = CarListFactory.getCarNameListFromCarNames("pobi,woni,jun");
        assertThatThrownBy(() -> carNameList.set(0, "daram"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 자동차_이름_목록으로_자동차_객체_목록_생성() {
        final List<Car> expected = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        final List<String> carNameList = List.of("pobi", "woni", "jun");
        final List<Car> actual = CarListFactory.getCarList(carNameList);

        assertThat(actual).isEqualTo(expected);
    }
}
