package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Iterator;

public class RacingCarView {

    public void displayCarNameSetupMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String getUserInput(){
        return readLine();
    }
    public void displayRoundCountSetupMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void displayRoundResults(Iterator<String> roundResultIterator){}

    public void displayWinnerList(Iterator<String> winnerListIterator){}

}
