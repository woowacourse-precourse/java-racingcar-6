package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

public class RaceRepositoryTest extends NsTest {

    RaceRepository raceRepository = new RaceRepository();

    private List<Car> createListOfCars() {
        return List.of(
                new Car("a"),
                new Car("b"),
                new Car("c")
        );
    }

    private Race createRace() {
        return new Race(createListOfCars(), 3);
    }

    @Test
    void 레포지토리에_게임_저장_후_id로_확인() {
        raceRepository.save(createRace());
        raceRepository.save(createRace());
        assertThat(raceRepository.findById(0L).getCars().get(0).getName()).isEqualTo("a");
        assertThat(raceRepository.findById(0L).getCars().get(1).getName()).isEqualTo("b");
        assertThat(raceRepository.findById(0L).getCars().get(2).getName()).isEqualTo("c");
        assertThat(raceRepository.findById(1L).getCars().get(0).getName()).isEqualTo("a");
        assertThat(raceRepository.findById(1L).getCars().get(1).getName()).isEqualTo("b");
        assertThat(raceRepository.findById(1L).getCars().get(2).getName()).isEqualTo("c");
    }

    @Test
    void 레포지토리에_자동차_저장_후_전체_확인() {
        int n = 4;
        for (int i = 0; i < n; i++) {
            raceRepository.save(createRace());
        }
        assertThat(raceRepository.findAll()).hasSize(n);
    }

    @Override
    protected void runMain() {
    }
}