package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {
    @Test
    void 생성한_랜덤값을_검증() {
        //given (주어진 값)
        int numOfCars = 5;
        NumberGenerator numberGenerator = new NumberGenerator(numOfCars);

        //when (기능 작동)
        List<Integer> carRandomNumbers = numberGenerator.getRandomNumbers();

        //then (기능 작동 후 검증)
        assertThat(carRandomNumbers).hasSize(numOfCars);    //랜덤값 개수를 검증
        assertThat(carRandomNumbers).allMatch(num -> num >=0 && num<=9);    //랜덤값이 0에서 9까지 검증
    }

}