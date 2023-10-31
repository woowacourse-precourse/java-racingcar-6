package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String FORWARD_SYMBOL = "-";
    private static final String GAME_RESULT = "실행결과";
    private static final String MVP = "최종 우승자 : ";
    private static final String Comma = " ,";

    public void printForward(String carName, int forward){
        String forwardSymbol = FORWARD_SYMBOL.repeat(forward);
        System.out.println(carName + " : " + forwardSymbol);
    }
    public void printResult(){
        System.out.println("");
        System.out.println(GAME_RESULT);
    }

    public void printMVP(List<String> mvpList) {
        System.out.println(MVP + String.join(Comma, mvpList));
    }
}
