package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

import java.util.*;

public class Application {
    private static String[] inputCar() {
        String carName = Console.readLine();
        String[] carNames = spilitNames(carName);

        validateIsEmpty(carNames);
        validateLastCharacter(carName);
        validateDuplicate(carNames);
        validateIsAlphabet(carNames);
        return carNames;
    }

    private static String[] spilitNames(String name) {
        return name.split(",");
    }

    private static void validateLastCharacter(String name) {
        if (name.charAt(name.length() - 1) == ',') {
            throw new IllegalArgumentException("마지막 문자에 ,를 제외해주세요");
        }
    }

    private static void validateDuplicate(String[] names) {
        List<String> nameList = Arrays.asList(names);

        if(nameList.size() != nameList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private static void validateNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 6) {
                throw new IllegalArgumentException("5글자 이하로 작성해주세요");
            }
        }
    }

    private static void validateIsEmpty(String[] names) {
        List<String> nameList = Arrays.asList(names);

        for (String n : nameList){
            if (n.isEmpty() || n.isBlank()) {
                throw new IllegalArgumentException("공백이나 \',\'를 연속으로 사용하거나 첫 번쨰 문자로 사용하지 마세요.");
            }
        }
    }

    private static void validateIsAlphabet(String[] names) {
        for (String name : names) {
            if (!name.chars().allMatch(Character::isLetter)) {
                throw new IllegalArgumentException("알파벳만 입력해주세요");
            }
        }
    }

    public static void main(String[] args) {
        inputCar();
    }
}
