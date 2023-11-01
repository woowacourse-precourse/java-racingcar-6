package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void 생성시_이름_예외처리() {
        // 성공 case : 5자 이하의 이름
        RacingCar successRacingCar = new RacingCar("abcde");
        assertThat(successRacingCar).isInstanceOf(RacingCar.class);
        // 실패 case : 6자 이상의 이름
        assertThatThrownBy(() -> {
            RacingCar failRacingCar = new RacingCar("failed");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하여야합니다.");
    }

    @Test
    void 전진하기() {
        // tryForward가 4 이상이면 전진한다.
        RacingCar racingCar0 = new RacingCar("test1");
        RacingCar racingCar1 = new RacingCar("test2");
        racingCar0.tryForward(3);
        racingCar1.tryForward(4);
        assertThat(racingCar0.getPosition()).isEqualTo(0);
        assertThat(racingCar1.getPosition()).isEqualTo(1);
    }

    @Test
    void toString_이름과_진행도를_출력() {
        RacingCar racingCar = new RacingCar("test");
        racingCar.tryForward(4);
        racingCar.tryForward(4);
        assertThat(racingCar.toString()).isEqualTo("test : --");

    }

}
