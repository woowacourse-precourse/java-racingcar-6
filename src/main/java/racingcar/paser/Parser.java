package racingcar.paser;

import java.util.List;

public interface Parser<T, J> {
    public List<T> parsing(J target);
}
