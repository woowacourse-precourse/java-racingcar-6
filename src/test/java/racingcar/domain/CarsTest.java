package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    List<CarName> carNameList;
    CarNames carNames;
    Cars cars;

    @BeforeEach
    void makeCarsObject() {
        carNameList = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
        carNames = new CarNames(carNameList);
        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("이동한 결과를 문자열로 반환")
    void getMoveResultTest() {
        //given
        cars.moveAllCar();

        //when
        String result = cars.getMoveResult();

        //then
        assertThat(result).contains("test1 : ", "test2 : ", "test3 : ");
    }





    /*@Test
    @DisplayName("***수정예정***")
    void findWinnerTest() {
        //given
        cars.moveAllCar();

        //when
        Winners winners = cars.findWinner();
        String winnerList = winners.makeWinnerList();

        //then
        assertThat(winnerList).contains("test");

    }*/

/*
    // Cars
    List<CarName> carNameList;
    CarNames carNames;
    List<Car> cars;

    @BeforeEach
    @DisplayName("***수정예정***Cars 분해")
    void makeCarsObject() {
        carNameList = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
        carNames = new CarNames(carNameList);
        cars = carNames.assignNamesToCars();
    }
    // Cars


    @Test
    @DisplayName("***수정예정***위의 Cars 분해해놓은 변수들로 메소드를 직접 재구성")
    void moveAllCarTest() {

        //여기서부터 moveAllCar
        for (Car car : cars) {
            //int randomNumber = RandomNumberGenerator.generateNumber(); <- 4 이상 전진이므로 randomNumber에 4 대입]
            int randomNumber = 4;
            car.move(randomNumber);

            //테스트코드
            Assertions.assertThat(car).extracting("position").isEqualTo(1);
        }
    }*/


}
