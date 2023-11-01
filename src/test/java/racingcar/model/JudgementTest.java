package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgementTest {
    private Judgement judgement;
    private List<Car> carList;
    private List<Car> expectedWinnerList;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
        carList = new ArrayList<>();
        expectedWinnerList = new ArrayList<>();
        carList.add(new Car("자동차1"));
        carList.add(new Car("자동차2"));
        carList.add(new Car("자동차3"));
    }

    @Test
    void 우승자1() {
        carList.get(0).moveForward();
        expectedWinnerList.add(carList.get(0));

        assertThat(expectedWinnerList).isEqualTo(judgement.findWinner(carList));
    }

    @Test
    void 우승자2() {
        carList.get(0).moveForward();
        carList.get(1).moveForward();
        expectedWinnerList.add(carList.get(0));
        expectedWinnerList.add(carList.get(1));

        assertThat(expectedWinnerList).isEqualTo(judgement.findWinner(carList));
    }

    @Test
    void 우승자3() {
        assertThat(carList).isEqualTo(judgement.findWinner(carList));
    }
}