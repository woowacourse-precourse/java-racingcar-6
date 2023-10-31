package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InputException;

import java.util.List;

public class InputUtilTest {
    private InputUtil inputUtil = new InputUtil();
    @Test
    @DisplayName("자동차 이름 입력하기")
    public void 자동차_이름_입력하기() throws Exception {
        // given
        String names = "poni,hi,hello";

        // when
        List<String> strings = inputUtil.splitString(names);

        // then
        Assertions.assertThat(strings.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 입력 시 공백문자를 포함한 경우")
    public void 자동차_입력_시_공백문자_예외() throws Exception {
        // given
        String names = "poni, hi, hello";

        // when
        List<String> nameList = inputUtil.splitString(names);
        // then
        Assertions.assertThatThrownBy(() -> nameList.forEach(inputUtil::validateCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 제외하고 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 입력 시 1자이하 또는 5자이상 포함한 경우")
    public void 자동차_이름_문자갯수_확인() throws Exception {
        // given
        String name1 = "racingcar";
        String name2 = "";

        // when

        // then
        Assertions.assertThatThrownBy(() -> inputUtil.validateCarName(name1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1-5자까지 입력 가능합니다.");
        Assertions.assertThatThrownBy(() -> inputUtil.validateCarName(name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1-5자까지 입력 가능합니다.");
    }
    
    @Test
    @DisplayName("자동차 입력 시 문자열(영문자) 이외의 값을 넣은 경우")
    public void 자동차_이름_문자열_타입확인() throws Exception {
        // given
        String name1 = "자동차";
        String name2 = "!car";
        String name3 = "car12";

        
        // when
        
        
        // then
        Assertions.assertThatThrownBy(() -> inputUtil.validateCarName(name1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자(영문자)만 입력해주세요.");

        Assertions.assertThatThrownBy(() -> inputUtil.validateCarName(name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자(영문자)만 입력해주세요.");

        Assertions.assertThatThrownBy(() -> inputUtil.validateCarName(name3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자(영문자)만 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 입력 시 중복된 이름을 입력한 경우")
    public void 중복된_이름_입력시_예외_테스트() throws Exception {
        // given
        String names = "poni,poni,hello";

        // when
        List<String> nameList = inputUtil.splitString(names);

        // then
        Assertions.assertThatThrownBy(() -> InputException.checkDuplicationName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 있습니다.");

    }

    @Test
    @DisplayName("자동차 입력 시, 마지막 문자를 ,로 입력한 경우")
    public void 입력시_마지막_문자열_확인_테스트() throws Exception {
        // given
        String names = "poni,poni,hello,";

        // when

        // then
        Assertions.assertThatThrownBy(() -> InputException.checkContainComma(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력방식입니다.");

    }

    @Test
    @DisplayName("자동차 입력 시, 2대 이하로 입력한 경우")
    public void 자동차_갯수_입력_테스트() throws Exception {
        // given
        String names = "poni";

        // when
        List<String> nameList = inputUtil.splitString(names);

        // then
        Assertions.assertThatThrownBy(() -> InputException.checkCarCount(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차를 2대 이상 입력해주세요.");
    }

    @Test
    @DisplayName("횟수 입력 시, 1이하의 수를 입력한 경우")
    public void 횟수_입력_1이하_확인() throws Exception {
        // given
        String input = "0";

        // when
        int number = inputUtil.stringToInt(input);

        // then
        Assertions.assertThatThrownBy(() -> InputException.checkNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자를 입력하세요.");

    }

    @Test
    @DisplayName("횟수 입력 시, 숫자 이외의 값을 입력한 경우")
    public void 횟수_입력_문자열_입력확인() throws Exception {
        // given
        String number = "rk12";

        // when

        // then
        Assertions.assertThatThrownBy(() -> inputUtil.stringToInt(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");

    }
}
