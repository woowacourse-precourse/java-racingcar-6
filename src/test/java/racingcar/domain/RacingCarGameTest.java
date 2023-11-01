package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.customCollection.CustomArrayList;

class RacingCarGameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    RacingCarGame rg = new RacingCarGame();
    CustomArrayList<Car> carList = new CustomArrayList<>();
    List<Car> winnerList = new ArrayList<>();

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

        rg.generateCarList(arrayOfCarName, carList);

        assertThat(carList.size()).isEqualTo(4);
        assertThat(carList.get(1).getName()).isEqualTo("red");
    }

    @Test
    @DisplayName("반복되는_경주의_출력값_확인")
    void test_repeatCarRace() {
        String carName1 = "black";
        String carName2 = "white";
        carList.add(new Car(carName1));
        carList.add(new Car(carName2));

        assertRandomNumberInRangeTest(
                () -> {
                    rg.repeatCarRace(carList, 3);
                    assertThat(output()).contains(
                            "black : -\nwhite : ",
                            "black : --\nwhite : ",
                            "black : --\nwhite : -");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("단독일등_승자이름_출력")
    void test_printOutWinner1() {
        String carName = "단독일등";
        winnerList.add(new Car(carName));

        rg.printOutWinner(winnerList);

        assertThat(output()).isEqualTo(carName);
    }

    @Test
    @DisplayName("복수일등_승자이름_출력")
    void test_printOutWinner2() {
        String carName1 = "black";
        String carName2 = "red";
        String carName3 = "white";
        winnerList.add(new Car(carName1));
        winnerList.add(new Car(carName2));
        winnerList.add(new Car(carName3));

        rg.printOutWinner(winnerList);

        assertThat(output()).contains(carName1, carName2, carName3);
        assertThat(output()).isEqualTo("black, red, white");
    }

    @Override
    protected void runMain() {

    }
}