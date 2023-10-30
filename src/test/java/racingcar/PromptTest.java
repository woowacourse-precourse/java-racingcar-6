package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PromptTest {


    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    @DisplayName("자동차의 이름들을 입력받는다.")
    void readCarNames() {
        //given
        String carNames = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(carNames.getBytes()));
        String[] carNameArray = new String[]{"pobi", "woni", "jun"};
        //when
        String[] result = Prompt.readCarNames();

        //then
        Assertions.assertThat(result).isEqualTo(carNameArray);
    }

    @Test
    @DisplayName("자동차의 이름은 5자 이하로 입력받는다.")
    void readCarNamesException() {
        String carNames = "iamcar,woni,jun";
        System.setIn(new ByteArrayInputStream(carNames.getBytes()));

        Assertions.assertThatThrownBy(() -> Prompt.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주에서 진행할 턴의 최대 횟수를 입력 받는다.")
    void readMaxTurn() {
        //given
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Integer result = Prompt.readMaxTurn();

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 받은 횟수는 숫자이어야 한다.")
    void readMaxTurnException() {
        //given
        String input = "a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        Assertions.assertThatThrownBy(() -> Prompt.readMaxTurn())
                .isInstanceOf(IllegalArgumentException.class);
    }
}