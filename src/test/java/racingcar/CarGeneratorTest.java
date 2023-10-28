package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarGeneratorTest {
    @Test
    void splitNames_메소드로_주어진_값을_구분() {
        CarGenerator generator = new CarGenerator();
        String names = "apple,pear,melon";
        List<String> nameList = generator.splitNames(names);

        assertThat(nameList).containsExactly("apple", "pear", "melon");
    }

    @Test
    void createCars_메소드로_자동차_리스트를_생성() {
        CarGenerator generator = new CarGenerator();
        String names = "apple,pear,melon";
        List<String> nameList = generator.splitNames(names);
        List<Car> carList = generator.createCars(nameList);

        assertThat(carList.size()).isEqualTo(nameList.size());

        assertThat(carList.get(0).getName()).isEqualTo(nameList.get(0));
        assertThat(carList.get(1).getName()).isEqualTo(nameList.get(1));
        assertThat(carList.get(2).getName()).isEqualTo(nameList.get(2));
    }
}