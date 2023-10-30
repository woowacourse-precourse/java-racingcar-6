package racingcar.ui;

public class OutputView {

    public void print(Output output) {
        System.out.println(output.getComment());
    }

    public void printRoundResult(String name, Integer distance) {
        System.out.println(name + Output.SEPARATOR + distance);
    }

}
