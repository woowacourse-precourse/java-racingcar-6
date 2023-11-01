package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.GameService;

class GameTest {

    private final GameService gameService = new GameService();

    @Test
    @DisplayName("사용자 입력이 Car list로 잘 생성되는지 테스트")
    void create_car_test() {
        // given
        String carNames = "Car1, Car2, Car3";

        // when
        List<Car> carList = gameService.createCars(carNames);

        // then
        assertEquals(3, carList.size());
        assertEquals("Car1", carList.get(0).carName());
        assertEquals("Car2", carList.get(1).carName());
        assertEquals("Car3", carList.get(2).carName());
    }

    @Test
    @DisplayName("생성된 난수가 4이상일 경우 한 칸 전진하는지 테스트")
    void car_move_test() {
        // given
        List<Car> carList = List.of(new Car("Car1"));
        int beforeMoveCount = carList.get(0).moveCount();
        int RANDOM_NUMBER = 4;

        //when
        gameService.decideMovement(carList, RANDOM_NUMBER);
        int afterMoveCount = carList.get(0).moveCount();

        // then
        assertThat(afterMoveCount).isEqualTo(beforeMoveCount+1);
    }

    @Test
    @DisplayName("우승자가 제대로 출력되는지 테스트")
    void winner_print_test() {
        // given
        Car car1 = new Car("Car1");
        car1.setCount(5);
        Car car2 = new Car("Car2");
        car2.setCount(2);
        Car car3 = new Car("Car3");
        car3.setCount(5);
        List<Car> carList= Arrays.asList(car1, car2, car3);

        // when
        List<Car> winners = gameService.winRacing(carList);

        // then
        assertEquals(2, winners.size());
        assertTrue(winners.stream().anyMatch(car -> car.carName().equals("Car1")));
        assertTrue(winners.stream().anyMatch(car -> car.carName().equals("Car3")));
    }

}
