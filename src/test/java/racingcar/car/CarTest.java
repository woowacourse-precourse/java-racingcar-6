package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.InputHandler;
import racingcar.model.Participants;
import racingcar.model.car.Car;
import racingcar.model.car.CarName;
import racingcar.service.CarSaveService;

public class CarTest {

    @Test
    void 자동차_테스트(){
        Car.of(0,"j");
        Car.of(0,"jo");
        Car.of(0,"joh");
        Car.of(0,"john");
        Car.of(0,"joHnN");
    }
    @Test
    void 자동차_테스트2(){
        Assertions.assertThatThrownBy(()->
                Car.of(0,"")).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                Car.of(0,"a b")).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                Car.of(0,"johnnn")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 저장소_테스트(){
        String input = "a,bcd,ef,gh,ijklm";
        String[] strings = InputHandler.StringToArray(input);
        Participants carList = CarSaveService.save(strings);

        Assertions.assertThat(carList.size()).isEqualTo(5);

        CarName carName = carList.get(2).getCarName();
        Assertions.assertThat(carName.name()).isEqualTo("ef");
    }

    @Test
    @DisplayName("참가자는 2명 이상이어야 한다.")
    void 저장소_테스트2(){
        Assertions.assertThatThrownBy(()->{
            String input = "a";
            String[] strings = InputHandler.StringToArray(input);
            Participants carList = CarSaveService.save(strings);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
