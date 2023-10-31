package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private static final String DUPLICATE_ERROR_MESSAGE = "이미 존재하는 자동차 이름입니다.";
    private Cars cars;
    private final Referee testReferee = () -> true;

    @BeforeEach
    void setInit() {
        cars = new Cars(new ArrayList<>());
    }

    @DisplayName("차 이름이 주어지면 자동차 리스트에 추가된다.")
    @Test
    void addTest() {
        // given
        String name = "pobi";

        // when
        cars.add(name);

        // then
        assertThat(cars.getWinnerNameList()).contains(name);
    }

    @DisplayName("차 이름이 중복되면 예외가 발생해야 한다.")
    @Test
    void validateDuplicateTest() {
        // given
        List<String> names = List.of("jason", "pobi", "jason");

        // when, then
        assertThatThrownBy(() -> names.forEach(cars::add))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_ERROR_MESSAGE);
    }

    @DisplayName("경기 결과를 문자열로 받아야 한다.")
    @Test
    void getStringOfRaceResultTest() {
        // given
        cars.add("pobi");
        cars.add("jason");

        // when
        cars.move(testReferee);
        cars.move(testReferee);
        String raceResult = cars.getStringOfRaceResult();

        // then
        String expected = """
                pobi : --
                jason : --
                """;
        assertThat(raceResult).contains(expected);
    }
}
