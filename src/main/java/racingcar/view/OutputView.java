package racingcar.view;

public class OutputView {
    private static final String FORWARD_SYMBOL = "-";

    public void printForward(String carName, int forward){
        String forwardSymbol = FORWARD_SYMBOL.repeat(forward);
        System.out.println(carName + " : " + forwardSymbol);
    }
}
