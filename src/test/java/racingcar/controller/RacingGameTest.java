package racingcar.controller;


import racingcar.model.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {


    @Test
    void 문자열에_쉼표가_포함된_자동차_생성() {
        String input = "car1,car2,car3";
        List<Car> cars = new RacingGame().createCars(input);
        ArrayList<String> list = new ArrayList<>();
        for (Car name : cars){
            list.add(name.getName());
        }
        assertThat(list).contains("car1", "car2", "car3");
    }


}
