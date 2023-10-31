package racingcar.Entity;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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

        assertThat(snapshot.printSnapshot(3))
                .isEqualTo("car1 : -\ncar2 : \ncar3 : ---\n\n");
    }

    @Test
    void printSnapshot_메서드_수행시_존재하지_않는_인덱스_파라미터_예외발생() {
        int tryCount = 1;
        Snapshot snapshot = new Snapshot(tryCount);
        assertThatThrownBy(() -> snapshot.printSnapshot(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printSnapshot_메서드_수행시_인덱스범위_내에서_스냅샷_미존재() {
        int tryCount = 1;
        Snapshot snapshot = new Snapshot(tryCount);
        assertThat(snapshot.printSnapshot(1))
                .isEqualTo("no snapshot\n");
    }

    @Test
    void printWinner_메서드의_우승자_결과_테스트() {
        Snapshot snapshot = new Snapshot(3);
        List<Car> cars = List.of(
                new Car("car1", 5),
                new Car("car2", 5),
                new Car("car3", 2)
        );
        int raceNumber = 4;
        snapshot.setSnapshot(raceNumber, cars);

        assertThat(snapshot.printWinner(raceNumber))
                .isEqualTo("최종 우승자 : car1, car2");
    }
}