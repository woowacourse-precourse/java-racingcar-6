package racingcar.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class CarNameInputValidatorTest extends NsTest {
    private static final String ASK_MORE_THAN_TWO = "2개 이상의 차 이름을 입력하세요";
    private static final String ASK_NO_VOID_NAME = "빈 칸은 입력할 수 없습니다. 쉼표 앞뒤에 이름을 반드시 적어주세요";
    private static final String ASK_NO_DUPLICATION = "중복된 이름을 입력 불가합니다";
    private static final String ASK_VALID_NAME_LENGTH = "차 이름은 5자 이하로 입력해주세요";
    private static final String ASK_ONLY_CHARACTER_INPUT = "쉼표로 구분된 차 이름은 문자(알파벳, 한극)로만 입력 가능합니다";
    private static final String ASK_ONE_SPACE_BETWEEN_CHAR = "문자와 문자 사이이 공백은 한 칸까지만 가능합니다";
    private static final String ASK_NO_SPACE_IN_START_OR_END_POSITION = "이름의 앞 뒤에 공백 없이 쉼표(,)로 구분해서 입력해주세요";

    CarNameInputValidator validator = new CarNameInputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi", ","})
    @DisplayName("이름 1개 이하 입력 예외 처리 테스트")
    void 이름이_1개_이하_예외_처리(String userInput) {

        List<String> carNameInputList = Arrays.asList(userInput.split(","));
        assertThatThrownBy(
                () -> {
                    validator.areNamesMoreThanTwo(carNameInputList);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_MORE_THAN_TWO);
    }

    public static Stream<String> voidNameProvider() {
        return Stream.of(", , ,", ", ,");
    }

    @ParameterizedTest
    @MethodSource("voidNameProvider")
    void 빈_이름_예외_처리(String userInput) {
        List<String> carNameInputList = Arrays.asList(userInput.split(","));
        assertThatThrownBy(
                () -> {
                    validator.isVoidNameIncluded(carNameInputList);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_VOID_NAME);
    }

    @Test
    @DisplayName("6자 이상의 이름 예외 처리 테스트")
    void 이름이_6자_이상_예외_처리() {

        List<String> carNameInputList = Arrays.asList("pobiisGreat", "woni");
        assertThatThrownBy(
                () -> {
                    validator.isNameLengthBelowFive(carNameInputList);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_VALID_NAME_LENGTH);
    }

    public static Stream<String> nonCharNameProvider() {
        return Stream.of("wo\ni,pobi", "pobi1,pobi2", "pobi*,woni");
    }

    @ParameterizedTest
    @MethodSource("nonCharNameProvider")
    @DisplayName("이름에 특수문자, 이스케이프 코드, 숫자 포함 예외 처리 테스트")
    void 문자_외_입력_예외_처리(String userInput) {
        List<String> carNameInputList = Arrays.asList(userInput.split(","));
        assertThatThrownBy(
                () -> {
                    validator.isNameOnlyWithChar(carNameInputList);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_ONLY_CHARACTER_INPUT);
    }


    @Test
    @DisplayName("이름 중간에 공백이 2자 이상 있을 경우 예외 처리 테스트")
    void 이름_중간에_두_자_이상_공백_테스트() {
        List<String> inputs = Arrays.asList("pobi  park", "woni");
        assertThatThrownBy(
                () -> {
                    validator.isNameWithConSequenceSpaces(inputs);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_ONE_SPACE_BETWEEN_CHAR);

    }

    public static Stream<String> nameWithStartBackSpaceProvider() {
        return Stream.of(" pobi,woni", "pobi ,woni", "pobi, woni", "pobi,woni ", "pobi , woni");
    }

    @ParameterizedTest
    @MethodSource("nameWithStartBackSpaceProvider")
    @DisplayName("이름의 시작 혹은 끝에 공백이 있는 경우 테스트")
    void 이름_시작_혹은_끝에_공백_예외_처리(String userInput) {
        List<String> inputs = Arrays.asList(userInput.split(","));
        assertThatThrownBy(
                () -> {
                    validator.isNameStartOrEndWithSpace(inputs);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_SPACE_IN_START_OR_END_POSITION);

    }


    @Test
    @DisplayName("이름 중복 예외 처리 테스트")
    void 이름에_대한_중복_예외_처리() {
        List<String> carNameInputList = Arrays.asList("pobi", "pobi");

        assertThatThrownBy(
                () -> {
                    validator.isNameNotDuplicated(carNameInputList);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NO_DUPLICATION);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}