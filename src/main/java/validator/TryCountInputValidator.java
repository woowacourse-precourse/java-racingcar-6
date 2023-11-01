package validator;

public class TryCountInputValidator {
    public void vaildInputNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력할 수 있어요.");
            }
        }
    }
}
