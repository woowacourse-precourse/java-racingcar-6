package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<String> cars;
    private int attempts;
    //전진 수
    private List<Integer> forwardCount = new ArrayList<>();
    //전진 수만큼 "-"
    private List<String> forwardHyphen = new ArrayList<>();
    GameManagerUtils gameManagerUtils = new GameManagerUtils(cars);
    public GameManager(List<String> cars, int attempts){
        this.cars = cars;
        this.attempts = attempts;
    }
    public GameManager(){ }
    public void game(){
        ConsoleOutput consoleOutput = new ConsoleOutput();
        //cars 사이즈만큼 0으로 forwardCount 사이즈 초기화
        forwardCount = gameManagerUtils.initializeForwardCount();
        //시도 횟수만큼 반복
        for(int i = 0; i < attempts; i++){
            forwardCount = gameManagerUtils.plusForwardCount(forwardCount);
            forwardHyphen = gameManagerUtils.hyphenForForward(forwardCount);
            consoleOutput.printForward(cars, forwardHyphen);
            System.out.println();
        }
        String winnersCommas = gameManagerUtils.joinWithCommas(findWinners(forwardCount));
        consoleOutput.printWinners(winnersCommas);
    }
    //우승자 찾아서 반환

    private List<String> findWinners(List<Integer> forwardCount){
        int winnerForward = gameManagerUtils.winnerCount(forwardCount);
        List<String> winnerCarName = gameManagerUtils.winnerCarName(winnerForward, forwardCount);
        return winnerCarName;
    }
}
