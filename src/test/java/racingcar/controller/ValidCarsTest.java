package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import racingcar.AppConfig;
import racingcar.model.Car;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidCarsTest {

    AppConfig appConfig = new AppConfig();
    ValidCars validCars = appConfig.validCars();

    @Test
    void 올바른_여러_자동차_이름_입력() {

        String s = "pobi,woni,jun";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        List<Car> cars = validCars.getValidCars();
        List<String> carNames = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getName());
        }

        Assertions.assertThat(carNames).containsExactly("pobi", "woni", "jun");

        Console.close();
    }

    @Test
    void 올바른_하나의_자동차_이름_입력() {

        String s = "pobi";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        List<Car> cars = validCars.getValidCars();
        List<String> carNames = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getName());
        }

        Assertions.assertThat(carNames).containsExactly("pobi");

        Console.close();
    }

    @Test
    void 올바르지않은_여러개의_자동차_이름_입력() {

        String s = "pobi,chaerin";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> validCars.getValidCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름의 길이가 5보다 깁니다");

        Console.close();
    }

    @Test
    void 올바르지않은_하나의_자동차_이름_입력() {

        String s = "chaerin";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> validCars.getValidCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름의 길이가 5보다 깁니다");

        Console.close();
    }


}
