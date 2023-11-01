package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinnersTest {
    private static final String JACK = "jack";
    private static final String CRONG = "crong";
    private static final int POSITION_5 = 5;
    private static final int POSITION_4 = 4;
    private static final Car CAR_JACK_5_POSITION = createCar(JACK, POSITION_5);
    private static final Car CAR_CRONG_4_POSITION = createCar(CRONG, POSITION_4);

    @Test
    void 외부로부터_받은_우승_자동차_목록이_변경되어도_내부_우승자_목록은_변경되지_않는다() {
        List<Car> modifiableWinners = new ArrayList<>(List.of(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION));
        Winners protectedWinners = createWinners(modifiableWinners);
        Winners expectedWinners = createWinners(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION);

        modifiableWinners.clear();

        assertThat(protectedWinners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 외부로_반환된_우승_자동차_목록이_변경되어도_내부_목록은_변경되지_않는다() {
        Winners protectedWinners = createWinners(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION);
        List<Car> modifiableWinners = protectedWinners.getCars();
        Winners expectedWinners = createWinners(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION);

        modifiableWinners.clear();

        assertThat(protectedWinners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    private static Car createCar(String name, int position) {
        CarName carName = CarName.from(name);
        CarPosition carPosition = new CarPosition(position);
        return new Car(carName, carPosition);
    }

    private Winners createWinners(Car... cars) {
        return Winners.from(List.of(cars));
    }

    private Winners createWinners(List<Car> cars) {
        return Winners.from(cars);
    }

}
