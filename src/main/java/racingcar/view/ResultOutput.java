package racingcar.view;

import java.util.Arrays;

public class ResultOutput {

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacing(String[] names, Integer[] positions) {
        String[] positionResult = convertPositionResult(positions);

        for (int i=0; i < names.length; i++) {
            System.out.printf("%s : %s%n", names[i], positionResult[i]);
        }
    }

    private String[] convertPositionResult(Integer[] positions) {
        return Arrays.stream(positions)
                .map("-"::repeat)
                .toArray(String[]::new);
    }
}
