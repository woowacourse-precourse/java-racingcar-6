package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import static racingcar.domain.Constants.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class UserInputTest {
    @DisplayName("자동차글자수5글자제한")
    @Test
    void 글자수5(){
        UserInput userInput = new UserInput();
        assertThrows(IllegalArgumentException.class, ()-> userInput.checkLength("데클런라이스"));
    }

    @DisplayName("빈칸입력시입력값출력")
    @Test
    void 빈글자입력(){
        UserInput userInput = new UserInput();
        assertThrows(IllegalArgumentException.class, ()->userInput.checkEmptyInput(""));

    }

    @DisplayName("앞 문자가 blank인지 확인하기")
    @Test
    void blankcheck(){
        UserInput userInput = new UserInput();
        assertThrows(IllegalArgumentException.class, ()->userInput.checkCarNameFrontBlank(" 사카"));
    }

    @DisplayName("중복 입력값 확인하기")
    @Test
    void checkDuplicate(){
        UserInput userInput = new UserInput();
        String input = "사카,라이스,사카";
        String[] carArr = input.split(CAR_NAME_SEPARATOR);
        HashSet<String> carSet = new HashSet<>();
        for (String carName : carArr){
            carSet.add(carName);
            assertThrows(IllegalArgumentException.class, ()->userInput.checkCarNameDuplicate(carName, carSet));
        }
    }

}