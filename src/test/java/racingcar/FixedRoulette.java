package racingcar;

final class FixedRoulette implements Roulette {

    private int fixedNumber;

    FixedRoulette(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    void fixNumber(int number) {
        fixedNumber = number;
    }

    @Override
    public int spin() {
        return fixedNumber;
    }
}
