package racingcar.model;

import java.util.ArrayList;
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
}
