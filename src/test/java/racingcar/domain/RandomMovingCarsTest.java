package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import racingcar.constant.IllegalArgumentExceptionType;

class RandomMovingCarsTest {

    @Test
    void 빈_리스트로_객체_생성_실패_테스트() {
        List<Car> Cars = List.of();

        assertThatThrownBy(() -> new Cars(Cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.EMPTY_CARS_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 중복_차량_이름으로_객체_생성_실패_테스트() {
        List<Car> Cars = List.of(
                new RandomMovingCar("붕붕카"),
                new RandomMovingCar("붕붕카")
        );

        assertThatThrownBy(() -> new Cars(Cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.DUPLICATED_CARS_ERROR_MESSAGE.getMessage());

    }

    @Test
    void 객체_생성_성공_테스트() {
        List<Car> Cars = List.of(
                new RandomMovingCar("붕붕카"),
                new RandomMovingCar("범퍼카")
        );

        assertThatCode(() -> new Cars(Cars)).doesNotThrowAnyException();
    }

    @Test
    void 차량이동_테스트() {
            Car win1 = new AlwaysMovingCar("붕붕카");
            Car win2 = new AlwaysMovingCar("범퍼카");
            Car lose = new NeverMovingCar("불법카");
            Cars instance = new Cars(
                    List.of(win1, win2, lose)
            );
            // when
            instance.moveCars();
            // then
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(win1.getDistance()).isEqualTo(1);
            softAssertions.assertThat(win2.getDistance()).isEqualTo(1);
            softAssertions.assertThat(lose.getDistance()).isEqualTo(0);
            softAssertions.assertAll();

    }
}