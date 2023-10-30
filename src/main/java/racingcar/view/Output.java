package racingcar.view;

public class Output {

    private static Output output = new Output();

    private Output() {
    }

    public static Output getOutput() {
        return output;
    }

    public void printMessage(String message) {
        System.out.print(message);
    }
}
