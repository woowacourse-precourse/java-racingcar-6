package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StadiumTest {

    @Test
    void saveInputCars_메서드_사용시_5자이상_이름입력_예외() {
        Stadium stadium = new Stadium();
        String input = "hundai";

        Assertions.assertThatThrownBy(() -> stadium.saveInputCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void saveInputCars_메서드의_자동차_저장_기능_테스트() {
        Stadium stadium = new Stadium();
        String input = "yeny,kitty,pony";
        List<String> nameList = Arrays.asList(input.split(","));
        List<Car> cars = new ArrayList<>();
        for(String name : nameList){
            cars.add(new Car(name, 0));
        }

        stadium.saveInputCars(input);

        List<Car> savedCars = stadium.getCars();
        Assertions.assertThat(nameList.size()).isEqualTo(savedCars.size());
        for (int i=0; i<savedCars.size(); i++) {
            Assertions.assertThat(nameList.get(i)).isEqualTo(cars.get(i).getName());
        }
    }

    @Test
    void saveTryCount_메서드_파라미터_입력_예외(){
        Stadium stadium = new Stadium();
        List<String> inputList = List.of("-4", "안녕");

        for (String input : inputList) {
            Assertions.assertThatThrownBy(() -> stadium.saveTryCount(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}