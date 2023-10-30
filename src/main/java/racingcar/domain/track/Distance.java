package racingcar.domain.track;

public record Distance(StringBuilder distance) {
    public void move(String addDistance) {
        distance.append(addDistance);
    }

}
