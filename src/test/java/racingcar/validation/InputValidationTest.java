package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidationTest {

    static InputValidation inputValidation;

    @BeforeEach
    public void before() {
        inputValidation = new InputValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void 공백일경우(String input) {
        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(input));
    }

    @Test
    public void 첫글자_공백() {
        //given (주어진 값)
        String oneName = " hi";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(oneName));
    }

    @ParameterizedTest
    @ValueSource(strings = {",", " ,"})
    public void 콤마_시작(String input) {
        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa,bb,aa", "aa,bb,bb,bb"})
    public void 중복발생(String input) {
        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "aa, abcde", "hi, hello world, good"})
    public void 이름_5글자_초과(String input) {
        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputValidation(input));
    }

    @Test
    public void 띄어쓰기() {
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

    @Test
    public void 조건에_맞는_자동차_이름() throws Exception {
        //given (주어진 값)
        String names = "a,aa,aaa,aaaa,aaaaa,b,bb,bbb,bbbb,ccccc";

        //when (기능 작동)
        String[] carNames = inputValidation.checkedInputValidation(names);

        //then (기능 작동 후 결과)
        Assertions.assertThat(carNames.length).isEqualTo(10);
        Assertions.assertThat(carNames[4]).isEqualTo("aaaaa");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void 이동횟수가_없다면(String input) {
        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputNumberValidation(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "g2"})
    public void 이동횟수가_문자라면(String input) {
        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputNumberValidation(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-12", "-123"})
    public void 이동횟수가_0이하(String input) {
        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.checkedInputNumberValidation(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "15", "94", "97", "102"})
    public void 이동횟수_구하기(String input) {
        //given (주어진 값)
        int changeInput = Integer.parseInt(input);

        //when (기능 작동)
        int attemptNumber = inputValidation.checkedInputNumberValidation(input);

        //then (기능 작동 후 결과)
        Assertions.assertThat(attemptNumber).isEqualTo(changeInput);
    }
}