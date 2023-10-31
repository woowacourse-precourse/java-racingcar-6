package racingcar.model.car;


import java.util.Objects;
import racingcar.utils.validator.CarValidator;
import racingcar.utils.validator.Validator;

public class RacingCar implements Car {

    public static final int INIT_PROGRESS = 0;

    private final String name;

    private Integer progress;

    public RacingCar(final String name) {
        this(name, INIT_PROGRESS);
    }

    public RacingCar(final String name, final Integer progress) {
        this(name, progress, new CarValidator());
    }

    public RacingCar(final String name, final Integer progress, final Validator<String> validator) {
        validator.validate(name);
        this.name = name;
        this.progress = progress;
    }

    @Override
    public void move(final boolean isMove){
        if (isMove){
            this.progress += 1;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getProgress() {
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
