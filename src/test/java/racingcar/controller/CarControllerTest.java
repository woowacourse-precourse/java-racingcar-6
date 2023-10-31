package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarControllerTest {

    @Test
    public void split_메서드로_주어진_값을_구분() {
        String input = "car1,car2,car3";
        List<String> result = CarController.getCarNamesFromUser(input);

        assertThat(result).contains("car1", "car2", "car3");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "car1";
        List<String> result = CarController.getCarNamesFromUser(input);

        assertThat(result).contains("car1");
    }
}