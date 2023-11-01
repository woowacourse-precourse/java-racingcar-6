package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void generateCarList_메서드로_사용자의_입력값을_carList로_변형_차량_1대() {
        // given
        String userInput = "A";

        // when
        List<Car> carList = userInputParser.generateCarList(userInput);

        // then
        assertThat(carList).hasSize(1);
        assertThat(carList.get(0).getName()).isEqualTo("A");
    }

    @Test
    void generateCarList_메서드로_사용자의_입력값을_carList로_변형_차량_2대() {
        // given
        String userInput = "A,B";

        // when
        List<Car> carList = userInputParser.generateCarList(userInput);

        // then
        assertThat(carList).hasSize(2);
        assertThat(carList.get(0).getName()).isEqualTo("A");
        assertThat(carList.get(1).getName()).isEqualTo("B");
    }

    @Test
    void generateCarList_메서드로_사용자의_입력값을_carList로_변형_차량_3대() {
        // given
        String userInput = "A,B,C";

        // when
        List<Car> carList = userInputParser.generateCarList(userInput);

        // then
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("A");
        assertThat(carList.get(1).getName()).isEqualTo("B");
        assertThat(carList.get(2).getName()).isEqualTo("C");
    }

    @Test
    void generateCarList_메서드로_사용자의_입력값을_carList로_변형_중_차량의_이름이_5글자_초과면_에러발생() {
        // given
        String userInput = "A,B,CDEFGH";

        // when, then
        assertThatThrownBy(() -> userInputParser.generateCarList(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차량 이름은 5글자 이하이어야 합니다.");
    }
}