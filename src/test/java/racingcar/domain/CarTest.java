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

    CarName testCar;
    Car car;


    @BeforeEach
    @DisplayName("test라는 이름을 가진 Car를 생성후 인자로 전진 조건에 맞는 값을 강제로 넣어 3번 전진시킴")
    void makeTestCarAndMoveThreeTimes(){
        testCar = new CarName("test");
        car = new Car(testCar);
        int randomNum = 4;
        car.move(randomNum);
        car.move(randomNum);
        car.move(randomNum);
    }

    @ParameterizedTest
    @DisplayName("인자로 받은 수가 4이상일때만 전진")
    @CsvSource(value = {"0,3", "3,3", "4,4", "9,4"})
    void moveTest(int randomNumber, int expect) {
        //given

        //when
        car.move(randomNumber);

        //then
        assertThat(car).extracting("position").isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("comparablePosition을 주면 본인과 비교하여 더 큰것을 반환")
    @CsvSource(value = {"1,3", "2,3", "5,5", "12,12"})
    void comparePositionTest(int comparablePosition, int expect) {
        //given

        //when
        int biggerNum = car.comparePosition(comparablePosition);

        //then
        assertThat(biggerNum).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("furtherDistance를 주면 동일한지 다른지 결과를 반환")
    @CsvSource(value = {"1,false", "2,false", "3, true"})
    void isFurthestDistanceTest(int furtherDistance, boolean expect) {
        //given

        //when
        boolean result = car.isFurthestDistance(furtherDistance);

        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("Winner에 이름을 등록하여 반환")
    void recognizeAsWinnerTest() {
        //given


        //when
        Winner winner = car.recognizeAsWinner();

        //then
        assertThat(winner).extracting("winner").isEqualTo("test");
    }

    @Test
    @DisplayName("차 이름과 이동거리를 계산하여 반환")
    void toStringTest() {
        //given

        //when
        String result = car.toString();

        //then
        assertThat(result).isEqualTo("test : ---\n");
    }
}
