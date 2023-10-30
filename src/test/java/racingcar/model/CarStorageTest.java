package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarStorageTest {

    @Test
    @DisplayName("HashSet 테스트")
    void hashSet_중복테스트() {
        List<Car> storage = new ArrayList<>();
        storage.add(new Car("pobi"));
        storage.add(new Car("pobi"));

        Set<Car> carSet = new HashSet<>(storage);

        Assertions.assertThat(carSet.size()).isEqualTo(storage.size() - 1);
    }

    @Test
    @DisplayName("CarStorage 이름 중복 테스트")
    void carStorage_중복테스트() {
        List<Car> storage = new ArrayList<>();
        storage.add(new Car("pobi"));
        storage.add(new Car("pobi"));

        Assertions.assertThatThrownBy(() -> new CarStorage(storage))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("자동차 이름 유효성 검사1")
    void carStorage_형식테스트1() {
        String input = "pobi,woni, ";

        List<Car> storage = new ArrayList<>();

        String[] carNames = input.split(",");

        Arrays.stream(carNames)
                .map(Car::new)
                .forEach(storage::add);

        Assertions.assertThatThrownBy(() -> new CarStorage(storage))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 유효성 검사2")
    void carStorage_형식테스트2() {
        String input = ", ";

        List<Car> storage = new ArrayList<>();

        String[] carNames = input.split(",");

        Arrays.stream(carNames)
                .map(Car::new)
                .forEach(storage::add);

        Assertions.assertThatThrownBy(() -> new CarStorage(storage))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 유효성 검사3")
    void carStorage_형식테스트3() {
        String input = "";

        List<Car> storage = new ArrayList<>();

        String[] carNames = input.split(",");

        Arrays.stream(carNames)
                .map(Car::new)
                .forEach(storage::add);

        Assertions.assertThatThrownBy(() -> new CarStorage(storage))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 유효성 검사4")
    void carStorage_형식테스트4() {
        String input = "pobiiii,woni";

        List<Car> storage = new ArrayList<>();

        String[] carNames = input.split(",");

        Arrays.stream(carNames)
                .map(Car::new)
                .forEach(storage::add);

        Assertions.assertThatThrownBy(() -> new CarStorage(storage))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
