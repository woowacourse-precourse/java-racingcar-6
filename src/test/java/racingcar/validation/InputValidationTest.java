package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    static InputValidation inputValidation;

    @BeforeEach
    public void before(){
        inputValidation = new InputValidation();
    }
    @Test
    public void 공백일경우(){
        //given (주어진 값)
        String input = " ";
        String notInput = "";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(input));

        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(notInput));
    }
    @Test
    public void 첫글자_공백(){
        //given (주어진 값)
        String oneName = " hi";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(oneName));
    }

    @Test
    public void 콤마_시작(){
        //given (주어진 값)
        String oneName = ",";
        String twoName = " ,";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(oneName));

        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(twoName));

    }

    @Test
    public void 이름_5글자_초과(){
        //given (주어진 값)
        String oneName = "aaaaaa";
        String twoNames = "aa, abcde";
        String threeNames = "hi, hello world, good";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(oneName));

        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(twoNames));

        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(threeNames));
    }

    @Test
    public void 띄어쓰기(){
        //given (주어진 값)
        String oneNames = "hi ho";
        String twoNames = "hi,goo d";
        String threeNames = "hi,go od,w orl";
        String fourNames = "hi,g ood,wo rl,a b c";

        //when (기능 작동)
        String[] oneName = inputValidation.checkedInputValidation(oneNames);
        String[] twoName = inputValidation.checkedInputValidation(twoNames);
        String[] threeName = inputValidation.checkedInputValidation(threeNames);
        String[] fourName = inputValidation.checkedInputValidation(fourNames);

        //then (기능 작동 후 결과)
        Assertions.assertThat(oneName.length).isEqualTo(1);
        Assertions.assertThat(oneName[0]).isEqualTo(oneNames);
        Assertions.assertThat(oneName[0].length()).isEqualTo(5);

        Assertions.assertThat(twoName.length).isEqualTo(2);
        Assertions.assertThat(twoName[1]).isEqualTo("goo d");
        Assertions.assertThat(twoName[1].length()).isEqualTo(5);

        Assertions.assertThat(threeName.length).isEqualTo(3);
        Assertions.assertThat(threeName[2]).isEqualTo("w orl");
        Assertions.assertThat(threeName[2].length()).isEqualTo(5);

        Assertions.assertThat(fourName.length).isEqualTo(4);
        Assertions.assertThat(fourName[3]).isEqualTo("a b c");
        Assertions.assertThat(fourName[3].length()).isEqualTo(5);
    }

}