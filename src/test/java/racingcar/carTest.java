package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.CarController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.car.CarHandler;
import racingcar.util.car.CarHandlerImpl;
import racingcar.view.OutputView;

class carTest {
    @Test
    public void 자동차_생성() {
        // given
        String name = "pobi";
        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456", " "})
    public void 자동차_생성_실패(String name) {
        // then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_가져오기() {
        // given
        String name = "pobi";
        Car car = new Car(name);

        // when
        String carName = car.getName();

        // then
        assertThat(carName).isEqualTo(name);
    }

    @Test
    public void 자동차_위치_가져오기() {
        // given
        String name = "pobi";
        Car car = new Car(name);

        // when
        int position = car.getPosition();

        // then
        assertThat(position).isEqualTo(0);
    }

    @Test
    public void 자동차_위치_변경() {
        // given
        String name = "pobi";
        Car car = new Car(name);

        // when
        car.setPosition(1);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 자동차_전진() {
        // given
        int random = 5;
        Car car = new Car("test");
        CarHandler carHandler = new CarHandlerImpl(car);

        // when
        carHandler.go(random);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 전진_실패() {
        // given
        int random = 3;
        Car car = new Car("test");
        CarHandler carHandler = new CarHandlerImpl(car);

        // when
        carHandler.go(random);
        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 자동차_전진_후_텍스트_출력() {
        // given
        int random = 5;
        Car car = new Car("test");
        CarHandler carHandler = new CarHandlerImpl(car);
        CarController carController = new CarController(car, carHandler);

        // when
        carController.moveCar(random);

        String output = OutputView.displayCarPosition(carController);
        System.out.println(output);  // This will print: "test : -"

        // then
        assertThat(output).isEqualTo("test : -");
    }
    @Test
    public void 생성_성공() {
        // given
        String[] names = {"pobi", "woni", "wonii"};

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }
    @Test
    public void 중복_체크() {
        // given
        String[] names = {"pobi", "woni", "woni"};

        // when
        // then
        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }

}
