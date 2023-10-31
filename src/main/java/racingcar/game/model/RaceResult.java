package racingcar.game.model;

public class RaceResult {
    private StringBuilder stringBuilder;

    public RaceResult() {
        stringBuilder = new StringBuilder();
    }

    protected void append(String name, int moveCount) {
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        for (int i = 0; i < moveCount; i++) {
            stringBuilder.append("-");
        }
        stringBuilder.append("\n");
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
