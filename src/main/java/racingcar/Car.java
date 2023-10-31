package racingcar;

public class Car {
    String forwardDash = "";
    String name;

    public Car(String name) {
        checkInputValue(name);
        this.name = name;
    }
    public void checkInputValue(String input) {
        input = input.trim();
        if (isEmptyName(input)
                || !isCheckLength(input)
                || isNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEmptyName(String input) {
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isCheckLength(String input){
        if (input.length() > 5) {
            return false;
        }
        return true;
    }

    public static boolean isNumber(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
