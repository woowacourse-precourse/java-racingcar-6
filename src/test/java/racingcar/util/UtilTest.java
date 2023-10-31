package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarModel;
import racingcar.util.Util;

class UtilTest {
    static Util util;
    List<CarModel> carModelList = new ArrayList<>();
    @BeforeAll
    static void beforeAll() {
        util = new Util();
    }

    @AfterEach
    void clearList() {
        carModelList.clear();
    }

    @Test
    void 랜덤_숫자_생성기능_테스트() {
        //given
        //when
        int randomNumber = util.generateRandomNumber();
        //then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 랜덤_숫자가_4_이상인지_판단기능_테스트() {
        //given
        int canForwardNumber = 5;
        //when
        boolean result = util.isUpperThanCanForwardNumber(canForwardNumber);
        //then
        assertThat(result).isTrue();
    }

    @Test
    void 랜덤_숫자가_4_미만인지_판단기능_테스트() {
        //given
        int canForwardNumber = 2;
        //when
        boolean result = util.isUpperThanCanForwardNumber(canForwardNumber);
        //then
        assertThat(result).isFalse();
    }

    @Test
    void 우승자_리스트_생성_테스트() {
        //given
        carModelList.add(new CarModel("car1", 3));
        carModelList.add(new CarModel("car2", 3));
        carModelList.add(new CarModel("car3", 3));
        //when
        String result = util.generateWinnerList(carModelList);
        //then
        assertThat(result).isEqualTo("car1, car2, car3");
    }

    @Test
    void calculateWinner_테스트() {
        //given
        carModelList.add(new CarModel("car1", 1));
        carModelList.add(new CarModel("car2", 3));
        carModelList.add(new CarModel("car3", 3));
        //when
        List<CarModel> winnerList = util.calculateWinner(carModelList);
        //then
        assertThat(winnerList).extracting("name").contains("car3", "car2");

    }
}