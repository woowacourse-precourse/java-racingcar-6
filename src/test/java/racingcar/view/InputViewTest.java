package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest extends IOTest {


    @Test
    @DisplayName("이름 입력시 공백만 입력할 경우 예외 발생")
    void 예외_처리_테스트_1() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("ㅤ");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("이름 입력시 이름 한 개만 입력할 경우 예외 발생")
    void 예외_처리_테스트_2() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("pobi");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("이름 입력시 글자 이외의 값을 입력한 경우 예외 발생")
    void 예외_처리_테스트_3() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("pobi,4nam,hash");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("이름 입력시 입력 형식을 맞추지 못한 경우 예외 발생 - 공백이 포함된 경우")
    void 예외_처리_테스트_4() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("pobi, anam, hash");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("이름 입력시 입력 형식을 맞추지 못한 경우 예외 발생 - ',' 이외의 구분자가 사용된 경우")
    void 예외_처리_테스트_5() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("pobi/anam/hash");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("이름 입력시 여러 이름을 입력하면 리스트로 변환하는 기능 테스트")
    void inputNames() {
        // given
        InputView inputView = new InputView();
        List<String> expected = List.of("pobi", "yono", "haho", "nimo");

        // when
        systemIn("pobi,yono,haho,nimo");
        List<String> result = inputView.inputNames();

        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("게임 회수 입력시 공백을 입력한 경우 예외 발생")
    void 예외_처리_테스트_6() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("ㅤ");
                    inputView.inputCountOfGameRound();
                });
    }

    @Test
    @DisplayName("게임 회수 입력시 숫자가 아닌 값을 입력한 경우 예외 발생")
    void 예외_처리_테스트_7() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("&");
                    inputView.inputCountOfGameRound();
                });
    }

    @Test
    @DisplayName("게임 회수 입력시 1 보다 작은 수를 입력한 경우 예외 발생")
    void 예외_처리_테스트_8() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("0");
                    inputView.inputCountOfGameRound();
                });
    }


    @Test
    @DisplayName("게임 회수 입력시 게임 회수 입력 받는 기능 테스트")
    void inputCountOfGameRound() {
        // given
        InputView inputView = new InputView();
        systemIn("7");

        // when
        Integer result = inputView.inputCountOfGameRound();

        // then
        assertEquals(7, result);
    }
}