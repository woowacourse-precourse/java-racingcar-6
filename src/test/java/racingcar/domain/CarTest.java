package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;
import static racingcar.global.constants.NumberType.INITIAL_POSITION;
import static racingcar.global.constants.NumberType.MIN_FORWARD_THRESHOLD;
import static racingcar.global.constants.SymbolType.RESULT_TOKEN;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class CarTest {
    private static final String CORRECT_CAR_NAME = "poby";

    private static MockedStatic<Randoms> randoms;

    @BeforeAll
    public static void setUp() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void tearDown() {
        randoms.close();
    }

    @Test
    void 자동차_객체를_성공적으로_생성한다() {
        // when
        Car car = Car.of(CORRECT_CAR_NAME);

        // then
        assertThat(car.getName()).isEqualTo(CORRECT_CAR_NAME);
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION.getValue());
    }

    @Test
    void 무작위_숫자가_조건을_충족하여_자동차가_이동한다() {
        // given
        given(Randoms.pickNumberInRange(anyInt(), anyInt()))
                .willReturn(MIN_FORWARD_THRESHOLD.getValue() + 1);
        Car car = Car.of(CORRECT_CAR_NAME);

        // when
        car.tryMove();

        // then
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION.getValue() + 1);
    }

    @Test
    void 현재_위치가_입력된_위치와_동일하다() {
        // given
        Integer position = INITIAL_POSITION.getValue();

        // when
        Car car = Car.of(CORRECT_CAR_NAME);

        // then
        assertThat(car.isSamePosition(position)).isTrue();
    }

    @Test
    void 현재_위치가_입력된_위치와_다르다() {
        // given
        Integer position = INITIAL_POSITION.getValue() + 1;

        // when
        Car car = Car.of(CORRECT_CAR_NAME);

        // then
        assertThat(car.isSamePosition(position)).isFalse();
    }

    @Test
    void 무작위_숫자가_조건을_충족하지_않아_이동하지_않는다() {
        // given
        given(Randoms.pickNumberInRange(anyInt(), anyInt()))
                .willReturn(MIN_FORWARD_THRESHOLD.getValue() - 1);
        Car car = Car.of(CORRECT_CAR_NAME);

        // when
        car.tryMove();

        // then
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION.getValue());
    }

    @Test
    void 자동차_객체가_형식에_맞는_문자열을_반환한다() {
        // given
        Car car = Car.of(CORRECT_CAR_NAME);
        String expected = CORRECT_CAR_NAME + RESULT_TOKEN.getSymbol();

        // when
        String actual = car.toString();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
