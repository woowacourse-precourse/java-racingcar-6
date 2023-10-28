package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarCreatorTest {

    private static CarCreator carCreator;

    @BeforeAll
    public static void setup() {
        carCreator = new CarCreator();
    }

    @ParameterizedTest
    @DisplayName("문자열을 , 기준으로 자릅니다")
    @MethodSource("playerInputAndExpectedListProvider")
    public void 문자열_쉼표_기준_자르기(String playerInput, List<String> expectedList) {
        //when
        List<String> actualList = carCreator.splitPlayerInput(playerInput);

        //then
        assertThat(actualList).isEqualTo(expectedList);
    }

    static Stream<Arguments> playerInputAndExpectedListProvider() {
        return Stream.of(
                Arguments.arguments("", List.of("")),
                Arguments.arguments("pobbi", List.of("pobbi")),
                Arguments.arguments("pobbi,wonni,jun", List.of("pobbi", "wonni", "jun")),
                Arguments.arguments("pobbii,wonni,jun", List.of("pobbii", "wonni", "jun"))
        );
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력이 올바르지 않으면 오류 발생")
    @MethodSource("carNameListProvider")
    public void 자동차이름_입력_유효성_체크(List<String> carNameList) {
        //then
        assertThatThrownBy(() -> carCreator.validateCarName(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> carNameListProvider() {
        return Stream.of(
                Arguments.arguments(List.of("")),
                Arguments.arguments(List.of("pobbii", "wonni", "jun"))
        );
    }
}
