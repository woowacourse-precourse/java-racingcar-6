 package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarListTest {


    @Test
    @DisplayName("CarList에 Car 넣기 - 성공")
    public void add_car_to_carList_success() {
        //given
        Car car1 = new Car("Lee");
        Car car2 = new Car("K");
        Car car3 = new Car("H");
        List<Car> Cars = Arrays.asList(car1, car2, car3);

        //when
        CarList carList = new CarList();
        for (Car car : Cars) {
            carList.addCarList(car);
        }

        //then
        for(int i = 0; i < carList.getCarList().size(); i++)
            assertThat(carList.getCarList().get(i).getName()).isEqualTo(Cars.get(i).getName());

    }


    @Test
    @DisplayName("우승차 찾기 - 단독일 때")
    public void find_racingCar_winner_success() throws Exception{
        //given
        Car winner = new Car("winner");
        Car loser = new Car("loser");

        CarList carList = new CarList();

        //when
        winner.move();
        carList.addCarList(winner);
        carList.addCarList(loser);

        int winnerLocation = carList.getRacingCarWinnerLocation();
        List<String> racingCarWinnerName = carList.getRacingCarWinnerName(winnerLocation);

        //then
        assertThat(racingCarWinnerName.size()).isEqualTo(1);
        assertThat(racingCarWinnerName.get(0)).isEqualTo(winner.getName());

    }

    @Test
    @DisplayName("우승차 찾기 - 공동일 때")
    public void find_racingCar_joint_winner_success() throws Exception{
        //given
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");
        Car loser = new Car("loser");

        CarList carList = new CarList();

        //when
        winner1.move();
        winner2.move();
        carList.addCarList(winner1);
        carList.addCarList(winner2);
        carList.addCarList(loser);

        int winnerLocation = carList.getRacingCarWinnerLocation();
        List<String> racingCarWinnerName = carList.getRacingCarWinnerName(winnerLocation);

        //then
        assertThat(racingCarWinnerName.size()).isEqualTo(2);
        assertThat(racingCarWinnerName.get(0)).isEqualTo(winner1.getName());
        assertThat(racingCarWinnerName.get(1)).isEqualTo(winner2.getName());

    }
}