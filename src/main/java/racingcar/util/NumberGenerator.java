package racingcar.util;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

    List<Integer> generate(int size);
}
