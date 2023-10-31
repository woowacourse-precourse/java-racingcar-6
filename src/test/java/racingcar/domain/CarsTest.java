package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.CANT_FIND_MAX_VALUE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("입력한 이름 갯수만큼 자동차들이 생성된다.")
    @Test
    void of() {
        // given
        List<String> nameList = List.of("a", "bb", "ccc", "dddd");

        // when
        Cars cars = Cars.of(nameList, new RandomNumberGenerator());

        // then
        assertThat(cars.getCars().size()).isEqualTo(nameList.size());
    }

    @DisplayName("자동차들 중 최대 위치를 찾을 수 있다.")
    @Test
    void findMaxPosition() {
        // given
        List<String> nameList = List.of("a", "b", "c", "d", "e");
        Cars cars = Cars.of(nameList, new MonotoneIncreasingNumberGenerator());
        int n = 10;

        // when
        for (int i = 0; i < n; i++) {
            cars.goByNumber();
        }

        // then
        List<Car> winnerCarList = cars.findWinnerCarList();

        List<Car> carList = cars.getCars()
                .stream()
                .filter(winnerCarList::contains)
                .toList();

        assertThat(carList.get(0).getPosition()).isEqualTo(new Position(n));

    }

    @DisplayName("자동차들이 없으면 최대 위치를 찾을 수 없다.")
    @Test
    void findMaxPositionException() {
        // given
        List<String> nameList = List.of();
        Cars cars = Cars.of(nameList, new MonotoneIncreasingNumberGenerator());
        int n = 10;

        // when
        while (n-- > 0) {
            cars.goByNumber();
        }

        // then
        assertThatThrownBy(cars::findWinnerCarList)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CANT_FIND_MAX_VALUE.getMessage());
    }

    @DisplayName("우승자 자동차 리스트를 찾을 수 있다.")
    @Test
    void findWinnerCarList() {
        // given
        Cars cars = Cars.of(List.of("a", "b", "c", "d", "e"), new MonotoneIncreasingNumberGenerator());
        int n = 10;

        // when
        while (n-- > 0) {
            cars.goByNumber();
        }

        // then
        List<Car> winnerCarList = cars.findWinnerCarList();

        assertThat(winnerCarList.get(0).getNameString())
                .contains("e");
    }

    @DisplayName("공동 우승자도 찾을 수 있다.")
    @Test
    void findJoinWinnerCarList() {
        // given
        Cars cars = Cars.of(List.of("a", "b", "c", "d", "e"), new ZeroNumberGenerator());
        int n = 10;

        // when
        while (n-- > 0) {
            cars.goByNumber();
        }

        // then

        List<Car> winnerCarList = cars.findWinnerCarList();

        assertThat(winnerCarList.stream().map(Car::getNameString).toList())
                .containsExactly("a", "b", "c", "d", "e");
    }

    @DisplayName("자동차들을 외부에서 빈 리스트로 변경해도 영향이 없다.")
    @Test
    void externalChangeProtectionEmpty() {
        // given
        List<String> nameList = List.of("a", "b", "c");
        Cars beforeCars = Cars.of(nameList, new RandomNumberGenerator());

        // when
        List<Car> carList = beforeCars.getCars();

        carList = new ArrayList<>();

        // then
        assertThat(beforeCars.getCars().size()).isEqualTo(nameList.size());
    }

    @DisplayName("자동차들을 외부에서 객체 추가로부터 보호된다.")
    @Test
    void externalChangeProtectionAdd() {
        // given
        Cars beforeCars = Cars.of(List.of("a", "b", "c"), new RandomNumberGenerator());

        // when
        List<Car> carList = beforeCars.getCars();

        // then
        assertThatThrownBy(() -> carList.add(Car.from("d")))
                .isInstanceOf(UnsupportedOperationException.class);

    }

    @DisplayName("자동차들을 내부 값을 변경할 수 없다.")
    @Test
    void externalChangeProtectionFrom() {
        // given
        Cars beforeCars = Cars.of(List.of("a", "b", "c"), new RandomNumberGenerator());

        // when
        List<Car> carList = beforeCars.getCars();
        Car car = carList.get(0);
        car = Car.from("d");

        // then
        assertThat(beforeCars.getCars().get(0).getNameString()).isEqualTo("a");
    }

    public static class MonotoneIncreasingNumberGenerator implements NumberGenerator {

        private int number = 0;
        @Override
        public int generate() {
            return number++;
        }
    }

    public static class ZeroNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 0;
        }
    }
}