package racingcar;

import domain.Car;
import domain.Cars;
import domain.Winners;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinnersTest {

    @Test
    void 전진도가_가장_큰_자동차를_단독_우승자로_판단하는_기능_테스트() {
        //given
        String userInput = "yoon,su";
        String[] carNames = userInput.split(",");
        Cars cars = new Cars(carNames);
        List<Car> getCars = cars.getCars();

        Car yoonCar = getCars.get(0);
        yoonCar.moveAhead();
        Car suCar = getCars.get(1);

        //when
        Winners winners = cars.generateWinners();

        //then
        Assertions.assertThat(winners.winners().size()).isEqualTo(1);
    }

    @Test
    void 전진도가_가장_큰_자동차를_공동_우승자로_판단하는_기능_테스트() {
        //given
        String userInput = "yoon,su";
        String[] carNames = userInput.split(",");
        Cars cars = new Cars(carNames);
        List<Car> getCars = cars.getCars();

        Car yoonCar = getCars.get(0);
        yoonCar.moveAhead();
        yoonCar.moveAhead();
        Car suCar = getCars.get(1);
        suCar.moveAhead();
        suCar.moveAhead();

        //when
        Winners winners = cars.generateWinners();

        //then
        Assertions.assertThat(winners.winners().size()).isEqualTo(2);
    }
}
