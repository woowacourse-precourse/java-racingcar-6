package racingcar.domain;

public class OutputFinalWinner {
    private final static String runMessage = "최종우승자 : ";

    public void print(StringBuilder sb) {
        StringBuilder result = new StringBuilder();
        result.append(runMessage);
        result.append(sb);
        System.out.println(result);
    }

}
