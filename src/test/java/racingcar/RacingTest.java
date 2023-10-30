package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {
    @DisplayName("우승자 이름 구하기- 우승자가 한명인 경우")
    @Test
    void determineWinner(){
        //given
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("one", 1);
        Car car2 = new Car("two", 2);
        Car car3 = new Car("three", 3);

        carList.addAll(List.of(car1, car2, car3));

        Racing racing = new Racing(carList);

        //when
        List<String> winner = racing.determineWinner();

        //then
        Assertions.assertThat(winner).hasSize(1)
                .contains("three");
    }

    @DisplayName("우승자 이름 구하기- 우승자가 여러명인 경우")
    @Test
    void determineJointWinner(){
        //given
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("one", 1);
        Car car2 = new Car("two", 3);
        Car car3 = new Car("three", 3);

        carList.addAll(List.of(car1, car2, car3));

        Racing racing = new Racing(carList);

        //when
        List<String> winner = racing.determineWinner();

        //then
        Assertions.assertThat(winner).hasSize(2)
                .containsExactly("two", "three");
    }

}