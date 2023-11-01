package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.CarController;
import racingcar.model.Car;
import racingcar.model.Cars;

import racingcar.view.InputView;
import racingcar.view.OutputView;

class CarTest {
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
    public void 자동차_전진() {
        // given
        int random = 5;
        Car car = new Car("test");
        // when
        car.go(random);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 전진_실패() {
        // given
        int random = 3;
        Car car = new Car("test");
        // when
        car.go(random);
        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 결과_생성() {
        // given
        String names = "pobi,woni";
        InputView inputView = mock(InputView.class);
        OutputView outputView = new OutputView();
        CarController controller = new CarController(inputView, outputView);

        when(inputView.getPlayerNamesInput()).thenReturn(names);
        when(inputView.inputTryCount()).thenReturn("1");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // when
        controller.play();
        System.setOut(originalOut);

        // then
        String expectedOutput = "실행 결과\npobi : \nwoni : \n최종 우승자 : pobi, woni\n";
        Assertions.assertThat(outContent.toString()).isEqualToNormalizingWhitespace(expectedOutput);

    }

    @Test
    public void 생성_성공() {
        // given
        String names = "pobi,woni";

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    public void 중복_체크() {
        // given
        String names = "pobi,woni,woni";

        // when
        // then
        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }


}
