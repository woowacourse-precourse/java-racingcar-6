package racingcar;

final class FakeRoulette implements Roulette {

    private final int fixedNumber;

    FakeRoulette(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int spin() {
        return fixedNumber;
    }
}
