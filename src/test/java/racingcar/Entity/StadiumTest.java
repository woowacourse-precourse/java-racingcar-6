package racingcar.Entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StadiumTest {
    @Test
    @DisplayName("경주장__자동차_이름등록_예외")
    void saveInputCars_메서드_사용시_5자이상_이름입력_예외() {
        Stadium stadium = new Stadium();
        String input = "hundai";

        assertThatThrownBy(() -> stadium.saveRacers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주장__자동차_목록저장")
    void saveInputCars_메서드의_자동차_저장_기능_테스트() {
        Stadium stadium = new Stadium();
        String input = "yeny,kitty,pony";
        List<String> nameList = Arrays.asList(input.split(","));
        List<Car> cars = new ArrayList<>();
        for (String name : nameList) {
            cars.add(Car.create(name, 0));
        }

        stadium.saveRacers(input);

        List<Racer> savedCars = stadium.getRacers();
        assertThat(nameList.size()).isEqualTo(savedCars.size());
        for (int i = 0; i < savedCars.size(); i++) {
            assertThat(nameList.get(i)).isEqualTo(cars.get(i).getName());
        }
    }

    @Test
    @DisplayName("경주장__시도횟수_숫자_예외")
    void saveTryCount_메서드_파라미터_입력_예외() {
        Stadium stadium = new Stadium();
        List<String> inputList = List.of("-4", "안녕");

        for (String input : inputList) {
            assertThatThrownBy(() -> stadium.saveTryCount(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}