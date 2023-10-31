package racingcar.Domain;

public class ProgressDto {
    String carName;
    String progress;

    public ProgressDto(String carName, String progress) {
        this.carName = carName;
        this.progress = progress;
    }

    public String getCarName() {
        return carName;
    }

    public String getProgress() {
        return progress;
    }
}
