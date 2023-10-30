package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Verify {
    public void checkDuplicateCarName(String[] duplicatedStrings) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(duplicatedStrings));
        if (carNameSet.size() != duplicatedStrings.length) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public void checkEmptyOrOnlySpaceCarName(String[] containsEmptyStrings){
        for (String carName : containsEmptyStrings) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("이름은 공백이 아니거나 반드시 존재해야 합니다.");
            }
        }
    }
    
    public void checkCorrectLengthCarName(String[] outOfRangeStrings){
        for (String carName : outOfRangeStrings) {
            if (carName.length() > Config.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 네글자 이하이어야 합니다.");
            }
        }
    }
}
