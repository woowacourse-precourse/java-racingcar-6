package validator;

import java.util.HashSet;
import java.util.Set;

public class CarNameInputValidator {
    public void vaildCarNameLength(String[] carNames) {
        for (String name: carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능해요.");
            }
        }
    }

    public void vaildCarNameDuplication(String[] carNames) {
        Set<String> nameSet = new HashSet<>();
        for (String name: carNames) {
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복이 되면 안돼요.");
            }
            nameSet.add(name);
        }
    }
}
