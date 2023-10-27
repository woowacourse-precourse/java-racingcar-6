package racingcar.collaborator.generic;

public record RacerProgress(String name, Integer mileage) {

    @Override
    public String toString() {
        return name + " : " + mileage + System.lineSeparator();
    }

}
