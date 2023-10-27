package racingcar.dto;

public record CarStatusDto(String name, int position) {

    @Override
    public String toString() {
        return "CarStatusDto{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
