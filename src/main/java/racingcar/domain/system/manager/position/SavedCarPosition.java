package racingcar.domain.system.manager.position;

import java.util.Objects;
import racingcar.domain.system.manager.car.SavedCar;

public class SavedCarPosition {

    private final SavedCar savedCar;
    private final Long position;

    public SavedCarPosition(SavedCar savedCar, Long position) {
        this.savedCar = savedCar;
        this.position = position;
    }

    public SavedCar getSavedCar() {
        return savedCar;
    }

    public Long getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SavedCarPosition that = (SavedCarPosition) o;
        return Objects.equals(savedCar, that.savedCar) && Objects.equals(position,
            that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(savedCar, position);
    }
}
