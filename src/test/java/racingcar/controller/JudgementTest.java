package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {
    private Judgement judgement;
    private int highScore;
    private List<Car> cars;
    List<Integer> updatedNumbers;
    List<String> winnerList;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
    }

    @Test
    void 부스트_결과가_0또는_4이상으로_구성되어있는지() {
        List<Integer> carRandomNumbers = Stream.generate(() -> Randoms.pickNumberInRange(0, 9))
                .limit(5)
                .collect(Collectors.toList());

        updatedNumbers = judgement.isNumberMoreThan4(carRandomNumbers);

        for (Integer number : updatedNumbers) {
            assertThat(number).isIn(0, 4, 5, 6, 7, 8, 9);   //0 or 4이상만 존재.
        }
    }

    @Test
    void winnerList_알맞게_추출하는지() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.moveForward(5);
        woni.moveForward(3);
        jun.moveForward(6);

        List<Car> cars = Arrays.asList(pobi, woni, jun);
        List<Car> sortedCars;


        sortedCars = cars.stream()
                .sorted((car1, car2) -> Integer.compare(car2.getCarBoost(), car1.getCarBoost())) // GameController의 내림차순으로 Car 객체정렬
                .collect(Collectors.toList());

        winnerList = judgement.determineWinner(sortedCars);

        assertThat(winnerList).containsExactlyInAnyOrder(jun.getCarName(), pobi.getCarName());
    }
}