package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest extends InTest {


    @Test
    @DisplayName("공백만 입력할 경우 예외 발생")
    void 예외_처리_테스트_1() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("ㅤ");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("이름 한 개만 입력할 경우 예외 발생")
    void 예외_처리_테스트_2() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("pobi");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("글자 이외의 값을 입력한 경우 예외 발생")
    void 예외_처리_테스트_3() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("pobi,4nam,hash");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("입력 형식을 맞추지 못한 경우 예외 발생 - 공백이 포함된 경우")
    void 예외_처리_테스트_4() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("pobi, anam, hash");
                    inputView.inputNames();
                });
    }

    @Test
    @DisplayName("입력 형식을 맞추지 못한 경우 예외 발생 - ',' 이외의 구분자가 사용된 경우")
    void 예외_처리_테스트_5() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    systemIn("pobi/anam/hash");
                    inputView.inputNames();
                });
    }

//    @Test
//    void inputNames() {
//
//    }
//
//    @Test
//    void convertStrToList() {
//    }
//
//    @Test
//    void inputCountOfGameRound() {
//    }
//
//    @Test
//    void convertStrToInt() {
//    }

}