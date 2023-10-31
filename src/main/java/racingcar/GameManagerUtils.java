package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManagerUtils {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final int ZERO = 0;
    private static List<String> cars = new ArrayList<>();
    public GameManagerUtils(List<String> cars){
        this.cars = cars;
    }
    public GameManagerUtils(){}
    public static int winnerCount(List<Integer> forwardCount){
        int winnerCount = 0;
        for(int count : forwardCount){
            if(count > winnerCount) winnerCount = count;
        }
        return winnerCount;
    }
    //우승자 이름이 담겨있는 리스트 반환
    public static List<String> winnerCarName(int winnerCount, List<Integer> forwardCount){
        List<String> winnerCarName = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++){
            if(winnerCount == forwardCount.get(i)) winnerCarName.add(cars.get(i));
        }
        return winnerCarName;
    }
    public static int randomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE,MAX_RANDOM_VALUE);
    }
    public static List<Integer> initializeForwardCount(){
        List<Integer> forwardCount = new ArrayList<>();
        for (String car : cars) forwardCount.add(ZERO);
        return forwardCount;
    }
    //랜덤값이 4이상이면 전진 수 하나씩 더하기
    public static List<Integer> plusForwardCount(List<Integer> forwardCount){
        for(int j = 0; j < forwardCount.size(); j++){
            if(randomNumber() >= MIN_FORWARD_THRESHOLD) forwardCount.set(j, forwardCount.get(j) + 1);
        }
        return forwardCount;
    }
    //전진 수만큼 "-" 채우기
    public static List<String> hyphenForForward(List<Integer> forwardCount){
        List<String> forwardHyphen = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++){
            String hyphen = "-".repeat(forwardCount.get(i));
            forwardHyphen.add(i, hyphen);
        }
        return forwardHyphen;
    }

    public String joinWithCommas(List<String> winnerCarName){
        return String.join(", ", winnerCarName);
    }
}
