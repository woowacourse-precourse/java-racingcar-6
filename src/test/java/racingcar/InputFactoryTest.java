package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputFactoryTest {

    @Test
    void 이름을_입력받아서_자동차리스트로_반환() {
        String names = "chan,geon";

        List<Car> cars = InputFactory.getCars(names);

        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getName()).isEqualTo("chan");
        assertThat(cars.get(1).getName()).isEqualTo("geon");
    }

    @Test
    void 문자형_라운드를_입력받아_정수로_반환() {
        String round = "1";

        int racingRound = InputFactory.getRacingRound(round);

        assertThat(racingRound).isEqualTo(1);
    }

    @Test
    void 라운드에_문자를_입력하면_예외_처리() {
        String round = "one";

        assertThatThrownBy(() -> InputFactory.getRacingRound(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    void 라운드를_정수로_반환() {
        String round = "1";

        int roundNumber = InputFactory.parseRoundNumber(round);

        assertThat(roundNumber).isEqualTo(1);
    }

    @Test
    void 라운드_문자_입력시_예외_처리() {
        String round = "a";

        assertThatThrownBy(() -> InputFactory.parseRoundNumber(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    void 양수_외_입력시_예외_처리() {
        int round = 0;

        assertThatThrownBy(() -> InputFactory.validatePositiveNumber(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수를 입력해주세요.");
    }
}