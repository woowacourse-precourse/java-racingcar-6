package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingSystemTest {

    private RacingSystem racingSystem;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        racingSystem = new RacingSystem();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void makeCarsInstance_자동차의_이름과_리스트_크기_일치() {
        racingSystem.carNames = List.of("pobi", "woni", "jun");
        racingSystem.makeCarsInstance();

        assertThat(racingSystem.cars).hasSize(3);
    }

    @Test
    void printCars_문자열_출력() {
        racingSystem.carNames = List.of("pobi", "woni", "jun");
        racingSystem.makeCarsInstance();
        racingSystem.printCars();

        String output = outputStream.toString();
        assertThat(output).contains("pobi : ");
        assertThat(output).contains("woni : ");
        assertThat(output).contains("jun : ");
    }

    @Test
    void moveCars_이동_상태가_0과_1() {
        racingSystem.carNames = List.of("pobi", "woni", "jun");
        racingSystem.makeCarsInstance();
        racingSystem.moveCars();

        assertThat(racingSystem.cars).allMatch(car -> car.getMoveState() >= 0 && car.getMoveState() <= 1);
    }

    @Test
    void raceProgress_움직인_후_값_출력() {
        racingSystem.carNames = List.of("pobi", "woni", "jun");
        racingSystem.movement = 3;
        racingSystem.makeCarsInstance();

        for (Car car : racingSystem.cars) {
            car.moveState += 3;
        }

        racingSystem.raceProgress();

        String output = outputStream.toString();
        assertThat(output).contains("pobi : ---");
        assertThat(output).contains("woni : ---");
        assertThat(output).contains("jun : ---");
    }



    @Test
    void raceWinner_우승자_확인() {
        racingSystem.carNames = List.of("pobi", "woni", "jun");
        racingSystem.makeCarsInstance();

        racingSystem.cars.get(0).moveState += 3;
        racingSystem.cars.get(1).moveState += 1;
        racingSystem.cars.get(2).moveState += 1;

        racingSystem.raceWinner();

        String output = outputStream.toString();
        assertThat(output).contains("최종 우승자 : pobi");
    }

}
