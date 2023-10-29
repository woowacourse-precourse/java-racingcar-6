package racingcar.utils;

import static racingcar.model.constants.Rule.RANDOM_MAX_SIZE;
import static racingcar.model.constants.Rule.RANDOM_MIN_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneratorImp implements Generator {
    @Override
    public List<Integer> generateRandomNumbers(int size) {
        return Stream.generate(GeneratorImp::getRandomNumber)
                .limit(size)
                .collect(Collectors.toList());
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_SIZE.getValue(), RANDOM_MAX_SIZE.getValue());
    }
}
