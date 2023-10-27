package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarTest {

    @DisplayName("레이싱 자동차를 생성하는 생성자 테스트")
    @Test
    void racingCarConstructorTest() {
        //given
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);
        //then
        assertThat(racingCar.getRacingCarName()).isEqualTo(carName);
    }

    @DisplayName("랜던한 숫자가 4이상 일때, 레이싱 자동차가 전진하는지에 대한 테스트")
    @Test
    void racingCarMoveTest() {
        //when
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);
        //given
        int randomNumber = 5;
        racingCar.isRacingCarMove(randomNumber);
        //then
        List<Boolean> racingCarMove = racingCar.getRacingCarMove();
        assertThat(racingCarMove.get(0)).isEqualTo(true);
    }

    @DisplayName("랜던한 숫자가 4이하 일때, 레이싱 자동차가 전진하지 않는지 대한 테스트")
    @Test
    void racingCarNotMoveTest() {
        //when
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);
        //given
        int randomNumber = 2;
        racingCar.isRacingCarMove(randomNumber);
        //then
        List<Boolean> racingCarMove = racingCar.getRacingCarMove();
        assertThat(racingCarMove.isEmpty()).isEqualTo(true);
    }

    @DisplayName("레이싱 자동차의 게임 결과를 string으로 반환해주는 테스트")
    @Test
    void racingCarGameResultTest() {
        //when
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);
        //given
        for (int randomNumber = 3; randomNumber < 8; randomNumber++) {
            racingCar.isRacingCarMove(randomNumber);
        }
        //then
        String gameResult = racingCar.makeGameResult();
        assertThat(gameResult).isEqualTo("----");
    }

    @DisplayName("레이싱 자동차의 게임 결과, 전진하지 못한 경우에 대한 테스트")
    @Test
    void racingCarGameNonMoveResultTest() {
        //when
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);
        //given
        for (int randomNumber = 0; randomNumber < 4; randomNumber++) {
            racingCar.isRacingCarMove(randomNumber);
        }
        //then
        String gameResult = racingCar.makeGameResult();
        assertThat(gameResult).isEqualTo("");
    }

    @DisplayName("레이싱 자동차의 toString 오버라이딩 메서드 test")
    @Test
    void toStringTest() {
        //when
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);
        //given
        for (int randomNumber = 3; randomNumber < 8; randomNumber++) {
            racingCar.isRacingCarMove(randomNumber);
        }
        //then
        String racingCartoString = "pobi : ----";
        assertThat(racingCar.toString()).isEqualTo(racingCartoString);
    }
}