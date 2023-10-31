package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CarNames {

    private List<String> carNames;

    private static final String COMMA = ",";
    private static final String DOUBLE_COMMA = ",,";
    private static final String SPACE = " ";
    public CarNames(String input) {
        verifyInput(input);
        createCarNames(input);
    }

    private void createCarNames(String input) {
        carNames = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, COMMA);

        verifyInputToken(stringTokenizer);
    }

    private void verifyInputToken(StringTokenizer stringTokenizer) {
        while(stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();
            // 이름이 5자 초과일 떄
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            // 중복된 이름 있는지 확인
            if (carNames.contains(carName)) {
                throw new IllegalArgumentException();
            }

            carNames.add(carName);
        }
        // 입력받은 이름이 없을 경우
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyInput(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        // 입력이 없는 경우
        if (stringBuilder.isEmpty()) {
            throw new IllegalArgumentException();
        }
        // 문장 끝이 쉼표로 끝날때
        if (stringBuilder.substring(input.length()-1).equals(COMMA)) {
            throw new IllegalArgumentException();
        }
        // 쉼표가 연속 두 개 붙었을 때
        for (int i = 0; i < stringBuilder.length() - 2; i++) {
            verifyDoubleComma(stringBuilder, i);
        }
        // 문장 시작이 쉼표 일 때
        if (stringBuilder.substring(0, 1).equals(COMMA)) {
            throw new IllegalArgumentException();
        }
        // ,양옆 공백 있을 경우
        for (int i = 1; i < stringBuilder.length() - 1; i++) {
            verifySpaceNextToComma(stringBuilder, i);
        }
    }

    private void verifySpaceNextToComma(StringBuilder stringBuilder, int i) {
        if(stringBuilder.substring(i, i + 1).equals(COMMA)) {
            verifyIllegal(stringBuilder, i);
        }
    }

    private void verifyIllegal(StringBuilder stringBuilder, int i) {
        if (stringBuilder.substring(i - 1, i).equals(SPACE) || stringBuilder.substring(i +1, i +2).equals(SPACE)) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyDoubleComma(StringBuilder stringBuilder, int i) {
        if (stringBuilder.substring(i, i + 2) .equals(DOUBLE_COMMA)) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

}
