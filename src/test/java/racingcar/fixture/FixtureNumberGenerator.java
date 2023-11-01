package racingcar.fixture;

import racingcar.model.NumberGenerator;
import racingcar.model.RandomNumber;

/*
 * 테스트하기 위한 가짜객체로,
 * 생성자에 넣은 값으로 숫자를 생성한다.
 */
public class FixtureNumberGenerator implements NumberGenerator {
    private final int number;

    public FixtureNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public RandomNumber generate() {
        return new RandomNumber(number);
    }
}
