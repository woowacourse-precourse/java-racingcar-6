package racingcar;

enum Rule {
    GO(4),
    STOP(3),

    FROM(0),
    TO(9),
    ;

    final int value;

    Rule(int value) {
        this.value = value;
    }
}
