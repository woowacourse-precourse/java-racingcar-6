package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.FindWinner;
import racingcar.util.MoveCar;

import java.util.List;

public class FindWinnerTest {

    @Test
    void 우승자_찾기_테스트(){

        // given
        List<Car> carList = setCarList();
        int tryCount = 5;
        movaCar(carList, tryCount);

        // when
        FindWinner.dataInit();
        setMaxPosition(carList);
        int maxPosition = FindWinner.getMaxPosition();
        setWinnerList(carList);
        List<Car> winnerList = FindWinner.getWinnerList();

        // then
        for (Car winnerCar : winnerList){
            Assertions.assertThat(maxPosition).isEqualTo(winnerCar.getPosition());
        }

    }

    private List<Car> setCarList() {

        List<Car> carList = List.of(
                Car.create("pobi"),
                Car.create("crong"),
                Car.create("honux")
        );

        return carList;
    }

    private void movaCar(List<Car> carList, int tryCount) {

        for (int i = 0; i < tryCount; i++) {
            moveCar(carList);
        }

    }


    private void moveCar(List<Car> carList) {

        for (Car car : carList) {
            MoveCar.moveCar(car);
        }

    }

    private void setMaxPosition(List<Car> carList) {

        for (Car car : carList){
            FindWinner.isMaxPosition(car.getPosition());
        }

    }

    private void setWinnerList(List<Car> carList) {

        for (Car car : carList){
            FindWinner.isWinner(car);
        }

    }

}
