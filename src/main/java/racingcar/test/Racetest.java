package racingcar.test;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.view.PlayerinputView;
import racingcar.view.PlayeroutputView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Racetest {

    @Test
    void 자동차_이름_리스트로_반환() {
        String[] names = {"a", "bb", "nn"};
        List<Car> cars = PlayerinputView.saveNames(names);
        assertEquals(names.length, cars.size());
    }

    @Test
    void 자동차이름_입력_올바른_문자열_배열을_반환() {
        String input = "haha,good,sad";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] names = PlayerinputView.getNames();
        assertArrayEquals(new String[]{"haha", "good", "sad"}, names);
    }

    @Test
    void 시도횟수_올바른_값_반환() {
        String input = "3";
        int round = Integer.parseInt(input.substring(0, 1));
        assertEquals(3, round);
    }

    @Test
    public void 자동차_전진_출력_확인() {
        int position = 5;
        String message = PlayeroutputView.generateOnestepMessage(position);
        assertEquals("-----", message);
    }

    @Test
    public void 자동차_정지_출력_확인() {
        int position = 0;
        String message = PlayeroutputView.generateOnestepMessage(position);
        assertEquals("", message);
    }

    @Test
    public void 자동차_위치_작동_확인() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A", 0));
        cars.add(new Car("BC", 0));
        PlayeroutputView.updateRound(cars);
        for (Car car : cars) {
            assertTrue(car.getPosition() >= 0);
        }
    }

}


