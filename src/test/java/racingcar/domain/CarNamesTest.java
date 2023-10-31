package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {

    @Test
    void 생성자로_CarNames_객체를_생성하면_중복되지_않은_CarName_리스트를_반환() {
        //given
        List<String> carNameList = List.of("pobi", "woni", "jun");

        //when
        CarNames carNames = new CarNames(carNameList);

        //then
        List<CarName> result = carNames.getCarNames();
        assertThat(result.size()).isEqualTo(3);

        assertThat(result.get(0).getName()).isEqualTo("pobi");
        assertThat(result.get(1).getName()).isEqualTo("woni");
        assertThat(result.get(2).getName()).isEqualTo("jun");

    }
    @Test
    void 생성자로_CarNames_객체를_생성하면_중복된_CarName_리스트는_예외를_발생() {
        //given
        List<String> carNameListWithDuplicates = List.of("pobi", "woni", "pobi");

        //when & then
        assertThatThrownBy(() -> new CarNames(carNameListWithDuplicates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 있습니다.");
    }
}