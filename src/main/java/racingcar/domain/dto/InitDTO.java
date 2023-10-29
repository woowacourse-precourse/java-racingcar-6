package racingcar.domain.dto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InitDTO {
    private final List<String> carNames;
    private final int rounds;
    private static final String NAME_SEPARATOR = ",";
    private static final int MAX_SIZE_NAME = 5;

    public InitDTO(String carNames, String rounds){
        this.carNames = toStringList(carNames);
        this.rounds = toInt(rounds);
    }

    private int toInt(String text) {
        validateNumericString(text);
        int rounds = Integer.parseInt(text);
        validateRounds(rounds);
        return rounds;
    }

    private void validateRounds(int rounds) {
        if(rounds <= 0) {
            throw new IllegalArgumentException("실행 횟수를 양수로 입력해 주세요.");
        }
    }

    private void validateNumericString(String text) {
        if(!Pattern.matches("[0-9]+", text)) {
            throw new IllegalArgumentException("숫자가 아닌 다른 문자를 입력하셨습니다. 실행 횟수를 양수로 입력해 주세요.");
        }

    }

    public List<String> toStringList(String text){
        List<String> carNames = Arrays.asList(text.split(NAME_SEPARATOR));
        validateNames(carNames);
        return carNames;
    }

    public void validateNames(List<String> carNames){
        carNames.forEach(name -> {
            if(name.length() > MAX_SIZE_NAME){
                throw new IllegalArgumentException("자동차의 이름은 5글자 이하 여야 합니다.");
            }
        });
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getRounds() {
        return rounds;
    }
}
