package racingcar.view;

public class OutputView {
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printCarResult(String carName, String carResult) {
        System.out.print(carName + " : " + carResult + "\n");
    }
}
