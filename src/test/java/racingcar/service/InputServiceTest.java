package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.GameNum;

class InputServiceTest {

    private final InputService inputService = new InputService();
    private final Cars cars = Cars.create();

    @Test
    void 이름이_올바르게_입력된_경우() {
        String input = "a,b,c";
        inputService.carsName(input);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 이름에_공백을_입력한_경우() {
        String input = " ";
        assertThatThrownBy(() -> inputService.carsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백이 포함되어 있습니다.");
    }

    @Test
    void 이름사이에_공백을_입력한_경우() {
        String input = "a, b,c";
        assertThatThrownBy(() -> inputService.carsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백이 포함되어 있습니다.");
    }

    @Test
    void 이름_글자수가_5글자초과인_경우() {
        String input = "aaaaaa";
        assertThatThrownBy(() -> inputService.carsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5글자 사이여야 합니다.");
    }

    @Test
    void 이름을_빈문자열로_입력한_경우() {
        String input = "";
        assertThatThrownBy(() -> inputService.carsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5글자 사이여야 합니다.");
    }

    @Test
    void 중복되는_이름을_입력한_경우() {
        String input = "a,b,a";
        assertThatThrownBy(() -> inputService.carsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 이름이 있습니다.");
    }

    @Test
    void 게임횟수가_올바르게_입력된_경우() {
        String input = "3";
        inputService.gameNum(input);
        GameNum gameNum = new GameNum();
        assertThat(gameNum.getNumber()).isEqualTo(3);
    }

    @Test
    void 게임횟수에_공백을_입력한_경우() {
        String input = " ";
        assertThatThrownBy(() -> inputService.gameNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백이 포함되어 있습니다.");
    }

    @Test
    void 게임횟수에_문자를_입력한_경우() {
        String input = "a";
        assertThatThrownBy(() -> inputService.gameNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임횟수는 숫자여야 합니다.");
    }

    @Test
    void 게임횟수에_1보다_작은수를_입력한_경우() {
        String input = "0";
        assertThatThrownBy(() -> inputService.gameNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임횟수는 1이상 이여야 합니다.");
    }
}