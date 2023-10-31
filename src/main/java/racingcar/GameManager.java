package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public static List<String> cars;
    private int attempts;
    private List<String> forwardHyphen = new ArrayList<>();
    public static List<Integer> forwardCount = new ArrayList<>();
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final int ZERO = 0;
    ConsoleOutput consoleOutput = new ConsoleOutput();
    public GameManager(List<String> cars, int attempts){
        this.cars = cars;
        this.attempts = attempts;
    }
    public GameManager(){ }
    public void game(){
        //cars 사이즈만큼 0으로 forwardCount 사이즈 초기화
        initializeForwardCount(forwardCount);

        for(int i = 0; i < attempts; i++){
            forwardCount = plusForwardCount(forwardCount);
            forwardHyphen = hyphenForForward(forwardCount);
            consoleOutput.printForward(cars, forwardHyphen);
            System.out.println();
        }
        consoleOutput.printWinners(findWinners());
    }
    //우승자 찾아서 반환
    private String findWinners(){
        List<String> winnerCarName = winnerCarName(winnerCount());
        return String.join(", ", winnerCarName);
    }
    //우승자 전진 수 반환
    private int winnerCount(){
        int winnerCount = 0;
        for(int count : forwardCount){
            if(count > winnerCount) winnerCount = count;
        }
        return winnerCount;
    }
    //우승자 이름이 담겨있는 리스트 반환
    private List<String> winnerCarName(int winnerCount){
        List<String> winnerCarName = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++){
            if(winnerCount == forwardCount.get(i)) winnerCarName.add(cars.get(i));
        }
        return winnerCarName;
    }
    private int randomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE,MAX_RANDOM_VALUE);
    }
    private List<Integer> initializeForwardCount(List<Integer> forwardCount){
        for (String car : cars) forwardCount.add(ZERO);
        return forwardCount;
    }
    //랜덤값이 4이상이면 전진 수 하나씩 더하기
    private List<Integer> plusForwardCount(List<Integer> forwardCount){
        for(int j = 0; j < forwardCount.size(); j++){
            if(randomNumber() >= MIN_FORWARD_THRESHOLD) forwardCount.set(j, forwardCount.get(j) + 1);
        }
        return forwardCount;
    }
    //전진 수만큼 "-" 채우기
    private List<String> hyphenForForward(List<Integer> forwardCount){
        for(int b = 0; b < cars.size(); b++){
            String hyphen = "-".repeat(forwardCount.get(b));
            forwardHyphen.add(b, hyphen);
        }
        return forwardHyphen;
    }
}
