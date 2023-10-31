package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class ParticipantsTest {

    @Test
    void 레이스를_진행할_수_있다() {
        List<Car> cars = List.of(
                new Car("car1", 0, () -> true),
                new Car("car2", 0, () -> false),
                new Car("car3", 0, () -> true));
        Participants participants = new Participants(cars);

        List<Car> race = participants.race();

        List<Integer> positions = race.stream()
                .map(Car::getPosition)
                .toList();
        assertThat(positions).isEqualTo(List.of(1, 0, 1));
    }

    @Test
    void 우승자_목록을_가져올_수_있다() {
        List<Car> cars = List.of(
                new Car("car1", 3, null),
                new Car("car2", 2, null),
                new Car("car3", 3, null));
        Participants participants = new Participants(cars);

        List<String> winners = participants.getWinners();

        assertThat(winners).contains("car1", "car3").doesNotContain("car2");
    }
}
