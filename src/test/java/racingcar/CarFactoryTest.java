package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {

    @Test
    void 이름을_받아서_리스트로_반환() {
        String names = "chan,geon";
        List<Car> cars = CarFactory.createCarsFromInput(names);
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getName()).isEqualTo("chan");
        assertThat(cars.get(1).getName()).isEqualTo("geon");
    }

    @Test
    void 이름을_받아서_쉼표로_나누고_배열로_반환() {
        String names = "chan,geon";
        String[] nameArr = CarFactory.splitNames(names);
        assertThat(nameArr.length).isEqualTo(2);
        assertThat(nameArr[0]).isEqualTo("chan");
        assertThat(nameArr[1]).isEqualTo("geon");
    }

    @Test
    void 아룸울_받아서_콤마로_나눌떄_공백_제거() {
        String names = " chan , geon ";
        String[] nameArr = CarFactory.splitNames(names);
        assertThat(nameArr.length).isEqualTo(2);
        assertThat(nameArr[0]).isEqualTo("chan");
        assertThat(nameArr[1]).isEqualTo("geon");
    }

    @Test
    void 배열에_중복된_이름에_대한_예외_처리() {
        String[] nameArr = new String[]{"chan", "chan"};
        assertThatThrownBy(() -> CarFactory.validateUniqueNames(nameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 있습니다.");
    }

    @Test
    void 배열을_자동차_리스트로_반환() {
        String[] nameArr = new String[]{"chan", "geon"};
        List<Car> cars = CarFactory.createCars(nameArr);
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getName()).isEqualTo("chan");
        assertThat(cars.get(1).getName()).isEqualTo("geon");
    }

    @Test
    void 배열을_자동차_리스트로_반환할떄_배열의_이름의_길이가_5글자를_넘으면_예외_처리() {
        String[] nameArr = new String[]{"change"};
        assertThatThrownBy(() -> CarFactory.createCars(nameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 이름의_길이가_5글자를_넘으면_예외_처리() {
        String name = "change";
        assertThatThrownBy(() -> CarFactory.validateNameLength(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }
}