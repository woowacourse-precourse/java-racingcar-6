package racingcar.game.car;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;

class CarFactoryTest {

    @Test
    void 이름으로_차량생성_테스트() {
        //if
        List<String> racingCarNameList = Arrays.asList("한놈", "두식이", "석삼", "너구리");
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();

        //when
        CarFactory carFactory = new CarFactory(inputGenerateManager);
        List<Car> cars = carFactory.createCars(racingCarNameList);
        //then
        Assertions.assertThat(cars).size().isEqualTo(racingCarNameList.size());
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("한놈");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("두식이");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("석삼");
        Assertions.assertThat(cars.get(3).getName()).isEqualTo("너구리");
    }
}