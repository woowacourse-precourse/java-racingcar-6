package validator;

public class CarNameInputValidator {
    void vaildCarNameLength(String[] carNames) {
        for (String name: carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능해요.");
            }
        }
    }
}
