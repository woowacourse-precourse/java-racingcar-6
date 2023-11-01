package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;
import static racingcar.global.constants.NumberType.MIN_FORWARD_THRESHOLD;
import static racingcar.global.exception.ErrorMessage.DUPLICATE_NAME;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_LIST_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class CarsTest {
    private static final String CORRECT_USER_INPUT = "pobi,woni";

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
    void 일급컬렉션을_성공적으로_생성한다() {
        // when
        Cars cars = Cars.of(CORRECT_USER_INPUT);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    void 형식에_맞는_문자열을_생성한다() {
        // given
        Cars cars = Cars.of(CORRECT_USER_INPUT);
        String expected = "pobi : \nwoni : \n";

        // when
        String actual = cars.toString();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 모든_자동차들을_전진한다() {
        // given
        given(Randoms.pickNumberInRange(anyInt(), anyInt()))
                .willReturn(MIN_FORWARD_THRESHOLD.getValue() + 1);
        Cars cars = Cars.of(CORRECT_USER_INPUT);
        String expected = "pobi : -\nwoni : -\n";

        // when
        cars.tryMoveCars();

        // then
        assertThat(cars.toString()).isEqualTo(expected);
    }

    @Test
    void 가장_많이_이동한_자동차_객체를_찾는다() {
        // given
        Cars cars = Cars.of(CORRECT_USER_INPUT);

        // when
        List<Car> maxPositionCars = cars.findMaxPositionCars();

        // then
        assertThat(maxPositionCars).hasSize(2);
        assertThat(maxPositionCars.get(0).getName()).isEqualTo("pobi");
        assertThat(maxPositionCars.get(1).getName()).isEqualTo("woni");
    }

    @Test
    void 하나의_자동차만_입력하여_예외를_반환한다() {
        // given
        String userInput = "pobi";

        // when & then
        try {
            Cars.of(userInput);
        } catch (IllegalArgumentException e) {
            assertThat(INVALID_NAME_LIST_SIZE.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars.of(userInput);
        });
    }

    @Test
    void 중복된_자동차_이름을_입력하여_예외를_반환한다() {
        // given
        String userInput = "poby,poby";

        // when & then
        try {
            Cars.of(userInput);
        } catch (IllegalArgumentException e) {
            assertThat(DUPLICATE_NAME.getMessage()).isEqualTo(e.getMessage());
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars.of(userInput);
        });
    }
}
