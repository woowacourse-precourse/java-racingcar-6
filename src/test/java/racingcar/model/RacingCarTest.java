package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("레이싱 자동차 이름이 올바를 때 생성하는 생성자 테스트")
    @Test
    void racingCarConstructorTest() {
        //when
        String carName = "pobi";

        //given
        RacingCar racingCar = new RacingCar(carName);

        //then
        assertThat(racingCar.getRacingCarName()).isEqualTo(carName);
    }

    @DisplayName("레이싱 자동차 이름이 없을 경우의 테스트")
    @Test
    void containSpaceInCarNameTest() {
        //given
        String carName = "";

        //then
        assertThatThrownBy(() -> new RacingCar(carName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 자동차 이름이 없습니다");
    }


    @DisplayName("레이싱 자동차 이름이 영어로 구성되지 않았을 경우의 테스트")
    @Test
    void alphaCarNameTest() {
        //given
        String numberCarName = "pobi1";
        String koreanCarName = "pobiㄴ";
        String specialSignCarName = "pobi^";

        //then
        assertThatThrownBy(() -> new RacingCar(numberCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 자동차 이름은 영어만 허용됩니다");

        assertThatThrownBy(() -> new RacingCar(koreanCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 자동차 이름은 영어만 허용됩니다");

        assertThatThrownBy(() -> new RacingCar(specialSignCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 자동차 이름은 영어만 허용됩니다");
    }

    @DisplayName("랜던한 숫자가 4이상 일때, 레이싱 자동차가 전진하는지에 대한 테스트")
    @Test
    void racingCarMoveTest() {
        //when
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);

        //given
        int randomNumber = 5;
        racingCar.move(randomNumber);

        //then
        int racingCarMove = racingCar.getMoveCount();
        assertThat(racingCarMove).isEqualTo(1);
    }

    @DisplayName("랜던한 숫자가 4이하 일때, 레이싱 자동차가 전진하지 않는지 대한 테스트")
    @Test
    void racingCarNotMoveTest() {
        //when
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);

        //given
        int randomNumber = 2;
        racingCar.move(randomNumber);

        //then
        int racingCarMove = racingCar.getMoveCount();
        assertThat(racingCarMove).isEqualTo(0);
    }

}