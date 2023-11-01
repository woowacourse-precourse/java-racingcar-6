package racingcar.view;

import java.util.Arrays;
import java.util.List;

/**
 * 사용자 입력을 검증하는 클래스
 *
 * @author gemstoneyang
 */
public class Validator {
    /**
     * 사용자의 시도 입력값을 검사하는 메소드
     *
     * @param input 사용자가 입력한 시도 횟수
     */
    public static void validateTryCountInput(String input) {
        if (!input.matches("^\\d*$")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
        }
    }

    /**
     * 사용자의 이름 입력값을 검사하는 메소드
     * <p>
     * 알파벳 이외의 문자가 들어오는지, 공백이 아니고 5자 이하인지 확인
     *
     * @param input 사용자의 이름 입력값
     */
    public static void validateNameInput(String input) {
        checkInputCharacter(input);
        checkInputBlankName(input);
        checkEachNameLength(input);
        checkDuplicateNames(input);
    }

    private static void checkInputCharacter(String input) {
        if (!input.matches("^[a-zA-Z,]*$")) {
            throw new IllegalArgumentException("알파벳과 쉼표 외의 문자가 포함되어 있습니다.");
        }
    }

    private static void checkInputBlankName(String input) {
       long commaCount = countComma(input);
       long nameCount = Arrays.stream(input.split(",")).count();

       if (nameCount != commaCount + 1) {
           throw new IllegalArgumentException("이름을 입력해주세요.");
       }
    }

    private static long countComma(String str) {
        return str.chars()
                .filter(ch -> ch == ',')
                .count();
    }

    private static void checkEachNameLength(String input) {
        Arrays.stream(input.split(","))
                .forEach(Validator::validNameLength);
    }

    private static void validNameLength(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        if (input.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
        }
    }

    private static void checkDuplicateNames(String input) {
        List<String> nameList = Arrays.asList(input.split(","));
        long uniqueCount = nameList.stream().distinct().count();

        if (uniqueCount < nameList.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}
