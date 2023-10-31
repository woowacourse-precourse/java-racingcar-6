package racingcar.view;


public class InputValidation {

    public void validateCarNameSize(String carName, int size) {

        if (isBlank(carName)) {
            throw new IllegalArgumentException("Input invalid : input value is blank");
        }
        if (carName.length() > size) {
            throw new IllegalArgumentException("Input invalid : size of input value exceeds " + size);
        }

    }

    public void validateMovingCount(String MovingCount) {
        if (isBlank(MovingCount)) {
            throw new IllegalArgumentException("Input invalid : input value is blank");
        }
        validateStringIsNumeric(MovingCount);
    }


    private boolean isBlank(String str) {

        try {
            return str.isBlank();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Input invalid : input value is null");
        } catch (Exception e) {
            throw new IllegalArgumentException("Input invalid : " + e.getMessage());
        }
    }

    private void validateStringIsNumeric(String str) {

        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input String: " + e.getMessage());
        }

    }

}


