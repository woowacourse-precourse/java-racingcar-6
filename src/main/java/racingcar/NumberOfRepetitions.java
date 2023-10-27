package racingcar;

public class NumberOfRepetitions {

    private int n;

    public NumberOfRepetitions(int n) {
        this.n = n;
    }

    public NumberOfRepetitions(String input) {
        this.n = Integer.parseInt(input);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != NumberOfRepetitions.class) {
            return false;
        }
        return ((NumberOfRepetitions) obj).n == this.n;
    }
}
