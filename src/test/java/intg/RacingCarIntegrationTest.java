package intg;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;

public class RacingCarIntegrationTest {


    @AfterEach
    void finished() {
        Console.close();
    }

    @Test
    void 게임_성공_케이스(){
        //given
        System.setIn(createUserInput("car1,car2,car3\n5\n"));

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        new GameController();

        // 다시 설정 복원
        System.setOut(originalOut);
        String capturedOutput = baos.toString().trim();

        //then
        assertThat(capturedOutput).contains("최종 우승자 : ");
    }

    @Test
    void 게임_빈값_인풋_실패_케이스(){
        //given
        System.setIn(createUserInput(""));

        //then
        assertThatThrownBy(GameController::new)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 값은 입력이 불가능합니다.");
    }

    @Test
    void 게임_차이름_길이_초과_인풋_실패_케이스(){
        //given
        System.setIn(createUserInput("car12345,car2,car3\n5\n"));

        //then
        assertThatThrownBy(GameController::new)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름은 5자 이하만 가능합니다.");
    }
    @Test
    void 게임_횟수_빈칸_인풋_실패_케이스(){
        //given
        System.setIn(createUserInput("car1,car2,car3\n"));

        //then
        assertThatThrownBy(GameController::new)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 값은 입력이 불가능합니다.");
    }

    @Test
    void 게임_횟수_문자_입력_인풋_실패_케이스(){
        //given
        System.setIn(createUserInput("car1,car2,car3\n1a\n"));

        //then
        assertThatThrownBy(GameController::new)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 하나의 숫자만 입력해주세요.");
    }

    @Test
    void 게임_횟수_띄어쓰기_숫자_입력_인풋_실패_케이스(){
        //given
        System.setIn(createUserInput("car1,car2,car3\n1 2\n"));

        //then
        assertThatThrownBy(GameController::new)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 하나의 숫자만 입력해주세요.");
    }



    private InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
