package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarGroupTest {

    @Test
    void 경주에_참여할_자동차_그룹으로_묶을_자동차가_없으면_안된다() {
        assertThatThrownBy(() -> CarGroup.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주에_참여할_자동차_그룹은_최소한_한대의_자동차가_있으면_괜찮다() {
        assertDoesNotThrow(
                () -> CarGroup.from(List.of("jack"))
        );
    }

    @Test
    void 경주에_참여할_자동차_그룹은_중복된_이름이_있으면_안된다() {
        assertThatThrownBy(() -> CarGroup.from(List.of("jack", "jack")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주에_참여할_자동차_그룹에_중복된_이름이_없으면_괜찮다() {
        assertDoesNotThrow(
                () -> CarGroup.from(List.of("jack", "john"))
        );
    }

    @Test
    void 자동차_그룹에서_공동_우승자를_찾을_수_있다() {
        Car jackCar = createCarWith("jack", 5);
        Car johnCar = createCarWith("john", 5);
        CarGroup carGroup = new CarGroup(List.of(jackCar, johnCar));
        CarWinners expectedWinners = CarWinners.from(List.of(jackCar, johnCar));

        CarWinners winners = carGroup.findWinners();

        assertThat(winners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 자동차_그룹에서_단일_우승자를_찾을_수_있다() {
        Car jackCar = createCarWith("jack", 5);
        Car johnCar = createCarWith("john", 4);
        CarGroup carGroup = new CarGroup(List.of(jackCar, johnCar));
        CarWinners expectedWinners = CarWinners.from(List.of(jackCar));

        CarWinners winners = carGroup.findWinners();

        assertThat(winners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 자동차_그룹은_모든_자동차를_한_칸_전진시킬_수_있다() {
        Car jackCar = createCarWith("jack", 0);
        Car johnCar = createCarWith("john", 0);
        CarGroup carGroup = new CarGroup(List.of(jackCar, johnCar));
        CarGroup expectedCarGroup = new CarGroup(List.of(
                createCarWith("jack", 1),
                createCarWith("john", 1)
        ));
        MovementCondition movable = () -> true;

        CarGroup actualCarGroup = carGroup.moveAll(movable);

        assertThat(actualCarGroup).usingRecursiveComparison()
                .isEqualTo(expectedCarGroup);
    }

    @Test
    void 자동차_그룹은_모든_자동차를_한_칸_전진시키지_않을_수_있다() {
        Car jackCar = createCarWith("jack", 0);
        Car johnCar = createCarWith("john", 0);
        CarGroup carGroup = new CarGroup(List.of(jackCar, johnCar));
        CarGroup expectedCarGroup = new CarGroup(List.of(
                createCarWith("jack", 0),
                createCarWith("john", 0)
        ));
        MovementCondition immovable = () -> false;

        CarGroup actualCarGroup = carGroup.moveAll(immovable);

        assertThat(actualCarGroup).usingRecursiveComparison()
                .isEqualTo(expectedCarGroup);
    }

    private Car createCarWith(String name, int position) {
        return new Car(CarName.from(name), new CarPosition(position));
    }
}
