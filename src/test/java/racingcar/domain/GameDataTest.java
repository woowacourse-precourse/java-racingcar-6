package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GameDataTest {
    private GameData gameData;

    @BeforeEach
    void setUp() {
        gameData = new GameData();
    }

    @Test
    void 자동차_컬렉션_생성() {
        int carsNumber = 4;
        gameData.createCarList(carsNumber);
        List<Car> carList = gameData.getCarList();

        Assertions.assertThat(carList.size()).isEqualTo(4);
    }

    @Test
    void 자동차_이름_지정() {

        List<Car> carList = new ArrayList<>();
        String[] carsName = {"pobi", "woni", "jun", "jason"};
        int carNumber = carsName.length;
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car());
        }
        gameData.setCarsName(carsName, carList);

        for (Car carTest : carList) {
            String carName = carTest.getName();
            Assertions.assertThat(carsName).contains(carName);
        }


    }

    /*@Test
    void changeRepetitionNumberType() {

        String repetitionNumberInputTest = "123";
        gameData.changeRepetitionNumberType(repetitionNumberInputTest);
        Integer repetitionNumber = gameData.getRepetitionNumber();
        Assertions.assertThat(repetitionNumber).isIn(Number);
    }*/

    @Test
    void 자동차_전진횟수에_따라_내림차순_정렬() {
        List<Car> carList = new ArrayList<>();
        List<String> carNameList = new ArrayList<>();

        int carNumber = 5;
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car());
            Car car = carList.get(i);
            int ascii_a = 97;
            char nameTemp = (char)(ascii_a + i);
            car.setName(String.valueOf(nameTemp));
            car.setSuccessMoveForwardCount(30 + i);

        }

        gameData.sortCarListByRank(carList);
        for (int i = 0; i < carNumber; i++) {
            String carName = carList.get(i).getName();
            carNameList.add(carName);
        }

        Assertions.assertThat(carNameList).isEqualTo(Arrays.asList("e", "d", "c", "b", "a"));

    }

    @Test
    void 최종_우승자_추리기() {

        final int WINNER_MOVE_COUNT = 10;
        final int NORMAL_MOVE_COUNT = 4;

        Car car1 = new Car();
        car1.setName("car1");
        car1.setSuccessMoveForwardCount(WINNER_MOVE_COUNT);

        Car car2 = new Car();
        car2.setName("car2");
        car2.setSuccessMoveForwardCount(NORMAL_MOVE_COUNT);

        Car car3 = new Car();
        car3.setName("car3");
        car3.setSuccessMoveForwardCount(WINNER_MOVE_COUNT);

        Car car4 = new Car();
        car4.setName("car4");
        car4.setSuccessMoveForwardCount(NORMAL_MOVE_COUNT);

        List<String> winnerList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        gameData.pickWinners(winnerList, carList);

        Assertions.assertThat(winnerList).isEqualTo(Arrays.asList("car1", "car3"));


    }
}