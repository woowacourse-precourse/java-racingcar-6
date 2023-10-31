package racingcar.game.car;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;

class CarFactoryTest {
    private final static List<String> NAME_LIST = Arrays.asList("한놈", "두식이", "석삼", "너구리");

    @Test
    void 이름으로_차량생성_테스트() {
        //if
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();
        CarFactory carFactory = new CarFactory(inputGenerateManager);

        //when
        List<Car> cars = carFactory.createCars(NAME_LIST);

        //then
        Assertions.assertThat(cars).size().isEqualTo(NAME_LIST.size());
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("한놈");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("두식이");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("석삼");
        Assertions.assertThat(cars.get(3).getName()).isEqualTo("너구리");
    }
}