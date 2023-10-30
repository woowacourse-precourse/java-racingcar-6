package racingcar.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingBoard;
import racingcar.service.Judgement;

class JudgementImplTest {

    Judgement judgement;
    RacingBoard racingBoard;

    @BeforeEach
    public void beforeEach() {
        judgement = new JudgementImpl();
        racingBoard = new RacingBoard();
    }

    @Test
    void isGameSet() {
        //given
        int count = 0;
        boolean result;
        //when
        result = judgement.isGameSet(count);
        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void judgeWinner() {
        //given
        ArrayList<String> resultArrayList;
        ArrayList<String> compapreArrayList = new ArrayList<>(Arrays.asList("car1", "car2", "car4"));
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 2);
        Car car4 = new Car("car4", 3);
        racingBoard.join(car1);
        racingBoard.join(car2);
        racingBoard.join(car3);
        racingBoard.join(car4);
        //when
        resultArrayList = judgement.judgeWinner(racingBoard);
        //then
        Assertions.assertThat(resultArrayList).isEqualTo(compapreArrayList);
    }
}