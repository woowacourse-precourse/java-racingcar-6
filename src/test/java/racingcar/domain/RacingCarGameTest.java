package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.customCollection.CustomArrayList;

class RacingCarGameTest {

    RacingCarGame rg = new RacingCarGame();

    @Test
    @DisplayName("자동차_이름_쪼개기_공백삭제")
    void test_splitNamesOfCars() {
        String namesOfCars = "1, 2, 3 ,  4, 창과 방패";
        String[] result = rg.splitNamesOfCars(namesOfCars);
        assertThat(result).containsExactly("1", "2", "3", "4", "창과 방패");
    }

    @Test
    @DisplayName("각각의_이름으로_자동차_객체_생성")
    void test_generateCarList() {
        String[] arrayOfCarName = {"blue", "red", "green", "white"};
        CustomArrayList<Car> carList = new CustomArrayList<>();

        rg.generateCarList(arrayOfCarName, carList);

        assertThat(carList.size()).isEqualTo(4);
        assertThat(carList.get(1).getName()).isEqualTo("red");
    }

}