package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarRaceTest {

    @Test
    void 자동차_이름_입력_시도_횟수_입력에_따른_경주_정보_생성() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        int attemptCount = 5;

        // when
        RacingCarRace racingCarRace = RacingCarRace.createRacingCarRace(carNames, attemptCount);

        // then
        List<RacingCar> racingCars = racingCarRace.getRacingCars();

        assertThat(racingCars.size()).isEqualTo(3);
        assertThat(racingCarRace.getAttemptCount()).isEqualTo(attemptCount);
    }

    @Test
    void 경주_자동차들의_이름을_가져옵니다() {
        // given
        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(RacingCar.of("pobi"));
        racingCars.add(RacingCar.of("woni"));
        racingCars.add(RacingCar.of("jun"));

        // when
        String carNames = RacingCarRace.concatCarNames(racingCars);

        // then
        assertThat(carNames).contains("pobi");
        assertThat(carNames).contains("woni");
        assertThat(carNames).contains("jun");
    }

    @Test
    void 경주에서의_최종_우승자를_결정합니다() {
        // given 1
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        int attemptCount = 5;
        RacingCarRace racingCarRace = RacingCarRace.createRacingCarRace(carNames, attemptCount);
        List<RacingCar> racingCars = racingCarRace.getRacingCars();

        // given 2
        RacingCar racingCar1 = racingCars.get(0);
        RacingCar racingCar2 = racingCars.get(1);

        racingCar1.move(9);
        racingCar2.move(9);

        // when
        List<RacingCar> winners = racingCarRace.findWinners();

        // then
        assertThat(winners.get(0)).isSameAs(racingCar1);
        assertThat(winners.get(1)).isSameAs(racingCar2);
    }
}