package racingcar;

public class Input {
    static Car makingLineup(String name) {
        String[] names = name.split(",");
        validateNames(names);
        return new Car(names);
    }
    static void validateNames(String[] names) {
        for (String name : names) {
            checkNameLengthLimit(name);
        }
    }
    static void checkNameLengthLimit(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("입력되는 이름은 5자 이하여야 합니다.");
        }
    }

    static int inputNumber(String number) throws IllegalArgumentException{
        try {
            int repeatNumber = Integer.parseInt(number);
            validateNumberAtLeast(repeatNumber);
            return repeatNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력해야 합니다.");
        }
    }
    static void validateNumberAtLeast(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력해야 합니다.");
        }
    }

}