package racingcar.domain;

public class ResultPrinter {
    public void printResult(String carName, int moves) {
        StringBuilder result = new StringBuilder(carName + " :");

        for (int i=0; i<moves; i++) {
            result.append("-");
        }

        System.out.println(result.toString());
    }
}
