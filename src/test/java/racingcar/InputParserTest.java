package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputParser;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputParserTest {
    private InputParser inputParser = new InputParser();

    @ParameterizedTest
    @CsvSource(value = {"'po,na',2", "'poni,woni,jun',3", "'1, 2, 3s',3"})
    void parserInput에_문자열주면_이름리스트반환(String input, int expected) {
        List<String> result = inputParser.parseNames(input);
//        for (String s : result) {
//            System.out.println(s);
//        }
        assertThat(result.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"po,po", "poni,woni,woni", "1,2,3,3"})
    void parserInput에_중복이름문자열주면_예외반환(String duplicated_input) {
        assertThatThrownBy(() -> inputParser.parseNames(duplicated_input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}