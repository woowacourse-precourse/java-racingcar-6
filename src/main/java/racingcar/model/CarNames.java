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

    private void verifyInput(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);

        if (stringBuilder.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (stringBuilder.substring(input.length()-1).equals(COMMA)) {
            throw new IllegalArgumentException();
        }

        if (stringBuilder.substring(0, 1).equals(COMMA)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < stringBuilder.length() - 2; i++) {
            verifyDoubleComma(stringBuilder, i);
        }

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

    private void createCarNames(String input) {
        carNames = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, COMMA);

        verifyInputToken(stringTokenizer);
    }

    private void verifyInputToken(StringTokenizer stringTokenizer) {
        while(stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();

            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            if (carNames.contains(carName)) {
                throw new IllegalArgumentException();
            }

            carNames.add(carName);
        }

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }


    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

}
