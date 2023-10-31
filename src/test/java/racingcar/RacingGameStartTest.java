package racingcar;

import org.junit.jupiter.api.Test;
import pojo.RacingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static racingcar.RacingGameStart.createRacingCar;


class RacingGameStartTest {
    @Test
    void run() {

    }
    @Test
    public void 자동차_객체_초기화() {

        String testCarName = "Fast         ";

        RacingCar racingCar = createRacingCar(testCarName);

        assertNotNull(racingCar);
        assertEquals(racingCar.getName(), "Fast");
        assertEquals(0, racingCar.getDistance());
    }
    @Test
    void 자동차_이름_5자리_이상시_에러_처리() {
        String name ="f1o2u3r4";

        assertThatThrownBy(() -> {
            RacingGameStart.checkNameLength(name);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 5자 이하만 가능합니다");
    }



}