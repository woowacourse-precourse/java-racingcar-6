package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNamesSeperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"abcde,fdadde|abcde|fdadde", "lukas,moura|lukas|moura"}, delimiter = '|')
        //결과를 가변인자로 받아보려 했으나 실패
    void 문자열_구분_테스트(String userInputNames, String result1, String result2) {
        List<String> separateNames = CarNamesSeperator.separate(userInputNames);

        assertThat(separateNames).contains(result1, result2);
    }
}