package racingcar.domain.system.manager.car.key;

import java.util.Objects;
import racingcar.domain.core.car.CarName;

/**
 * 입력 순으로 정렬하기 위해 추가한 임시 CarName 객체
 */
public class InputOrderCarName extends CarName {

    private final Long inputOrder;

    public InputOrderCarName(CarName name, Long inputOrder) {
        super(name.getName());
        this.inputOrder = inputOrder;
    }

    @Override
    public String getName() {
        return inputOrder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        InputOrderCarName that = (InputOrderCarName) o;
        return Objects.equals(inputOrder, that.inputOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inputOrder);
    }
}
