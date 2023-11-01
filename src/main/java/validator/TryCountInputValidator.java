package validator;

public class TryCountInputValidator {
    public void vaildInputNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력할 수 있어요.");
            }
        }
    }

    public void vaildInputEmpty(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력할 수 없어요. 숫자를 입력해주세요.");
        }
    }
}
