package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PlayTest {
    private Play play;

    @BeforeEach
    void setUp() {
        play = new Play();
    }

    @Test
    void 자동차_이름_입력_검증() {
        List result = play.inputCarName("khj,chj");

        assertThat(result).isEqualTo(Arrays.asList("khj","chj"));
    }

    @Test
    void 전진_횟수_String을_int로_변환 () {
        int result = play.inputNumber("123");

        assertThat(result).isEqualTo(123);
    }

    @Test
    void 우승자_목록_출력 () {
        List<Car> carList = new ArrayList();
        carList.add(new Car("khj","-----"));
        carList.add(new Car("chj","----"));

        List<String> winnerList = play.winner(carList);

        assertThat(winnerList).isEqualTo(Arrays.asList("khj"));
    }

    @Test
    void 자동차_이름_예외체크 () {
        String result = "car12";

        assertThatThrownBy(() -> play.carNameCheck(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("영문자로 입력하여 주세요.");
    }

    @Test
    void 자동차_이름_예외체크2 () {
        String result = "carNameTest";

        assertThatThrownBy(() -> play.carNameCheck(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 전진_횟수_예외체크 () {
        String number = "12test";

        assertThatThrownBy(() -> play.numberCheck(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력하여 주세요.");
    }
}
