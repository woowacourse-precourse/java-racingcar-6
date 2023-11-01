package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RacingCarGameServiceTest {

    @Test
    public void 잘못된_반복횟수_입력_에러() throws Exception {
        //given
        InputValidator inputValidator = new InputValidator();
        String input = "a";

        //when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidAttemptNum(input);
        });
        assertEquals("숫자를 입력해주세요.", exception.getMessage());
    }

    @Test
    public void 문자사이_스페이스_에러() throws Exception {

        //given
        InputValidator inputValidator = new InputValidator();
        String input = "car ,car2";

        //when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidCarName(input);
        });
        assertEquals("공백은 사용 불가능합니다.", exception.getMessage());
    }

    @Test
    public void 빈문자_에러() throws Exception {

        //given
        InputValidator inputValidator = new InputValidator();
        String input = "";

        //when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidCarName(input);
        });
        assertEquals("요청한 질문에 맞는 값을 입력해주세요.", exception.getMessage());
    }

    @Test
    public void 동일한_이름_에러() throws Exception {

        //given
        InputValidator inputValidator = new InputValidator();
        String input = "car1,car1";

        //when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidCarName(input);
        });
        assertEquals("자동차의 이름은 중복되지 않게 입력해주세요.", exception.getMessage());
    }

    @Test
    public void 자동차_이름_길이_에러() throws Exception {

        //given
        InputValidator inputValidator = new InputValidator();
        String input = "disiscar";

        //when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidCarName(input);
        });
        assertEquals("자동차의 이름은 5글자 이하로 작성해주세요.", exception.getMessage());
    }


}
