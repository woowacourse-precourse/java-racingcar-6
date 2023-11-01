package selftest;

import camp.nextstep.edu.missionutils.Console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class SelfTest {

    private Controller controller;

    @BeforeEach
    void initController() {
        this.controller = new Controller();
    }

    @Test
    void 이름을_입력_받아_구분자_기준으로_구분() {

        String input = "aa,aaa,aaaa";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] result = controller.nameInput();

        assertThat(result).contains("aa","aaa","aaaa");
    }

    @Test
    void 이동거리_수정() throws NoSuchFieldException, IllegalAccessException {
        Car car = new Car("aaa");

        Field canGo = Car.class.getDeclaredField("canGo");
        canGo.setAccessible(true);
        canGo.set(car, true);

        car.updateDistance();

        assertThat(car.getDistance()).isEqualTo("-");
    }

    @Test
    void 최종_우승자_계산() throws NoSuchFieldException, IllegalAccessException {
        Car carA = new Car("aaa");
        Car carB = new Car("bbb");
        Car carC = new Car("ccc");

        Field distance = Car.class.getDeclaredField("distance");
        distance.setAccessible(true);

        distance.set(carA, "---");
        distance.set(carB, "----");
        distance.set(carC, "----");

        Field racingCars = Controller.class.getDeclaredField("racingCars");
        racingCars.setAccessible(true);

        ArrayList<Car> testCars = new ArrayList<>();
        testCars.add(carA);
        testCars.add(carB);
        testCars.add(carC);

        racingCars.set(controller, testCars);

        assertThat(controller.getWinners()).isEqualTo("bbb, ccc");
    }
}
