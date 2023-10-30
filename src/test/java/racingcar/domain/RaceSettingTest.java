package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceSettingTest {

    private RaceSetting raceSetting;

    @BeforeEach
    void setUp() {
        raceSetting = new RaceSetting();
    }

    @Test
    void splitCars_메서드로_주어진_값을_구분() {
        String cars = "pobi,woni,jun";
        String[] result = raceSetting.splitCars(cars);

        assertThat(result).contains("jun", "pobi");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void splitCars_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "pobi";
        String[] result = raceSetting.splitCars(input);

        assertThat(result).contains("pobi");
    }

    @Test
    void carValidCheck_메서드_사용_시_이름의_길이가_5이상인_참가자가_있을_때_예외_발생() {
        String[] carList = {"pobi", "myCarIsBest", "woni"};
        assertThatThrownBy(() -> raceSetting.carValidCheck(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값이 입력되었습니다.");
    }

}