package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Car car = new Car();
        car.displayCarInformation();
        car.displayWhoIsWinner();
    }
}
class User{
    static int NumberOfMove(){
        System.out.println("시도할 회수는 몇회인가요?");
        String InputTry = readLine();
        int moveCount = CheckException.CheckRightNumberOfMove(InputTry);
        return moveCount;
    }
}

class Car{
    Map<String,Integer> CarInformation = new HashMap<>();
    int RepeatCount;
    public Car() {
        init();
    }

    public void init(){
        String CarName = readLine();
        for (String name : CarName.split(",")){
            CarInformation.put(name.trim(),0);
        }
        CheckException.CheckRightCarName(CarInformation.keySet());
        RepeatCount = User.NumberOfMove();
    }

    private int CreateRandomNumber() {
        return pickNumberInRange(0,9);
    }
    private boolean CheckGoOrStop(int num){
        if (num >= 4){
            return true;
        }
        return false;
    }
    private void WriteForwardDistance(String CarName){
        int distance = CarInformation.get(CarName);
        int num = CreateRandomNumber();
        if (CheckGoOrStop(num)){
            distance++ ;
            CarInformation.put(CarName,distance);
        }
    }

    private void WhichCarWillMove(){
        Set<String> CarNameSet = CarInformation.keySet();
        for (String CarName : CarNameSet){
            WriteForwardDistance(CarName);
        }
    }

    public void displayCarInformation(){
        System.out.println("\n실행 결과");
        for (int i=0; i<RepeatCount; i++){
            WhichCarWillMove();
            CarInformation.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
            System.out.println();
        }
    }
    public void displayWhoIsWinner(){
        List<String> WinnerList = FindWinner();
        if (WinnerList.size() == 1){
            String Winner = WinnerList.get(0);
            System.out.println("최종 우승자 : " + Winner);
        }
        else{
            String result = MoreThanOneWinner(WinnerList);
            System.out.print("최종 우승자 : " + result);

        }
    }

    public static String MoreThanOneWinner(List<String> list){
        StringBuilder result = new StringBuilder();
        for (String name : list){
            result.append(name).append(", ");
        }
        result.setLength(result.length() - 2);
        return result.toString();
    }

    public List<String> FindWinner(){
        List<String> Winner = new ArrayList<>();
        int maxDistance = -1;
        for (Map.Entry<String, Integer> entry : CarInformation.entrySet()) {
            int value = entry.getValue();
            if (value > maxDistance) {
                Winner.clear();
                Winner.add(entry.getKey());
                maxDistance = value;
            } else if (value == maxDistance) {
                Winner.add(entry.getKey());
            }
        }
        return Winner;
    }
}

class CheckException {
    static void CheckRightCarName(Set<String> CarNameSet){
        for (String name : CarNameSet){
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    static int CheckRightNumberOfMove(String move){
        try{
            int number = Integer.parseInt(move);
            return number;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}