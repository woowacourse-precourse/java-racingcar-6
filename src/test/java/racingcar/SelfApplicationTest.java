package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import racingcar.Controller.RacingGame;

public class SelfApplicationTest {

    @Test
    void 이름_5글자_이상_예외처리() {
        RacingGame racingGame = new RacingGame();
        String input = "poni,unifolio,gita";
        assertThatThrownBy(() -> {
            racingGame.createCars(input);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름은 5글자 이하여야 합니다");
    }

    @Test
    void 이름_공백_예외처리() {
        RacingGame racingGame = new RacingGame();
        String input1 = "poni,unfs,,gita";
        String input2 = "poni,un,gita,";
        assertThatThrownBy(() -> {
            racingGame.createCars(input1);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름이 없는 자동차가 있습니다.");
        assertThatThrownBy(() -> {
            racingGame.createCars(input2);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름이 없는 자동차가 있습니다.");
    }

    @Test
    void 이름_중복_예외처리() {
        RacingGame racingGame = new RacingGame();
        String input = "uni,folio,uni";
        assertThatThrownBy(() -> {
            racingGame.createCars(input);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("같은 이름의 자동차가 있습니다.");
    }

    @Test
    void 시도횟수_문자_예외처리() {
        RacingGame racingGame = new RacingGame();
        String input = "f";
        assertThatThrownBy(() -> {
            racingGame.parsePlayCount(input);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("숫자만 입력할 수 있습니다.");
    }
}
