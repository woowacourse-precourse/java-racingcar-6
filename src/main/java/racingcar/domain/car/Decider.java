package racingcar.domain.car;

public class Decider {
    private final Rule rule;
    private final Generator generator;

    private final int min;
    private final int max;

    private Decider(Rule rule, Generator generator) {
        this.rule = rule;
        this.generator = generator;
        min = rule.getMin();
        max = rule.getMax();
    }

    public static Decider of(Rule rule, Generator generator) {
        return new Decider(rule, generator);
    }

    public boolean isSucceed() {
        int randomNumber = generator.generate(min, max);
        return rule.isSucceed(randomNumber);
    }
}
