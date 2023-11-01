package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameServiceTest {

    RacingGameService racingGameService = new RacingGameService();


    @Test
    void makeCarList_메서드로_CarList_반환() {
        //given
        List<String> cars = Arrays.asList("car1", "car2", "car3");

        //when
        CarList carList = racingGameService.makeCarList(cars);

        //then
        assertThat(cars.size()).isEqualTo(carList.getCarList().size());
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i)).isEqualTo(carList.getCarList().get(i).getCarName());
        }
    }

    @Test
    void splitStringToList_메서드로_구분자를_기준으로_문자열을_리스트로_split() {
        //given
        String input = "abc,def,gh";

        //when
        List<String> result = racingGameService.splitStringToList(input);

        //then
        List<String> expected = List.of("abc", "def", "gh");
        assertThat(result).isEqualTo(expected);

    }
}