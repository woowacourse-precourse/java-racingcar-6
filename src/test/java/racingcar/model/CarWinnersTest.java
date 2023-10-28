package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarWinnersTest {

    private final Car jackCar = createCarWithName("jack");
    private final Car johnCar = createCarWithName("john");

    @Test
    void 외부에서_넘겨준_리스트를_수정하더라도_CarWinners의_내부_리스트는_변하지_않는다() {
        List<Car> modifiableWinners = new ArrayList<>(List.of(jackCar, johnCar));
        CarWinners protectedWinners = CarWinners.from(modifiableWinners);

        modifiableWinners.remove(0);

        assertThat(protectedWinners).usingRecursiveComparison()
                .isEqualTo(CarWinners.from(List.of(jackCar, johnCar)));
    }

    @Test
    void 외부에서_getWinners로_받은_리스트를_수정하더라도_CarWinners의_내부_리스트는_변하지_않는다() {
        CarWinners protectedWinners = CarWinners.from(List.of(jackCar, johnCar));
        List<Car> fetchedWinners = protectedWinners.getWinners();

        fetchedWinners.remove(0);

        assertThat(protectedWinners).usingRecursiveComparison()
                .isEqualTo(CarWinners.from(List.of(jackCar, johnCar)));
    }

    private Car createCarWithName(String name) {
        return Car.from(name);
    }

}
