package validator;

import Model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Validator {

    public static void checkValidateCarNames(String[] carNames) {
        checkStringLength(carNames);
        checkStringDuplicate(carNames);
        checkStringSize(carNames);
    }

    private static final int maxLength = 5;

    private static void checkStringLength(String[] carNames) {
        Stream<String> carNamesStream = Stream.of(carNames);
        carNamesStream.forEach(name -> {
            if (name.length() > maxLength) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        });
    }

    private static void checkStringDuplicate(String[] carNames) {
        Stream<String> carNamesStream = Stream.of(carNames);
        List<String> uniqueNames = new ArrayList<>();
        carNamesStream.forEach(name -> {
            if (uniqueNames.contains(name)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }
            uniqueNames.add(name);
        });
    }

    private static void checkStringSize(String[] carNames) {
        Stream<String> carNamesStream = Stream.of(carNames);
        long nameCount = carNamesStream.count();

        if (nameCount <= 1) {
            throw new IllegalArgumentException("적어도 2개 이상의 이름이 필요합니다.");
        }
    }

}
