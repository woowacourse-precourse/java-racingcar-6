package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constants.MessageConstants;

public class RaceTest {
    private Race race;
    private List<Car> cars;

    @BeforeEach
    void preparatoryWork() {
        cars = Arrays.asList(new Car("red"), new Car("blue"), new Car("green"));
        race = new Race(cars, 5);
    }

    @Test
    void 레이스_생성_확인() {
        assertThat(race).isNotNull();
        assertThat(race.getCars()).isEqualTo(cars);
    }

    @Test
    void 레이스_시작_확인() {
        race.startOfRace();
        assertThat(race.getCars()).isNotEmpty();
    }

    @Test
    void 우승자_사람_수_비교() {
        race.startOfRace();
        List<String> winners = race.getWinners();
        assertThat(winners).isNotEmpty();
        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void 우승자_판별() {
        cars.get(0).judgmentCarMove(4);
        cars.get(0).judgmentCarMove(3);
        cars.get(0).judgmentCarMove(4);

        cars.get(1).judgmentCarMove(3);
        cars.get(1).judgmentCarMove(4);
        cars.get(1).judgmentCarMove(4);

        cars.get(2).judgmentCarMove(3);
        cars.get(2).judgmentCarMove(3);
        cars.get(2).judgmentCarMove(4);

        List<String> winners = race.getWinners();
        List<String> anticipation = Arrays.asList("red", "blue");
        assertThat(winners).isEqualTo(anticipation);
    }

    @Test
    void 차_리스트가_비어있을_때_예외발생() {
        race = new Race(Arrays.asList(), 3);
        assertThatThrownBy(() -> {
            race.getWinners();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.EMPTY_CAR_LIST);
    }
}

