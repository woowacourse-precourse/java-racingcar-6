package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarRegistryTest {

    private RacingCarRegistry racingCarRegistry;

    @BeforeEach
    public void init() {

    }

    @Test
    public void 우승자가_1명일_때_우승자를_선택할_수_있다() throws Exception {
        // given
        List<RacingCar> racingCars = List.of(
                new RacingCar(Name.of("aaa"), Position.of(3)),
                new RacingCar(Name.of("bbb"), Position.of(2)),
                new RacingCar(Name.of("ccc"), Position.of(1)));

        racingCarRegistry = new RacingCarRegistry(
                new ListActionNumberGenerator(List.of(1, 1, 1, 1, 1)),
                racingCars,
                new MoveOpportunity(10));

        // when
        List<RacingCar> result = racingCarRegistry.calculateWinner();

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName().toString()).isEqualTo("aaa");
    }

    @Test
    public void 우승자가_1명_이상일_때_우승자를_선택할_수_있다() throws Exception {
        // given
        List<RacingCar> racingCars = List.of(
                new RacingCar(Name.of("aaa"), Position.of(3)),
                new RacingCar(Name.of("bbb"), Position.of(3)),
                new RacingCar(Name.of("ccc"), Position.of(1)));

        racingCarRegistry = new RacingCarRegistry(
                new ListActionNumberGenerator(List.of(1, 1, 1, 1, 1)),
                racingCars,
                new MoveOpportunity(10));

        // when
        List<RacingCar> result = racingCarRegistry.calculateWinner();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

}