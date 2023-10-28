package racingcar.ui.output;

public class OutputProcessor {
    public void printInput(String input) {
        System.out.println(input);
    }

    public void printResult(String carName, int forwardNumber) {
        System.out.println(carName+" "+": "+"-".repeat(forwardNumber));
    }

    public void printStartMessage() {

    }
}
