package racingcar.domain;

public class Output {
    public void printInput(String input) {
        System.out.println(input);
    }

    public void printResult(String carName, int forwardNumber) {
        System.out.println(carName+" "+": "+"-".repeat(forwardNumber));
    }
}
