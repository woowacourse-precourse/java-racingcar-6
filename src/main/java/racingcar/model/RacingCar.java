package racingcar.model;


import java.util.Objects;
import racingcar.utils.validator.CarValidator;

public class RacingCar extends CarValidator implements Car {

    private final String name;

    private final Long progress;

    public RacingCar(final String name, final Long progress) {
        this.validate(name);

        this.name = name;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public Long getProgress() {
        return progress;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) && Objects.equals(progress, racingCar.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, progress);
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                ", progress=" + progress +
                '}';
    }
}
