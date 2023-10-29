package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarGeneratorTest {
    private CarGenerator generator;
    private String names;
    List<String> nameList;

    @BeforeEach
    void setUp() {
        generator = new CarGenerator();
        names = "apple,pear,melon";
        nameList = generator.splitNames(names);
    }

    @Test
    void splitNames_메소드로_주어진_값을_구분() {
        assertThat(nameList).containsExactly("apple", "pear", "melon");
    }

    @Test
    void createCars_메소드로_자동차_리스트를_생성() {
        List<Car> carList = generator.createCars(nameList);

        assertThat(carList.size()).isEqualTo(nameList.size());

        assertThat(carList.get(0).getName()).isEqualTo(nameList.get(0));
        assertThat(carList.get(1).getName()).isEqualTo(nameList.get(1));
        assertThat(carList.get(2).getName()).isEqualTo(nameList.get(2));
    }
}