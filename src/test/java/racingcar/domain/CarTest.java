package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car = new Car("testCar");

    @BeforeEach
    void car_생성_후_3번_move() {
        car.move();
        car.move();
        car.move();
    }

    @Test
    void comparePosition_메소드_사용시_3번_움직였을때_인자로_2를_주면_3을_반환() {
        assertThat(car.comparePosition(2)).isEqualTo(3);
    }

    @Test
    void comparePosition_메소드_사용시_3번_움직였을때_인자로_4를_주면_4를_반환() {
        assertThat(car.comparePosition(4)).isEqualTo(4);
    }

    @Test
    void isFurthestDistance_메소드_사용시_car가_3번_움직이고_인자로_3을_주었을때_true_반환() {
        assertThat(car.isFurthestDistance(3)).isEqualTo(true);
    }

    @Test
    void isFurthestDistance_메소드_사용시_car가_3번_움직이고_인자로_2를_주었을때_false_반환() {
        assertThat(car.isFurthestDistance(2)).isEqualTo(false);
    }

    @Test
    void registerOnWinnerList_메소드_사용시_winnerList에_이름이_등록() {
        //given
        List<String> winnerList = new ArrayList<>();

        //when
        car.registerOnWinnerList(winnerList);

        //then
        assertThat(winnerList.get(0)).isEqualTo("testCar");
    }

    @Test
    void toString_메소드_사용시_3번_움직였을때_출력이_정확한지_확인() {
        //given

        //when
        String result = car.toString();

        //then
        assertThat(result).isEqualTo("testCar : ---");
    }
}
