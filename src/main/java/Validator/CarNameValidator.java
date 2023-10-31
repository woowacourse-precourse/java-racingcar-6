package Validator;

public class CarNameValidator {
    private static CarNameValidator carNameValidator;

    private CarNameValidator() {

    }

    public static CarNameValidator getInstance() {
        if (CarNameValidator.carNameValidator == null) {
            return CarNameValidator.carNameValidator = new CarNameValidator();
        }
        return CarNameValidator.carNameValidator;
    }

    public void validateCarName(String carName) {
        StringValidator.getInstance().validatetNotBlankString(carName);

        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘을 수 없습니다.");
        }
    }


}
