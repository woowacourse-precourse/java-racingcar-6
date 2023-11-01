package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.utils.StringParser;
import racingcar.utils.Validator;

public class InputCarTest {

    Validator validator;

    @BeforeEach
    void init() {
        validator = new Validator();
    }

    @ParameterizedTest
    @DisplayName("입력되는 자동차가 두 대 이하, 다섯 대 이상이면 예외 발생")
    @MethodSource("자동차_입력범위_초과시_예외_발생_소스")
    void 자동차_입력범위_초과시_예외_발생(List<String> cars) {
        assertThatThrownBy(() -> validator.validateInputCar(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> 자동차_입력범위_초과시_예외_발생_소스() {
        return Stream.of(
                List.of("a"),
                List.of("a", "b", "c", "d", "e", "f")
        );
    }

    @Test
    @DisplayName("여러 대의 자동차가 입력되는 경우, 쉼표를 기준으로 나눌 수 있는가")
    void 여러_대로_구분할수_있는가() {
        String cars = "pobi,harry,mark";

        assertThat(StringParser.splitStringWithComma(cars)).contains("pobi", "harry", "mark");
    }

    @ParameterizedTest
    @DisplayName("자동차의 이름이 1자 이상 5자 이하가 아니면 예외 발생")
    @MethodSource("자동차_이름_길이_범위외일시_예외_발생_소스")
    void 자동차_이름_길이_범위외일시_예외_발생(List<String> cars) {
        assertThatThrownBy(() -> validator.validateInputCar(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> 자동차_이름_길이_범위외일시_예외_발생_소스() {
        return Stream.of(
                List.of("pobipobi"),
                List.of("pobi", "")
        );
    }

    @Test
    @DisplayName("자동차의 이름이 영문자가 아니면 예외 발생")
    void 영문자로만_이루어져_있는가() {
        List<String> cars = List.of("po123", "harry", "포비");

        assertThatThrownBy(() -> validator.validateInputCar(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 중복일 경우 예외 발생")
    void 자동차가_중복인가() {
        List<String> cars = List.of("pobi", "pobi");

        assertThatThrownBy(() -> validator.validateInputCar(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
