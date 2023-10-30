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
    @DisplayName("중복된 이름이 입력된 경우 예외 발생")
    void 예외_처리_테스트_1() {
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        List<String> names = Arrays.asList("pobi", "pobi", "crong", "horan");

        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Cars(names, movingStrategy);
                });
    }

    @Test
    @DisplayName("Cars의 동차 저장 리스트 필드가 같은지 테스트")
    void getCars() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        List<String> names = Arrays.asList("pobi", "crong", "horan");
        List<Car> expected = Arrays.asList(new Car(movingStrategy, "pobi"),
                new Car(movingStrategy, "crong"),
                new Car(movingStrategy, "horan"));

        // when
        Cars cars = new Cars(names, movingStrategy);
        List<Car> result = cars.getCars();
        

        // then
        assertArrayEquals(expected, result);
    }



    @Test
    @DisplayName("자동차가 모두 전진하는 경우")
    void raceAllCars_전진() {
        // given
        MovingStrategy moveStrategy = new MovingStrategy((start, end)->4); // isCarMove() 항상 true 반환, 즉 항상 전진
        List<String> names = Arrays.asList("pobi", "crong", "horan");
        Cars cars = new Cars(names, moveStrategy);

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
        MovingStrategy stopStrategy = new MovingStrategy((start, end)->3); // isCarMove() 항상 false 반환, 즉 항상 멈춤
        List<String> names = Arrays.asList("pobi", "crong", "horan");
        Cars cars = new Cars(names, stopStrategy);

        // when
        cars.raceAllCars();
        List<Car> result = cars.getCars();

        // then
        assertThat(result.stream()
                .allMatch(car -> car.getPosition() == 0)).isTrue();

    }

    @Test
    @DisplayName("우승자의 위치 정보 찾아내는 기능 테스트")
    void findWinnerPosition() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        List<String> names = Arrays.asList("pobi", "crong", "horan");
        Cars cars = new Cars(names, movingStrategy);

        // 경주 세번 돌리기
        for (int i=0; i<3; i++) {
            cars.raceAllCars();
        }
        List<Car> carList = cars.getCars();

        // 우승자 위치 찾아내기
        int expected = carList.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();

        // when
        int result = cars.findWinnerPosition(); // findWinnerPosition() 메서드로 우승자 위치 찾기

        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("우승자를 찾아내는 기능 테스트")
    void findWinner() {
        // given
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberUtilImp());
        List<String> names = Arrays.asList("pobi", "crong", "horan");
        Cars cars = new Cars(names, movingStrategy);

        // 경주 세번 돌리기
        for (int i=0; i<3; i++) {
            cars.raceAllCars();
        }
        List<Car> carList = cars.getCars();

        // 우승자 위치 찾아내기
        int winnerPosition = carList.stream()
                                .max(Car::compareTo)
                                .get()
                                .getPosition();

        // 우승자 찾기
        List<Car> expected = carList.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());

        // when

        List<Car> result = cars.findWinner(winnerPosition); // findWinner() 메서드로 우승자 찾기

        // then

        assertEquals(expected, result);
    }

    private void assertArrayEquals(List<Car> expected, List<Car> result) {
    }

}