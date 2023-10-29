package racingcar;

final class FakeRoulette implements Roulette {

    private int fixedNumber;

    FakeRoulette(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    void changeNumber(int number) {
        fixedNumber = number;
    }

    @Override
    public int spin() {
        return fixedNumber;
    }
}
