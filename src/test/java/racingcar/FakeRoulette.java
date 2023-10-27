package racingcar;

final class FakeRoulette extends Roulette {

    private final int fixedNumber;

    FakeRoulette(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    int spin() {
        return fixedNumber;
    }
}
