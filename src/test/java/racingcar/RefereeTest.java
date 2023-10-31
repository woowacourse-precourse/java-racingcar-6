package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private final Referee referee = new Referee();
    private final List<Car> racingCars = new ArrayList<>();

    @BeforeEach
    void init() {
        Car car1 = new Car("car1");
        car1.plusDistance();
        racingCars.add(car1);

        Car car2 = new Car("car2");
        car2.plusDistance();
        car2.plusDistance();
        racingCars.add(car2);
    }

    @Test
    @DisplayName("모든 자동차의 이동 거리 저장")
    void 이동_거리_저장() {
        List<Integer> check = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(referee.saveAllDistances(racingCars)).isEqualTo(check);
    }

    @Test
    @DisplayName("저장된 이동 거리 중 최대 거리 찾기")
    void 최대_이동_거리() {
        List<Integer> distances = referee.saveAllDistances(racingCars);
        assertThat(referee.findMaxDistance(distances)).isEqualTo(2);
    }

    @Test
    @DisplayName("최대 거리로 우승자 찾기")
    void 우승자_찾기() {
        List<String> winnerCarNames = new ArrayList<>(List.of("car2"));
        assertThat(referee.findWinner(racingCars)).isEqualTo(winnerCarNames);
    }

    @Test
    @DisplayName("우승자 출력 확인")
    void 우승자_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<String> winnerCarNames = referee.findWinner(racingCars);
        referee.printWinner(winnerCarNames);
        assertThat(out.toString().trim()).isEqualTo("최종 우승자 : car2");
    }

    @Test
    @DisplayName("다중 우승자 출력 확인")
    void 다중_우승자_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        racingCars.get(0).plusDistance();
        List<String> winnerCarNames = referee.findWinner(racingCars);
        referee.printWinner(winnerCarNames);
        assertThat(out.toString().trim()).isEqualTo("최종 우승자 : car1, car2");
    }

    @Test
    @DisplayName("아무도 출발하지 않았을 때 우승자 출력 확인")
    void 우승자_없는_경우_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        racingCars.clear();
        Car car1 = new Car("car1");
        racingCars.add(car1);
        Car car2 = new Car("car2");
        racingCars.add(car2);

        List<String> winnerCarNames = referee.findWinner(racingCars);
        referee.printWinner(winnerCarNames);
        assertThat(out.toString().trim()).isEqualTo("아무도 출발하지 않았습니다.");
    }

}