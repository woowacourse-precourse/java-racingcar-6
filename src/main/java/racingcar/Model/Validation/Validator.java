package racingcar.Model.Validation;

class Validator {
    public void isEmpty(String string, String message) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public void hasSpace(String string, String message) {
        if (string.contains(" ")) {
            throw new IllegalArgumentException(message);
        }
    }

}