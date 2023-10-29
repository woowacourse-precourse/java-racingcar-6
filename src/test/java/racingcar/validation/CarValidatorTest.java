package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarValidatorTest {

    @DisplayName("리스트에 담긴 자동차 이름 중 중복값이 있으면 예외 발생")
    @Test
    void duplicatedCarNameInNameListThrowException() {
        List<String> nameList = new ArrayList<>();
        nameList.add("pobi");
        nameList.add("pobi");
        nameList.add("woni");

        assertThatThrownBy(
                () -> CarValidator.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.DUPLICATED_CAR_NAME_ERROR);
    }

    @DisplayName("리스트에 담긴 자동차 이름 중 중복값이 없으면 검증 성공")
    @Test
    void notDuplicatedCarNameInNameListThrowException() {
        List<String> nameList = new ArrayList<>();
        nameList.add("pobi");
        nameList.add("pobi");
        nameList.add("woni");

        assertThatThrownBy(
                () -> CarValidator.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.DUPLICATED_CAR_NAME_ERROR);
    }

    @DisplayName("리스트에 담긴 자동차 이름 중 문자열의 길이가 5 초과면 예외 발생")
    @Test
    void lengthOverFiveThrowException() {
        List<String> nameList = new ArrayList<>();
        nameList.add("pobiii");
        nameList.add("pobi");
        nameList.add("woni");

        assertThatThrownBy(
                () -> CarValidator.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.LENGTH_MAX_FIVE_ERROR);
    }

    @DisplayName("리스트에 담긴 자동차 이름 중 문자열의 길이가 1 미만이면 예외 발생")
    @Test
    void lengthUnderOneThrowException() {
        List<String> nameList = new ArrayList<>();
        nameList.add("");
        nameList.add("pobi");
        nameList.add("woni");

        assertThatThrownBy(
                () -> CarValidator.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.LENGTH_MIN_ONE_ERROR);
    }

    @DisplayName("리스트에 담긴 자동차 이름 중 숫자/한글/영어 외의 문자면 예외 발생.")
    @Test
    void inputEmptyStringThrowException() {
        List<String> nameList = new ArrayList<>();
        nameList.add("pobi#");
        nameList.add("123한글");
        nameList.add("woni");

        assertThatThrownBy(
                () -> CarValidator.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.ONLY_HAS_CHARACTER_OR_NUMBER_ERROR);
    }


}