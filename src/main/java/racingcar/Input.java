package racingcar;

public class Input {

    static String[] setRacingCarLineup(String name) {
        isStringEmpty(name);
        hasOtherCharacters(name);
        String noBlankName = removeBlank(name);
        String[] names = noBlankName.split(",");
        validateName(names);
        return names;
    }

    private static void isStringEmpty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    private static String removeBlank(String s) { //이름 사이 공백 제거
        return s.replace(" ", "");
    }

    private static void hasOtherCharacters(String name) {
        String checkString = name.replace(",", "");
        if (checkString.isBlank()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    private static void validateName(String[] names) {
        for (String name : names) {
            checkNameLengthLimit(name);
        }
    }

    private static void checkNameLengthLimit(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("입력되는 이름은 5자 이하여야 합니다.");
        }
    }

    static int inputNumberOfGame(String number) {
        try {
            String noBlankNumber = removeBlank(number);
            int repeatNumber = Integer.parseInt(noBlankNumber);
            validateNumberAtLeast(repeatNumber);
            return repeatNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력해야 합니다.");
        }
    }

    private static void validateNumberAtLeast(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력해야 합니다.");
        }
    }

}