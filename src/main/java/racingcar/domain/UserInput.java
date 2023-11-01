package racingcar.domain;

import java.util.HashSet;

public class UserInput {
    private String nameOfCars;
    private String attemptsNumber;
    private String[] carArray;
    private HashSet<String> carHashSet = new HashSet<>();

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public UserInput(String nameOfCars) {
        this.nameOfCars = nameOfCars;
    }

    public String[] getCarArray() {
        return carArray;
    }

    public void setAttemptsNumber(String attemptsNumber) {
        this.attemptsNumber = attemptsNumber;
    }

    public void checkNameOfCarsValidity() {
        if (isStringEmpty(nameOfCars)) {
            throw new IllegalArgumentException("Input value cannot be blank.");
        }

        if (!isContainComma(nameOfCars)) {
            throw new IllegalArgumentException(
                    "There must be two or more cars, and each car must be separated by a comma.");
        }

        for (int i = 0; i < carArray.length; i++) {
            String name = carArray[i];

            checkEachCharacter(name);

            transferTohashSetFrom(carArray);
            if (containsDuplicates()) {
                throw new IllegalArgumentException("Car names cannot be duplicated.");
            }
        }
    }

    private void checkEachCharacter(String name) {
        if (isStringEmpty(name)) {
            throw new IllegalArgumentException("None of the names can be blank.");
        }

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("The length of the name must be 5 or less.");
        }

        for (int c = 0; c < name.length(); c++) {
            if (isAlphabet(name.charAt(c)) || isNumber(name.charAt(c)) || isHyphenSign(name.charAt(c))) {
                continue;
            }

            throw new IllegalArgumentException(
                    "Only English letters, numbers, and '-' symbol are allowed in the name.");
        }
    }

    private boolean isStringEmpty(String string) {
        return string == null || string.isBlank();
    }

    private boolean isContainComma(String input) {
        carArray = input.split(",", -1);

        if (carArray.length == 1) {
            return false;
        }

        return true;
    }

    private boolean isAlphabet(char c) {
        if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) {
            return true;
        }

        return false;
    }

    private boolean isNumber(char c) {
        if (48 <= c && c <= 57) {
            return true;
        }

        return false;
    }

    private boolean isHyphenSign(char c) {
        if (c == 45) {
            return true;
        }

        return false;
    }

    public void checkAttempsNumberValidity() {
        if (isStringEmpty(attemptsNumber)) {
            throw new IllegalArgumentException("Input value cannot be blank");
        }

        if (!isOnlyNumbers(attemptsNumber)) {
            throw new IllegalArgumentException(
                    "Non-numeric values cannot be included, and therefore, negative numbers and decimals are also not allowed.");
        }

        if (isZero(attemptsNumber)) {
            throw new IllegalArgumentException("It cannot be 0.");
        }

        if (attemptsNumber.length() >= 2) {
            if (isHighestDigitZero(attemptsNumber)) {
                throw new IllegalArgumentException("The number in the highest digit cannot be 0.");
            }
        }
    }

    private boolean isOnlyNumbers(String string) {
        return string.matches("\\d*");
    }

    private boolean isZero(String string) {
        return string.equals("0");
    }

    private boolean isHighestDigitZero(String string) {
        return string.charAt(0) == '0';
    }

    private void transferTohashSetFrom(String[] carArray) {
        for (int i = 0; i < carArray.length; i++) {
            carHashSet.add(carArray[i]);
        }
    }

    private boolean containsDuplicates() {
        return carArray.length != carHashSet.size();
    }
}
