package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    String carName;

    public String carListInput(){
        String cmd = Console.readLine();
        //예외처리
        return cmd;
    }

    public int numOfRoundInput() {
        String numOfRound = Console.readLine();
        // 예외처리
        return Integer.parseInt(numOfRound);
    }
}
