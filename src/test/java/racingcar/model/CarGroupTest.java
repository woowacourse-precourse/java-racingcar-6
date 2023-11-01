package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarGroupTest {
    private static final String JACK = "jack";
    private static final String CRONG = "crong";
    private static final MovementCondition movable = () -> true;
    private static final MovementCondition immovable = () -> false;
    private static final Car CAR_JACK_5_POSITION = createCar(JACK, 5);
    private static final Car CAR_JACK_1_POSITION = createCar(JACK, 1);
    private static final Car CAR_JACK_0_POSITION = createCar(JACK, 0);
    private static final Car CAR_CRONG_5_POSITION = createCar(CRONG, 5);
    private static final Car CAR_CRONG_4_POSITION = createCar(CRONG, 4);
    private static final Car CAR_CRONG_1_POSITION = createCar(CRONG, 1);
    private static final Car CAR_CRONG_0_POSITION = createCar(CRONG, 0);

    @Test
    void 경주에_참가할_자동차가_없으면_자동차_그룹으로_생성할_수_없다() {
        assertThatThrownBy(() -> CarGroup.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주에_참가할_최소한_한대의_자동차가_있으면_자동차_그룹으로_생성할_수_있다() {
        assertDoesNotThrow(
                () -> CarGroup.from(List.of(JACK))
        );
    }

    @Test
    void 경주에_참여할_자동차끼리_중복된_이름이_있으면_자동차_그룹으로_생성할_수_없다() {
        assertThatThrownBy(() -> CarGroup.from(List.of(JACK, JACK)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주에_참여할_자동차끼리_중복된_이름이_없으면_자동차_그룹으로_생성할_수_있다() {
        assertDoesNotThrow(
                () -> CarGroup.from(List.of(JACK, CRONG))
        );
    }

    @Test
    void 동일한_최대위치_값을_가진_자동차들은_공동_우승자이다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_5_POSITION, CAR_CRONG_5_POSITION);
        Winners expectedWinners = createWinners(CAR_JACK_5_POSITION, CAR_CRONG_5_POSITION);

        Winners actualWinners = carGroup.findWinners();

        assertThat(actualWinners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 모두_이동하지_않으면_모든_자동차가_우승자이다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        Winners expectedWinners = createWinners(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);

        Winners actualWinners = carGroup.findWinners();

        assertThat(actualWinners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 가장_멀리_이동한_자동차만_단독_우승자이다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION);
        Winners expectedWinners = createWinners(CAR_JACK_5_POSITION);

        Winners winners = carGroup.findWinners();

        assertThat(winners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 모든_자동차가_전진할_수_있다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        CarGroup expectedCarGroup = createCarGroup(CAR_JACK_1_POSITION, CAR_CRONG_1_POSITION);

        CarGroup actualCarGroup = carGroup.moveAll(movable);

        assertThat(actualCarGroup).usingRecursiveComparison()
                .isEqualTo(expectedCarGroup);
    }

    @Test
    void 모든_자동차가_전진하지_않을_수_있다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        CarGroup expectedCarGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);

        CarGroup actualCarGroup = carGroup.moveAll(immovable);

        assertThat(actualCarGroup).usingRecursiveComparison()
                .isEqualTo(expectedCarGroup);
    }

    @Test
    void 외부로부터_받은_자동차_목록이_변경되어도_내부_목록은_변경되지_않는다() {
        List<Car> modifiableCars = new ArrayList<>(List.of(CAR_JACK_1_POSITION, CAR_CRONG_1_POSITION));
        CarGroup protectedCarGroup = createCarGroup(modifiableCars);
        CarGroup expectedCarGroup = createCarGroup(CAR_JACK_1_POSITION, CAR_CRONG_1_POSITION);

        modifiableCars.clear();

        assertThat(protectedCarGroup).usingRecursiveComparison()
                .isEqualTo(expectedCarGroup);
    }

    @Test
    void 외부로_반한된_자동차_목록이_변경되어도_내부_목록은_변경되지_않는다() {
        CarGroup protectedCarGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        List<Car> modifiableCars = protectedCarGroup.getCars();
        CarGroup expectedCarGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);

        modifiableCars.clear();

        assertThat(protectedCarGroup).usingRecursiveComparison()
                .isEqualTo(expectedCarGroup);
    }

    private static Car createCar(String name, int position) {
        return new Car(CarName.from(name), new CarPosition(position));
    }

    private CarGroup createCarGroup(Car... cars) {
        return new CarGroup(List.of(cars));
    }

    private CarGroup createCarGroup(List<Car> cars) {
        return new CarGroup(cars);
    }

    private Winners createWinners(Car... cars) {
        return Winners.from(List.of(cars));
    }

}
