package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.InputHandler;
import racingcar.model.Participants;
import racingcar.model.car.Car;
import racingcar.service.CarSaveService;

public class CarTest {

    @Test
    @DisplayName("이름은 대소문자 구분없이 1~5글자의 영문이다.")
    void 자동차_테스트(){
        Car.of(0,"j");
        Car.of(0,"jo");
        Car.of(0,"joh");
        Car.of(0,"john");
        Car.of(0,"joHnN");
    }
    @Test
    @DisplayName("공백, 띄어쓰기, 지정되지 않은범위의 이름은 예외가 발생한다.")
    void 자동차_테스트2(){
        Assertions.assertThatThrownBy(()->
                Car.of(0,"")).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                Car.of(0,"a b")).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                Car.of(0,"johnnn")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자저장소_테스트(){
        String input = "a,bcd,ef,gh,ijklm";
        String[] strings = InputHandler.StringToNameArray(input);
        Participants carList = CarSaveService.save(strings);

        Assertions.assertThat(carList.size()).isEqualTo(5);

        String name = carList.getCar(2).getName();
        Assertions.assertThat(name).isEqualTo("ef");

        Integer carId = carList.getCar(2).getCarId();
        Assertions.assertThat(carId).isEqualTo(2);
    }

    @Test
    @DisplayName("참가자는 2명 이상이어야 한다.")
    void 참가자저장소_테스트2(){
        Assertions.assertThatThrownBy(()->{
            String input = "a";
            String[] strings = InputHandler.StringToNameArray(input);
            Participants carList = CarSaveService.save(strings);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
