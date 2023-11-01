package racingcar.model.result;

import java.util.stream.IntStream;

public record RoundResult(String name, Integer position) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        IntStream.range(0, position).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
