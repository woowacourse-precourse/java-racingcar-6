package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.outputCar();
        String inputCar = InputView.InputCar();
        OutputView.outputTimes();
        String inputTimes = InputView.InputTimes();
        int times = HandleException.times(inputTimes);
        
    }
}
