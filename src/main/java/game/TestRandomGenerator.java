package game;

public class TestRandomGenerator implements RandomGenerator {
    private int number;

    public TestRandomGenerator(int number) {
        this.number = number;
    }

    @Override
    public int pickNumberInRange(int min, int max) {
        return number;
    }
}
