package racingcar.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.Entity.Car;
import racingcar.constant.CarStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationTest {
    private static Calculation calculation;

    @BeforeAll()
    static void Calculation_객체_생성() {
        calculation = new Calculation();
    }

    @Test
    void 랜덤숫자에_따른_이동여부_1이면_중지() {
        CarStatus result = calculation.judgeCarMoveOrStop(1);
        assertThat(result).isEqualTo(CarStatus.STOP);
    }
    @Test
    void 랜덤숫자에_따른_이동여부_3이면_중지() {
        CarStatus result = calculation.judgeCarMoveOrStop(3);
        assertThat(result).isEqualTo(CarStatus.STOP);
    }
    @Test
    void 랜덤숫자에_따른_이동여부_4이면_이동() {
        CarStatus result = calculation.judgeCarMoveOrStop(4);
        assertThat(result).isEqualTo(CarStatus.MOVE);
    }
    @Test
    void 랜덤숫자에_따른_이동여부_5이면_이동() {
        CarStatus result = calculation.judgeCarMoveOrStop(5);
        assertThat(result).isEqualTo(CarStatus.MOVE);
    }
    @Test
    void 랜덤숫자에_따른_이동여부_9이면_이동() {
        CarStatus result = calculation.judgeCarMoveOrStop(9);
        assertThat(result).isEqualTo(CarStatus.MOVE);
    }

    @Test
    void 우승자_판단_입력_하나인데_0번이동_한명우승() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("one", new StringBuilder(),0));
        List<Car> result = calculation.judgeWhoIsWinner(testCars);

        assertThat(result).containsAll(testCars);
    }
    @Test
    void 우승자_판단_입력_전부_공동우승() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("one", new StringBuilder(), 3));
        testCars.add(new Car("two", new StringBuilder(),3));
        testCars.add(new Car("three", new StringBuilder(),3));

        List<Car> result = calculation.judgeWhoIsWinner(testCars);

        assertThat(result).containsAll(testCars);
    }
    @Test
    void 우승자_판단_입력_전부_0번이동이면_공동우승() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("one", new StringBuilder(), 0));
        testCars.add(new Car("two", new StringBuilder(), 0));
        testCars.add(new Car("three", new StringBuilder(), 0));
        List<Car> result = calculation.judgeWhoIsWinner(testCars);

        assertThat(result).containsAll(testCars);
    }
    @Test
    void 우승자_판단_입력_여러명_우승() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("one", new StringBuilder(), 1));
        testCars.add(new Car("two", new StringBuilder(), 3));
        testCars.add(new Car("three", new StringBuilder(), 3));

        List<Car> answerCars = new ArrayList<>();
        testCars.add(new Car("two", new StringBuilder(), 3));
        testCars.add(new Car("three", new StringBuilder(), 3));

        List<Car> result = calculation.judgeWhoIsWinner(testCars);

        assertThat(result).containsAll(answerCars);
    }

}