package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
    @Test
    @DisplayName("경주 생성 성공")
    public void create() {
        // given
        String names = "car,race,win";
        String count = "5";

        // when
        Race race = new Race(names, count);

        // then
        assertThat(race).isNotNull();
        assertThat(race.getMoveCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("입력받은 이동 횟수가 1 미만일 경우, 경주 생성 실패")
    public void createRangeFail() throws Exception {
        // given
        String name = "car,race,win";
        String count = "0";

        // when
        // then
        assertThatThrownBy(() -> new Race(name, count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 이동 횟수가 숫자가 아닐 경우, 경주 생성 실패")
    public void createNumberFail() throws Exception {
        // given
        String names = "car,race,win";
        String count = "$$";

        // when
        // then
        assertThatThrownBy(() -> new Race(names, count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getMaxCount() {
        // given
        String name = "car";
        String count = "5";
        Race race = new Race(name, count);

        // when
        Car car = race.getCars().get(0);
        car.move(5);
        car.move(6);

        // then
        assertThat(race.getMaxCount()).isEqualTo(2);
    }
}