package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidatePlayerInput {
    private String[] splitsPlayerInput;

    public void convertStringToArray(final String playerInput) {
        this.splitsPlayerInput = playerInput.split(",", -1);
    }

    public void validateContainSpace(String playerInput) {
        if (playerInput.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름 구분은 ','로 하셔야합니다");
        }
    }

    public void validateNotContainCarName() {
        for (String carName : splitsPlayerInput) {
            if (carName.equals("")) {
                throw new IllegalArgumentException("레이싱 자동차 이름이 없습니다");
            }
        }
    }

    public void validateAlphaCarName() {
        for (String carName : this.splitsPlayerInput) {
            if (!Pattern.matches("^[a-zA-Z]*$", carName)) {
                throw new IllegalArgumentException("레이싱 자동차 이름은 영어만 허용됩니다");
            }
        }
    }

    public void validateCarNameLength() {
        for (String carName : this.splitsPlayerInput) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름 길이는 5이하 입니다");
            }
        }
    }

    public void validateDuplicateCarNames() {
        Set<String> dulplicateSet = Arrays.stream(this.splitsPlayerInput).collect(Collectors.toSet());

        if (dulplicateSet.size() != this.splitsPlayerInput.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다");
        }
    }

    public void validatePlayerTryCountInput(String playerInput) {
        List<Character> inputStream = playerInput.chars().mapToObj(c -> (char) c).toList();

        inputStream.forEach(c -> {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해주시길 바랍니다");
            }
        });
    }

    public List<String> convertStringToListCarNames() {
        final List<String> convertedValues = Arrays.stream(this.splitsPlayerInput).toList();

        return convertedValues;
    }
}
