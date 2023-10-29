package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    @Test
    void 글자수5(){
        UserInput userInput = new UserInput();
        assertThrows(IllegalArgumentException.class, ()-> userInput.checkLength("데클런라이스"));
    }




}