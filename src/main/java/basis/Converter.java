package basis;

import java.util.LinkedHashMap;
import java.util.Map;
import validation.UserInputValidator;

public class Converter {
    public int wordToInt(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 것을 입력했습니다. 게임을 종료합니다.");
        }
    }

    public Map<String, String> splitAndAddToMap(String Name) { // ["k1",v1,v2]
        Map<String, String> hashMap = new LinkedHashMap<>();
        try {
            String[] parts = tokenizeByComma(Name);
            for (String part : parts) {
                if (part.isBlank()) {
                    throw new IllegalArgumentException("[ERROR] 이름이 존재하지 않습니다. 게임을 종료합니다.");
                }
                hashMap.put(part, "");
                UserInputValidator.checkNameLength(part);
            }
            return hashMap;
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다. 게임을 종료합니다.");
        }
    }

    private String[] tokenizeByComma(String entireString) {
        return entireString.split(",");
    }
}