package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidatePlayerInput {
    public void validateContainSpace(String playerInput) {
        if (playerInput.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름 구분은 ','로 하셔야합니다");
        }
    }

    public void validateCarNameLength(String playerInput) {
        String[] splitsPlayerInput = playerInput.split(",");

        for (String carName : splitsPlayerInput) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름 길이는 5이하 입니다");
            }
        }
    }

    public void validatePlayerTryCountInput(String playerInput) {
        List<Character> inputStream = playerInput.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        inputStream.forEach(c -> {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해주시길 바랍니다");
            }
        });
    }

    public List<String> convertStringToListCarNames(String playerInput) {
        String [] splitsPlayerInput = playerInput.split(",");

        final List<String> convertedValues = Arrays.stream(splitsPlayerInput).toList();
        return convertedValues;
    }

}
