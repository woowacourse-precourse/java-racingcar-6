package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        this.inputView = InputView.getInstance();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("차 이름 사용자로부터 가져오는 테스트")
    void 차_이름_받아오기() throws Exception {
        //given
        System.setIn(readUserInput("car1,car2"));
        //when
        //then
        assertThat(inputView.readCarNames()).isEqualTo("car1,car2");
    }
    
    @Test
    @DisplayName("이동 횟수 가져오는 테스트")
    void 이동횟수_받아오기() throws Exception {
        //given
        System.setIn(readUserInput("5"));
        //when
        //then
        assertThat(inputView.readTryNum()).isEqualTo(5);
    }

    public InputStream readUserInput(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
}