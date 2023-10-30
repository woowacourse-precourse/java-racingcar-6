package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.UserInputException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserInputCarNameTest {
    private UserInputException userInputException;
    private UserInputCarName userInputCarName;
    @BeforeEach
    void setUp(){
        userInputException = new UserInputException();
    }
    @Test
    void 리스트_잘_나오는지_확인(){
        String input = "pobi,woni,jun";
        List<String> answer = Arrays.asList(input.split(","));
        UserInputCarName userInputCarName = new UserInputCarName();
        List<String> result = userInputCarName.createCarName(input);
        assertThat(result).isEqualTo(answer);

    }
}