package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.CarInfo;

public class CarInfoTest {

    @Test
    void setCarNameTest_자동차_이름_쉼표로_스플릿_후_저장() {
        CarInfo carinfo = new CarInfo();
        String input = "pobi,hoon,joji";

        carinfo.setCarName(input);
        assertThat(carinfo.getCarName()).containsExactly("pobi","hoon","joji");
    }

    @Test
    void initCarStatusTest_자동차갯수만큼_상태가_0으로_초기화() {
        CarInfo carinfo = new CarInfo();
        String input = "pobi,hoon,joji";
        carinfo.setCarName(input);

        carinfo.initCarStatus();
        assertThat(carinfo.getCarStatus()).containsExactly(0,0,0);
    }

    @Test
    void getCarNameTest_carName_리턴() {
        CarInfo carinfo = new CarInfo();
        String input = "pobi,hoon";
        carinfo.setCarName(input);

        assertThat(carinfo.getCarName()).containsExactly("pobi","hoon");
    }

    @Test
    void getCarStatusTest_carStatus_리턴() {
        CarInfo carinfo = new CarInfo();
        String input = "pobi,hoon,joji";
        carinfo.setCarName(input);
        carinfo.initCarStatus();

        assertThat(carinfo.getCarStatus()).containsExactly(0,0,0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void isMoveTest_랜덤숫자가_4이상일경우_true_리턴(int input) {
        CarInfo carinfo = new CarInfo();
        boolean result = carinfo.isMove(input);

        assertThat(true).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void isMoveTest_랜덤숫자가_4미만일경우_false_리턴(int input) {
        CarInfo carinfo = new CarInfo();
        boolean result = carinfo.isMove(input);

        assertThat(false).isEqualTo(result);
    }

    @Test
    void updateCarStatusTest_isMove가_참일_경우_catStatus_index_위치에_1더하기() {
        CarInfo carinfo = new CarInfo();
        String input = "pobi,hoon,joji";
        carinfo.setCarName(input);
        carinfo.initCarStatus();

        carinfo.updateCarStatus(true, 1);
        assertThat(carinfo.getCarStatus()).containsExactly(0,1,0);
    }

    @Test
    void getMaxMoveTest_carStatus의_최대값_리턴() {
        CarInfo carinfo = new CarInfo();
        String input = "pobi,hoon,joji";
        carinfo.setCarName(input);
        carinfo.initCarStatus();
        carinfo.updateCarStatus(true, 1);

        assertThat(carinfo.getMaxMove()).isEqualTo(1);
    }

    @Test
    void getWinnerName_우승자_이름_리스트_리턴() {
        CarInfo carinfo = new CarInfo();
        String input = "pobi,hoon,joji";
        carinfo.setCarName(input);
        carinfo.initCarStatus();
        carinfo.updateCarStatus(true, 1);
        carinfo.updateCarStatus(true, 2);

        assertThat(carinfo.getWinnerName())
                .containsExactly("hoon","joji");
    }


}
