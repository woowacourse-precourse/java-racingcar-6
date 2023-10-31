package racingcar.Entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class SnapshotTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @Test
    @DisplayName("스냅샷__정상출력")
    void printSnapshot_메서드_정상출력_테스트() {
        int tryCount = 3;
        List<Car> cars = List.of(
                Car.createCar("car1", 1),
                Car.createCar("car2", 0),
                Car.createCar("car3", 3)
        );
        Snapshot snapshot = new Snapshot(tryCount);
        snapshot.setSnapshot(3, cars);

        // 출력값 검증
        snapshot.printSnapshot(3);
        assertThat(outputMessage.toString())
                .isEqualTo("car1 : -\ncar2 : \ncar3 : ---\n\n");
    }

    @Test
    @DisplayName("스냅샷__인덱스_파라미터_예외")
    void printSnapshot_메서드_수행시_존재하지_않는_인덱스_파라미터_예외발생() {
        int tryCount = 1;
        Snapshot snapshot = new Snapshot(tryCount);

        assertThatThrownBy(() -> snapshot.printSnapshot(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("스냅샷__미존재_출력")
    void printSnapshot_메서드_수행시_인덱스범위_내에서_스냅샷_미존재() {
        int tryCount = 1;
        Snapshot snapshot = new Snapshot(tryCount);

        // 출력값 검증
        snapshot.printSnapshot(1);
        assertThat(outputMessage.toString())
                .isEqualTo("no snapshot\n");
    }

    @Test
    @DisplayName("스냅샷__우승자_결과")
    void printWinner_메서드의_우승자_결과_테스트() {
        Snapshot snapshot = new Snapshot(3);
        List<Car> cars = List.of(
                Car.createCar("car1", 5),
                Car.createCar("car2", 5),
                Car.createCar("car3", 2)
        );
        int raceNumber = 4;
        snapshot.setSnapshot(raceNumber, cars);

        // 출력값 검증
        snapshot.printWinner(raceNumber);
        assertThat(outputMessage.toString())
                .isEqualTo("최종 우승자 : car1, car2");
    }
}