package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {
    private Validator validator;
    private String testNames;
    private String testTrial;

    @BeforeEach
    void setUp() {
        validator = new Validator();

    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,badcar;이름은 5자 이하만 가능합니다", "a,,b,c;이름에 공백이나 ,은 불가합니다.",
            "a,b,a;중복된 이름은 불가합니다."}, delimiter = ';')
    void 자동차이름검증_여러개(String input, String expected) {
        testNames = input;
        List<String> nameList = Arrays.asList(testNames.split(",", -1));
        for (int i = 0; i < nameList.size(); i++) {
            nameList.set(i, nameList.get(i).trim());
        }

        assertThatThrownBy(() -> validator.names(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'',양의 정수를 입력하십시오.", "abc,양의 정수를 입력하십시오.", "012,양의 정수를 입력하십시오.",
            "-30,양의 정수를 입력하십시오."})
    void 시도횟수검증_여러개(String input, String expected) {
        testTrial = input;

        assertThatThrownBy(() -> validator.trial(testTrial.trim()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);

    }


}