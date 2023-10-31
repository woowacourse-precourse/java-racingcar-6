package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class UserInputParserTest {
    private UserInputParser userInputParser;

    @BeforeEach
    void setUp() {
        userInputParser = new UserInputParser();
    }

    @Test
    void parseInt_메서드로_유저_입력_값을_숫자로_변환() {
        // given
        String userInput = "1";
        // when
        int result = userInputParser.parseInt(userInput);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void parseInt_메서드에_숫자가_아닌_값을_입력하면_에러_발생() {
        // given
        String userInput = "a";
        // when, then
        assertThatThrownBy(() -> userInputParser.parseInt(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    void generateCarList() {
    }
}