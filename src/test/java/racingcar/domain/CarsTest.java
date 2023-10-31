package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @BeforeEach
    void init() {
        MonotoneIncreasingNumberGenerator.clear();
    }

    @Test
    @DisplayName("자동차들 정상 생성")
    void Cars_정상_생성() {
        // given
        List<String> nameList = List.of("a", "bb", "ccc", "dddd");

        // when
        Cars cars = Cars.of(nameList, new RandomNumberGenerator());

        // then
        assertThat(cars.getCars().size()).isEqualTo(nameList.size());
    }

    @Test
    @DisplayName("최대 위치 추출")
    void 최대_위치_추출() {
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

    @Test
    @DisplayName("빈 List는 최대 위치 추출 불가")
    void 최대_위치_추출_예외() {
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
                .hasMessage("[ERROR] 최대 위치를 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("우승자 추출")
    void 우승자_추출() {
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

    @Test
    @DisplayName("공동 우승자도 추출된다.")
    void 공동_우승자_추출() {
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

    @Test
    @DisplayName("자동차들 객체를 외부 변경으로부터 보호해야한다.")
    void 외부_변경_빈리스트_보호() {
        // given
        List<String> nameList = List.of("a", "b", "c");
        Cars beforeCars = Cars.of(nameList, new RandomNumberGenerator());

        // when
        List<Car> carList = beforeCars.getCars();

        carList = new ArrayList<>();

        // then
        assertThat(beforeCars.getCars().size()).isEqualTo(nameList.size());
    }

    @Test
    @DisplayName("자동차들 객체를 외부에서 객체 추가 보호해야한다.")
    void 외부_추가_보호() {
        // given
        Cars beforeCars = Cars.of(List.of("a", "b", "c"), new RandomNumberGenerator());

        // when
        List<Car> carList = beforeCars.getCars();

        // then
        assertThatThrownBy(() -> carList.add(Car.from("d")))
                .isInstanceOf(UnsupportedOperationException.class);

    }

    @Test
    @DisplayName("자동차들 객체 내부의 자동차 객체도 보호해야한다.")
    void 외부_변경_리스트_내부_변경_보호() {
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

        private static int number = 0;
        @Override
        public int generate() {
            return number++;
        }

        public static void clear() {
            number = 0;
        }
    }

    public static class ZeroNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 0;
        }
    }
}