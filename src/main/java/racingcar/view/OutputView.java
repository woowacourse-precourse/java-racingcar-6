package racingcar.view;

public class OutputView {
    private static final String FORWARD_SYMBOL = "-";
    private static final String GAME_RESULT = "실행결과";

    public void printForward(String carName, int forward){
        String forwardSymbol = FORWARD_SYMBOL.repeat(forward);
        System.out.println(carName + " : " + forwardSymbol);
    }
    public void printResult(){
        System.out.println("");
        System.out.println(GAME_RESULT);
    }
}
