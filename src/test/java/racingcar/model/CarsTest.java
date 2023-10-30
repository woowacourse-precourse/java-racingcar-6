//package racingcar.model;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import racingcar.constant.Error;
//
//class CarsTest {
//
//    private final String[] carArray = {"벤츠", "아우디", "BMW", "페라리"};
//    private Cars cars;
//
//    @BeforeEach
//    void beforeEach() {
//        cars = new Cars(carArray);
//    }
//
//    @Test
//    void 중복된_자동차_이름_확인() {
//        String[] stringArray = {"A", "A", "B"};
//        assertThatThrownBy(() -> new Cars(stringArray))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(Error.DUPLICATE_CAR_NAME_ERROR.getMessage());
//    }
//
//    @Test
//    void 가장_멀리있는_자동차_위치_확인() {
//        cars.moveCar(1);
//        cars.moveCar(1);
//        assertThat(cars.getMaxPosition()).isEqualTo(2);
//
//    }
//
//    @Test
//    void 우승_자동차_확인() {
//        cars.moveCar(0);
//        cars.moveCar(1);
//        List<String> resultCarlist = new ArrayList<>(Arrays.asList("벤츠", "아우디"));
//        assertThat(cars.getVictoryCarNames()).isEqualTo(resultCarlist);
//    }
//}