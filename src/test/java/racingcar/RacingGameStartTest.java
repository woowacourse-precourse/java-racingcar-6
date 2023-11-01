package racingcar;

import org.junit.jupiter.api.Test;
import pojo.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static racingcar.RacingGameStart.createRacingCar;
import static racingcar.RacingGameStart.printWinners;


class RacingGameStartTest {
    @Test
    void run() {

    }
    @Test
    public void createRacingCar_자동차_객체_초기화() {

        String testCarName = "Fast         ";

        RacingCar racingCar = createRacingCar(testCarName);

        assertNotNull(racingCar);
        assertEquals(racingCar.getName(), "Fast");
        assertEquals(0, racingCar.getDistance());
    }
    @Test
    void checkNameLength_자동차_이름_5자리_이상시_에러_처리() {
        String name ="f1o2u3r4";

        assertThatThrownBy(() -> {
            RacingGameStart.checkNameLength(name);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 5자 이하만 가능합니다");
    }

    @Test
    public void printWinners_우승자_이름_출력() {

        RacingCar car1 = new RacingCar("Car1", 7);
        RacingCar car2 = new RacingCar("Car2", 5);
        RacingCar car3 = new RacingCar("Car3", 7);
        RacingCar[] racingCars = {car1, car2, car3};

        PrintWinner printWinner = new PrintWinner(racingCars);


        assertThat(printWinner.winnerListPrint()).isEqualTo("최종 우승자 : Car1, Car3");
    }

}