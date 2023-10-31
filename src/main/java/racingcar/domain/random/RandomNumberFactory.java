package racingcar.domain.random;

public class RandomNumberFactory {

    private final RandomService randomService;

    public RandomNumberFactory(RandomService randomService) {
        this.randomService = randomService;
    }

    public int create(int startInclusive, int endInclusive) {
        return randomService.pickNumberInRange(startInclusive, endInclusive);
    }
}
