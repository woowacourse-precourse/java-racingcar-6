package racingcar;

record Name(String name) {

    Name {
        if (name.length() < racingcar.Name.NameRule.MIN_LENGTH.length || name.length() > racingcar.Name.NameRule.MAX_LENGTH.length) {
            throw new IllegalArgumentException();
        }
    }

    enum NameRule {
        MIN_LENGTH(1),
        MAX_LENGTH(5),
        ;

        final int length;

        NameRule(int length) {
            this.length = length;
        }
    }
}
