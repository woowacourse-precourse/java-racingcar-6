package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameResult;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    Racing racing;

    @BeforeEach
    void before() {
        racing = new RacingImpl(List.of("pobi", "woni", "jun"), 5);
    }

    @Test
    void 게임_진행_및_결과를_출력한다() throws Exception {
        // when
        List<List<GameResult>> totalGameResults = racing.start();

        // then
        assertThat(totalGameResults.size()).isEqualTo(5);
    }



    @Test
    void 최종_우승자를_선출한다() throws Exception {
        // given
        makeCarStatus();

        // when
        List<String> winners = racing.getWinners();

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("pobi");
    }

    private void makeCarStatus() throws NoSuchFieldException, IllegalAccessException {
        Class<RacingImpl> racingClass = RacingImpl.class;
        Field participants = racingClass.getDeclaredField("participants");
        participants.setAccessible(true);
        List<Car> cars = (List<Car>) participants.get(racing);

        Class<Car> carClass = Car.class;
        Field position = carClass.getDeclaredField("position");
        position.setAccessible(true);

        Car pobi = cars.get(0);
        position.set(pobi, 2);
    }
}