package racingcar;

import org.junit.jupiter.api.Test;
import pojo.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static racingcar.RacingGameStart.*;


class RacingGameStartTest {

    @Test
    public void testCreateRacingCars_자동차_객체_리스트_생성() {

        String carNames = "우아한 , 테크,코스";

        RacingCar[] racingCars = createRacingCars(carNames);

        assertEquals(3, racingCars.length);
        assertEquals("우아한", racingCars[0].getName());
        assertEquals(0, racingCars[0].getDistance());
        assertEquals("테크", racingCars[1].getName());
        assertEquals(0, racingCars[1].getDistance());
        assertEquals("코스", racingCars[2].getName());
        assertEquals(0, racingCars[2].getDistance());
    }

    @Test
    public void testCreateRacingCar_자동차_객체_초기화() {

        String testCarName = "Fast         ";

        RacingCar racingCar = createRacingCar(testCarName);

        assertNotNull(racingCar);
        assertEquals(racingCar.getName(), "Fast");
        assertEquals(0, racingCar.getDistance());
    }

    @Test
    public void testPrintWinners_우승자_이름_출력() {

        RacingCar car1 = new RacingCar("우아한", 7);
        RacingCar car2 = new RacingCar("테크", 5);
        RacingCar car3 = new RacingCar("코스", 7);
        RacingCar[] racingCars = {car1, car2, car3};
        PrintWinner printWinner = new PrintWinner(racingCars);

        assertThat(printWinner.winnerListPrint()).isEqualTo("최종 우승자 : 우아한, 코스");
    }

    @Test
    void testCheckNameLength_자동차_이름_5자리_이상시_에러_처리() {

        String name = "f1o2u3r4";

        assertThatThrownBy(() -> {
            RacingGameStart.checkNameLength(name);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 5자 이하만 가능합니다");
    }


}