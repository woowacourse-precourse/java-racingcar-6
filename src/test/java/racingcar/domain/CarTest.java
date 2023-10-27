package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @DisplayName("car가 3번 move()한 상태에서 comparablePosition을 주면 expect를 반환")
    @CsvSource(value = {"1,3", "2,3", "5,5", "12,12"})
    void comparePosition(int comparablePosition, int expect) {
        assertThat(car.comparePosition(comparablePosition)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("car가 3번 move()한 상태에서 furtherDistance를 주면 boolean 반환")
    @CsvSource(value = {"1,false", "2,false", "3, true"})
    void isFurthestDistance(int furtherDistance, boolean result) {
        assertThat(car.isFurthestDistance(furtherDistance)).isEqualTo(result);
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
