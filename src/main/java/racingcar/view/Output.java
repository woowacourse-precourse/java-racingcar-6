package racingcar.view;

public class Output {
    public void RunResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public void printEnter() {
        System.out.print("\n");
    }
}
