package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

public class ValidatorTest {
    private Validator validator;
    @BeforeEach
    void setUp(){
        validator = new Validator();
    }
    @Test
    void 정해진_형식대로_입력하면_에러없이_동작한다(){
        String correctInput = "poby,crong,ahrin";
        Assertions.assertDoesNotThrow(()->validator.validateUserInputIsCorrectFormat(correctInput));
    }
    @Test
    void 형식이_맞지_않으면_에러가_발생한다(){
        String wrongInput = "ppobby<crongwinter>.hani";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->
                        validator.validateUserInputIsCorrectFormat(wrongInput));
        Assertions.assertEquals("입력된 값이 형식에 맞지 않습니다!",exception.getMessage());
    }
    @Test
    void 이름의_길이가_일정길이를_초과하면_에러가_발생한다(){
        String wrongInput = "ppobbby,ccrrong,youngsu";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->
                        validator.validateUserInputIsCorrectFormat(wrongInput));
        Assertions.assertEquals("이름이 너무 깁니다!",exception.getMessage());
    }
    @Test
    void 중복된_이름이_있으면_에러가_발생한다(){
        String wrongInput = "pobby,crong,pobbi,pobby";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->
                        validator.validateUserInputIsCorrectFormat(wrongInput));
        Assertions.assertEquals("중복된 이름이 있습니다!",exception.getMessage());
    }
    @Test
    void 양의_정수를_입력하면_에러없이_동작한다(){
        String correctInput = "5";
        Assertions.assertDoesNotThrow(()->validator.validateUserInputIsCorrectRound(correctInput));
    }
    @Test
    void 숫자가_아닌값을_입력하면_에러가_발생한다(){
        String wrongInput = "notInteger";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->
                        validator.validateUserInputIsCorrectRound(wrongInput));
        Assertions.assertEquals("양의 정수를 입력해주세요!",exception.getMessage());
    }
    @Test
    void 음의_정수를_입력하면_에러가_발생한다(){
        String wrongInput = "-4";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->
                        validator.validateUserInputIsCorrectRound(wrongInput));
        Assertions.assertEquals("양의 정수를 입력해주세요!",exception.getMessage());
    }
    @Test
    void 숫자_0을_입력하면_에러가_발생한다(){
        String wrongInput = "0";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->
                        validator.validateUserInputIsCorrectRound(wrongInput));
        Assertions.assertEquals("양의 정수를 입력해주세요!",exception.getMessage());
    }
}
