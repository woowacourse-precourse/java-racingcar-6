package racingcar;

public class ErrorCheckingSystem {

    public boolean errorSystem(String[] insertedNameList) {
        try {
            nameErrorChecking(insertedNameList);
            for (String name : insertedNameList) {
                stringCheck(name);
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void nameErrorChecking(String[] insertedNameList) {
        for (String carName : insertedNameList) {
            if (nameSizeChecking(carName)) {
                throw new IllegalArgumentException("5글자 이상 입니다");
            }
        }
    }

    public boolean nameSizeChecking(String insertedName) {
        return insertedName.length() > 5;
    }

    public int numberCheck(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("번호를 입력 해주세요", e);
        }
    }

    public static void stringCheck(String input) {
        if (!input.matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException("invalid characters");
        }
    }
}
