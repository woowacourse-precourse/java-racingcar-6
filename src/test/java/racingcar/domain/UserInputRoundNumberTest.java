package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class UserInputRoundNumberTest {
    private UserInputRoundNumber userInputRoundNumber;

    @BeforeEach
    void setUp(){
        userInputRoundNumber = new UserInputRoundNumber();
    }
    @Test
    void 사용자_입력_라운드_문자열_숫자로_바꾸기(){
        String userInput = "4";
        int answer = userInputRoundNumber.stringToInt(userInput);
        assertThat(answer).isEqualTo(4);
    }

}