package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Test
    void 자동차는_4이상의_숫자일때_이동() {
        Car car = new Car("chan");
        int randomNumber = 4;
        List<Car> carList = List.of(car);

        Race race = new Race(carList, randomNumber);
        race.moveCarRandomly(car, randomNumber);

        assertThat(car.getPositionLength()).isEqualTo(1);
    }

    @Test
    void 자동차는_4미만의_숫자일때_정지() {
        Car car = new Car("chan");
        int randomNumber = 3;
        List<Car> carList = List.of(car);

        Race race = new Race(carList, randomNumber);
        race.moveCarRandomly(car, randomNumber);

        assertThat(car.getPositionLength()).isEqualTo(0);
    }

    @Test
    void 포지션의_길이가_가장_긴_사람의_이름을_반환() {
        Car car1 = new Car("chan", "-");
        Car car2 = new Car("geon", "--");
        Car car3 = new Car("park", "");
        List<Car> carList = List.of(car1, car2, car3);

        String winners = Race.findWinners(carList);

        assertThat(winners).isEqualTo("geon");
    }

    @Test
    void 포지션의_길이가_가장_긴_사람이_한명_이상인_경우_쉼표로_구분한_이름을_반환() {
        Car car1 = new Car("chan", "-");
        Car car2 = new Car("geon", "--");
        Car car3 = new Car("park", "--");
        List<Car> carList = List.of(car1, car2, car3);

        String winners = Race.findWinners(carList);

        assertThat(winners).isEqualTo("geon, park");
    }

    @Test
    void 자동차리스트에서_포지션_길이가_가장_긴_값을_반환() {
        Car car1 = new Car("chan", "-");
        Car car2 = new Car("geon", "--");
        List<Car> carList = List.of(car1, car2);

        int maxPositionLength = Race.calculateMaxPositionLength(carList);

        assertThat(maxPositionLength).isEqualTo(2);
    }

    @Test
    void 자동차리스트에서_포지션_길이가_가장_긴_자동차의_이름을_리스트로_반환() {
        Car car1 = new Car("chan", "-");
        Car car2 = new Car("geon", "--");
        List<Car> carList = List.of(car1, car2);

        List<String> winningCarNames = Race.getWinningCarNames(carList, 2);

        assertThat(winningCarNames.size()).isEqualTo(1);
        assertThat(winningCarNames.get(0)).isEqualTo("geon");
    }
}