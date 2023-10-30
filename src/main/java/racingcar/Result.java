package racingcar;

public class Result {

    private String name;
    private int advance;

    public Result(String name, int advance) {
        this.name = name;
        this.advance = advance;
    }

    public String getName() {
        return name;
    }

    public int getAdvance() {
        return advance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(advance);
    }
}
