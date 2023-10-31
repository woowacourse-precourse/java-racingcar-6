package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차들 정상 생성")
    void Cars_정상_생성() {
        // given
        List<String> nameList = List.of("a", "bb", "ccc", "dddd");

        // when
        Cars cars = Cars.of(nameList, new RandomNumberGenerator());

        // then
        assertThat(cars.getCars().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차들 이름에 5글자 초과가 들어올 수 없다.")
    void Cars_비정상_생성() {
        // given
        List<String> nameList = List.of("a", "bb", "ccc", "dddddd");

        // when then
        assertThatThrownBy(() -> Cars.of(nameList, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름 길이는 5 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차들의 이름이 공백일 수 없다.")
    void Cars_비정상_생성_이름없음() {
        // given
        List<String> nameZero = List.of("", " ");

        // when then
        assertThatThrownBy(() -> Cars.of(nameZero, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 빈칸일 수 없습니다.");

    }

    @Test
    @DisplayName("최대 위치 추출")
    void 최대_위치_추출() {
        // given
        List<String> nameList = List.of("a", "b", "c", "d", "e");
        Cars cars = Cars.of(nameList, new MonotoneIncreasingNumberGenerator());
        int n = 10;

        // when
        while (n-- > 0) {
            cars.goByNumber();
        }

        // then
        List<String> winnerNameList = cars.findWinnerNameList();
        List<Car> carList = cars.getCars()
                .stream()
                .filter(car -> winnerNameList.contains(car.getNameString()))
                .toList();

        assertThat(carList.get(0).getPosition()).isEqualTo(new Position(10));

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
        assertThatThrownBy(cars::findWinnerNameList)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최대 위치를 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("우승자 추출")
    void 우승자_이름_추출() {
        // given
        List<String> nameList = List.of("a", "b", "c", "d", "e");
        Cars cars = Cars.of(nameList, new MonotoneIncreasingNumberGenerator());
        int n = 10;

        // when
        while (n-- > 0) {
            cars.goByNumber();
        }

        // then
        List<String> winnerNameList = cars.findWinnerNameList();

        assertThat(winnerNameList)
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

        List<String> winnerNameList = cars.findWinnerNameList();

        assertThat(winnerNameList)
                .containsExactly("a", "b", "c", "d", "e");
    }

    @Test
    @DisplayName("자동차들 객체를 외부 변경으로부터 보호해야한다.")
    void 외부_변경_빈리스트_보호() {
        // given
        Cars beforeCars = Cars.of(List.of("a", "b", "c"), new RandomNumberGenerator());

        // when
        List<Car> carList = beforeCars.getCars();

        carList = new ArrayList<>();

        // then
        assertThat(beforeCars.getCars().size()).isEqualTo(3);
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
    }

    public static class ZeroNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 0;
        }
    }
}