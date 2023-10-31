package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberUtilImp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {


    @Test
    @DisplayName("Cars의 동차 저장 리스트 필드가 같은지 테스트")
    void getCars() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        List<Car> carList = Arrays.asList(new Car(movingStrategy, "pobi"),
                new Car(movingStrategy, "crong"),
                new Car(movingStrategy, "horan"));
        List<Car> expected = carList;

        // when
        Cars cars = new Cars(carList);
        List<Car> result = cars.getCars();
        

        // then
        assertArrayEquals(expected, result);
    }



    @Test
    @DisplayName("자동차가 모두 전진하는 경우")
    void raceAllCars_전진() {
        // given
        MovingStrategy moveStrategy = new MovingStrategy((start, end)->4); // isCarMove() 항상 true 반환, 즉 항상 전진
        List<Car> carList = Arrays.asList(new Car(moveStrategy, "pobi"),
                                    new Car(moveStrategy, "crong"),
                                    new Car(moveStrategy, "nimo"));
        Cars cars = new Cars(carList);

        // when
        cars.raceAllCars();
        List<Car> result = cars.getCars();

        // then
        assertThat(result.stream()
                .allMatch(car -> car.getPosition() == 1)).isTrue();

    }

    @Test
    @DisplayName("자동차가 모두 멈추는 경우")
    void raceAllCars_멈춤() {
        // given
        MovingStrategy stopStrategy = new MovingStrategy((start, end)->3); // isCarMove() 항상 true 반환, 즉 항상 전진
        List<Car> carList = Arrays.asList(new Car(stopStrategy, "pobi"),
                new Car(stopStrategy, "crong"),
                new Car(stopStrategy, "nimo"));
        Cars cars = new Cars(carList);

        // when
        cars.raceAllCars();
        List<Car> result = cars.getCars();

        // then
        assertThat(result.stream()
                .allMatch(car -> car.getPosition() == 0)).isTrue();

    }


    @Test
    @DisplayName("우승자를 찾아내는 기능 테스트")
    void findWinner() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        List<Car> carList = Arrays.asList(new Car(movingStrategy, "pobi"),
                new Car(movingStrategy, "crong"),
                new Car(movingStrategy, "nimo"));
        Cars cars = new Cars(carList);

        // 경주 세번 돌리기
        for (int i=0; i<3; i++) {
            cars.raceAllCars();
        }
        List<Car> updatedCarList = cars.getCars();

        // 우승자 위치 찾아내기
        int winnerPosition = updatedCarList.stream()
                                .max(Car::compareTo)
                                .get()
                                .getPosition();

        // 우승자 찾기
        List<Car> expected = carList.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());

        // when
        List<Car> result = cars.findWinner(); // findWinner() 메서드로 우승자 찾기

        // then

        assertEquals(expected, result);
    }

    private void assertArrayEquals(List<Car> expected, List<Car> result) {
    }

}