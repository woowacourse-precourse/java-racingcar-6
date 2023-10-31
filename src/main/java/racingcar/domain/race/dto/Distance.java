package racingcar.domain.race.dto;

public record Distance(StringBuilder value) {
    public void move(String addDistance) {
        value.append(addDistance);
    }

    public int getLength() {
        return value.length();
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
