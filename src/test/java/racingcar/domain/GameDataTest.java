package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameDataTest {
    private GameData gameData;

    @BeforeEach
    void setUp() {
        gameData = new GameData();
    }

    @Test
    void 자동차_컬렉션_생성() {
        int carsNumber = 4;
        gameData.createCarList(4);
        List<Car> carList = gameData.getCarList();

        Assertions.assertThat(carList.size()).isEqualTo(4);
    }

    @Test
    void 자동차_이름_지정() {

        List<Car> carListTemp = new ArrayList<>();
        String[] carsName = {"pobi", "woni", "jun", "jason"};
        int carNumber = carsName.length;
        for (int i = 0; i < carNumber; i++) {
            carListTemp.add(new Car());
        }
        gameData.setCarsName(carsName, carListTemp);

        for (Car carTest : carListTemp) {
            String carName = carTest.getName();
            Assertions.assertThat(carsName).contains(carName);
        }


    }

    @Test
    void getRepetitionNumberInput() {
    }

    @Test
    void changeRepetitionNumberType() {
    }

    @Test
    void sortCarListByRank() {
    }

    @Test
    void setWinnerList() {
    }
}