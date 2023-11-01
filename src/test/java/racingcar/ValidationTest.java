package racingcar;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest {

    private final Validation validation = new Validation();

    @Test
    void 차이름검증_정상() {
        //given
        String input = "pobi,woni,jun";
        //when
        boolean isValid = validation.validateInput(Constant.CARS_VALIDATE, input);
        //then
        Assertions.assertThat(isValid).isTrue();

    }

    @Test
    void 차이름검증_입력이없을때() {
        //given
        String input = "";
        //when
        boolean isValid = validation.validateInput(Constant.CARS_VALIDATE, input);
        //then
        Assertions.assertThat(isValid).isFalse();

    }

    @Test
    void 차이름검증_5글자가넘어갈때() {
        //given
        String input = "suhoonsuhoon,suhoonnnn";
        //when
        boolean isValid = validation.validateInput(Constant.CARS_VALIDATE, input);
        //then
        Assertions.assertThat(isValid).isFalse();

    }

    @Test
    void 차이름검증_구분자가없을때() {
        //given
        String input = "suho";
        //when
        boolean isValid = validation.validateInput(Constant.CARS_VALIDATE, input);
        //then
        Assertions.assertThat(isValid).isTrue();

    }

    @Test
    void 시도할횟수_정상() {
        //given
        String input = "5";
        //when
        boolean isValid = validation.validateInput(Constant.TIME_VALIDATE, input);

        //then
        Assertions.assertThat(isValid).isTrue();

    }

    @Test
    void 시도할횟수_입력이없을때() {
        //given
        String input = "";
        //when
        boolean isValid = validation.validateInput(Constant.TIME_VALIDATE, input);
        //then
        Assertions.assertThat(isValid).isFalse();

    }

    @Test
    void 시도할횟수_숫자가아닐때() {
        //given
        String input = "sootja";
        //when
        boolean isValid = validation.validateInput(Constant.TIME_VALIDATE, input);
        //then
        Assertions.assertThat(isValid).isFalse();

    }


}   