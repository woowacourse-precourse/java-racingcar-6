package racingcar.global.utils.generator;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

    List<List<Integer>> generate(Integer numberOfGames, Integer nameCount);

}