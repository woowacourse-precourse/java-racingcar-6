package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SnapshotTest {

    @Test
    void printSnapshot_메서드_정상출력_테스트() {
        int tryCount = 3;
        List<Car> cars = List.of(
                new Car("car1", 1),
                new Car("car2", 0),
                new Car("car3", 3)
        );
        Snapshot snapshot = new Snapshot(tryCount);
        snapshot.setSnapshot(3, cars);

        Assertions.assertThat(snapshot.printSnapshot(3))
                .isEqualTo("car1 : -\ncar2 : \ncar3 : ---\n\n");
    }

    @Test
    void printSnapshot_메서드_수행시_존재하지_않는_인덱스_파라미터_예외발생() {
        int tryCount = 1;
        Snapshot snapshot = new Snapshot(tryCount);
        Assertions.assertThatThrownBy(() -> snapshot.printSnapshot(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printSnapshot_메서드_수행시_인덱스범위_내에서_스냅샷_미존재() {
        int tryCount = 1;
        Snapshot snapshot = new Snapshot(tryCount);
        Assertions.assertThat(snapshot.printSnapshot(1))
                .isEqualTo("no snapshot\n");
    }
}