package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private static final String LENGTH_ERROR = "이름은 5자 이하만 가능합니다.";
    private static final String IS_NOT_NUMBER = "숫자를 입력해 주세요.";
    private static final String IS_NOT_NATURAL_NUMBER = "전진횟수는 자연수여야 합니다.";
    private static final String IS_SPACE = "공백 혹은 빈 문자열은 등록할 수 없습니다.";

    private InputView inputView;

    @BeforeEach
    void readyTest() {
        inputView = new InputView();
    }

    @DisplayName("[성공] 자연수가 입력되었는지 확인하는 테스트")
    @Test
    public void 자연수가_입력되었는지_확인하는_테스트_성공() throws Exception {
        // given
        InputStream inputNumber = setReadLine("1");
        System.setIn(inputNumber);

        //when
        //then
        inputView.inputTimes();
    }
    @DisplayName("[실패] 자연수가 입력되었는지 확인하는 테스트(0입력)")
    @Test
    public void 자연수가_입력되었는지_확인하는_테스트_실패() throws Exception {
        // given
        InputStream inputNumber = setReadLine("0");
        System.setIn(inputNumber);

        //when
        //then
        assertThatThrownBy(() -> inputView.inputTimes()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_NOT_NATURAL_NUMBER);
    }
    @DisplayName("[실패] 자연수가 입력되었는지 확인하는 테스트(문자입력)")
    @Test
    public void 자연수가_입력되었는지_확인하는_테스트_실패_문자_입력() throws Exception {
        // given
        InputStream inputNumber = setReadLine("a");
        System.setIn(inputNumber);

        //when
        //then
        assertThatThrownBy(() -> inputView.inputTimes()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_NOT_NUMBER);
    }

    @DisplayName("[성공] 이름을 맞게 입력하는 경우")
    @Test
    public void 이름을_맞게_입력하는_경우() throws Exception {
        // given
        String names = "pobi,woni,jun";
        InputStream inputStream = setReadLine(names);
        System.setIn(inputStream);

        // when
        // then
        inputView.inputPlayers();
    }
    @DisplayName("[실패] 이름의 길이가 5가 넘는 경우")
    @Test
    public void 이름_길이가_5보다_넘는_경우() throws Exception {
        // given
        String names = "pobi,woni,junaaa";
        InputStream inputStream = setReadLine(names);
        System.setIn(inputStream);

        // when
        // then
        assertThatThrownBy(() -> inputView.inputPlayers()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LENGTH_ERROR);
    }

    @DisplayName("[성공] 이름 양쪽에 공백이 있는 경우 제거해서 리턴")
    @Test
    public void 이름_양쪽에_공백이_있는_경우_제거해서_리턴() throws Exception {
        // given
        String names = "  pobi  ,  woni      ,       jun";
        InputStream inputStream = setReadLine(names);
        System.setIn(inputStream);

        // when
        String[] strings = inputView.inputPlayers();

        // then
        assertThat(strings).containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("[실패] 이름이 공백으로만 이루어진 경우")
    @Test
    public void 이름이_공백으로만_이루어진_경우() throws Exception {
        // given
        String names = "         ";
        InputStream inputStream = setReadLine(names);
        System.setIn(inputStream);

        // when
        // then
        assertThatThrownBy(() -> inputView.inputPlayers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_SPACE);
    }

    @AfterEach
    public void ConsoleClose() {
        Console.close();
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}