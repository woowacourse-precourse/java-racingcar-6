package racingcar.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputManagerTest {
    private UserInputManager userInputManager;
    private final InputStream originalSystemIn = System.in;

    int attempt;
    @BeforeEach
    void setUp() {
        userInputManager = new UserInputManager();
    }

    @AfterEach
    void restoreSystemInStream() {
        System.setIn(originalSystemIn);
        Console.close();    //Console 의 기존 생성 스캐너를 닫아 null 로 만들어야 이후 Scanner 생성가능
    }

    private InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void carName_5자를_초과할떄_Throw_IllegalArgumentException() {
        //given (주어진 값)
        String input = "pobiii";
        System.setIn(createUserInput(input));

        //then (기능 작동 후 검증)
        assertThatThrownBy(() -> userInputManager.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");  //오류 메세지를 가지고 있는지
    }

    @Test
    void parseCarNames_올바르게_작동하는가() {
        //given
        System.setIn(createUserInput("pobi,woni,jun"));
        List<String> carNames;

        //when (기능 작동)
        userInputManager.inputCarNames();
        carNames = userInputManager.getCarNames();

        //then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void carName_공백이_들어왔을때() {
        //given
        System.setIn(createUserInput("pobi,,jun"));
        List<String> carNames;

        //when (기능 작동)
        userInputManager.inputCarNames();
        carNames = userInputManager.getCarNames();

        //then
        assertThat(carNames).containsExactly("pobi", "jun");

    }

    @Test
    void carName_5글자를_입력받았을때() {   //경계값 검증
        //given
        System.setIn(createUserInput("pobii,wooni,jun"));
        List<String> carNames;

        //when (기능 작동)
        userInputManager.inputCarNames();
        carNames = userInputManager.getCarNames();

        //then
        assertThat(carNames).containsExactly("pobii", "wooni", "jun");

    }

    @Test
    void inputAttempts_올바른_입력받았을때() {
        //given
        System.setIn(createUserInput("5"));

        //when
        userInputManager.inputAttempts();

        //then
        assertThat(userInputManager.getAttempts()).isEqualTo(5);
    }

    @Test
    void inputAttempts_올바르지않은_입력받았을때_Throw_IllegalArgumentException() {
        System.setIn(createUserInput("pobi"));

        assertThatThrownBy(() -> userInputManager.inputAttempts())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 횟수는 숫자를 입력해야합니다");  //오류 메세지를 가지고 있는지
    }

}