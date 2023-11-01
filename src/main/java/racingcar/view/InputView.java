package racingcar.view;

public interface InputView {
    default int readInt() {
        String intNumber = readLine();
        return Integer.parseInt(intNumber);
    }
    String readLine();
}
