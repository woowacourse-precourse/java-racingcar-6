package racingcar.collaborator.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.io.racing.FailureRaceRandoms;
import racingcar.io.racing.RaceRandoms;
import racingcar.io.racing.SuccessRaceRandoms;

class RacerTest {

    @Test
    void drive성공후에_progress가_증가한다() {
        Racer racer = new Racer("홍길동", new SuccessRaceRandoms());
        int initialValue = racer.getProgress().mileage();

        racer.drive();

        int expected = initialValue + 1;
        int actual = racer.getProgress().mileage();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void drive실패후에_progress가_증가하지않는다() {
        Racer racer = new Racer("홍길동", new FailureRaceRandoms());
        int initialValue = racer.getProgress().mileage();

        racer.drive();

        int expected = initialValue;
        int actual = racer.getProgress().mileage();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 초기화한_이름대로_잘생성된다() {
        String expected = "홍길동";

        Racer racer = new Racer(expected, new RaceRandoms());

        assertThat(racer.getName()).isEqualTo(expected);
    }

}