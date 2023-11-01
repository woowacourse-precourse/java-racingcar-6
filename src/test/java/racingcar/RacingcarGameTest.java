package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingcarGameTest {

    RacingcarGame racingcarGame = new RacingcarGame();

    @Test
    void race_레이스_진행시_차이름과_거리가_반환() {
        racingcarGame.setTryCount(1);
        String[] cars = {"test"};
        racingcarGame.setCars(cars);
        assertThat(racingcarGame.race().get("test")).isBetween(0, 1);
    }
    @Test
    void getWinner_레이스의_우승자_문자열_반환() {
        racingcarGame.setTryCount(1);
        String[] cars = {"test"};
        racingcarGame.setCars(cars);
        racingcarGame.race();

        assertThat(racingcarGame.getWinner()).isEqualTo("test");
    }
}