package racingcar.dto;

import java.util.List;
import java.util.Objects;

public class ResultEachTry {
    private final int tryOrder;
    private final List<NameLocationPair> nameLocationPairs;

    public ResultEachTry(int tryNum, List<NameLocationPair> nameLocationPairs) {
        this.tryOrder = tryNum;
        this.nameLocationPairs = nameLocationPairs;
    }

    public int getTryOrder() {
        return tryOrder;
    }

    public List<NameLocationPair> getNameLocationPairs() {
        return nameLocationPairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultEachTry that = (ResultEachTry) o;
        return tryOrder == that.tryOrder && Objects.equals(nameLocationPairs, that.nameLocationPairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryOrder, nameLocationPairs);
    }
}
