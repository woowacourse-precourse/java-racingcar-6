package racingcar.engine.manager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import racingcar.engine.domain.Car;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    public void setUp() {
        this.referee = new Referee();
    }

    @Test
    @DisplayName("한명의 우승자를 가려낸다.")
    void testDecideWinnerOne() {
        //given
        Car phobi = new Car("phobi");
        Car whyWhale = new Car("whyWhale");
        Car dhobi = new Car("dhobi");

        whyWhale.drive(1, 100);
        whyWhale.drive(1, 100);
        int expectedWinner = 1;

        List<Car> cars = List.of(phobi, whyWhale, dhobi);
        //when
        List<Car> winners = referee.decideWinners(cars);
        //then
        assertThat(winners.size()).isEqualTo(expectedWinner);
    }

    @Test
    @DisplayName("두명의 우승자를 가려낸다.")
    void testDecideWinnerTwo() {
        //given
        Car phobi = new Car("phobi");
        Car whyWhale = new Car("whyWhale");
        Car dhobi = new Car("dhobi");

        whyWhale.drive(1, 100);
        dhobi.drive(1, 100);
        int expectedWinner = 2;

        List<Car> cars = List.of(phobi, whyWhale, dhobi);
        //when
        List<Car> winners = referee.decideWinners(cars);
        //then
        assertThat(winners.size()).isEqualTo(expectedWinner);
    }

    @Test
    @DisplayName("세명의 우승자를 가려낸다.")
    void testDecideWinnerThree() {
        //given
        Car phobi = new Car("phobi");
        Car whyWhale = new Car("whyWhale");
        Car dhobi = new Car("dhobi");

        whyWhale.drive(1, 100);
        dhobi.drive(1, 100);
        phobi.drive(1, 100);
        int expectedWinner = 3;

        List<Car> cars = List.of(phobi, whyWhale, dhobi);
        //when
        List<Car> winners = referee.decideWinners(cars);
        //then
        assertThat(winners.size()).isEqualTo(expectedWinner);
    }

}