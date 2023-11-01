package racingcar;

public class ResultPrinter {
    public void printResult(String member, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "-";
        }
        System.out.println(member + " : " + result);
    }
}
