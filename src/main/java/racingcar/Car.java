package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Car{
    Map<String,String> carInformation = new HashMap<>();
    int repeatCount;
    public Car() {
        init();
    }

    public void init(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = readLine();
        for (String name : carName.split(",")){
            carInformation.put(name.trim(),"");
        }
        CheckException.checkRightCarName(carInformation.keySet());
        repeatCount = User.howMuchTry();
    }

    private int createRandomNumber() {
        return pickNumberInRange(0,9);
    }

    private boolean checkGoOrStop(int num){
        if (num >= 4){
            return true;
        }
        return false;
    }

    private void writeForwardDistance(String carName){
        String distance = carInformation.get(carName);
        int num = createRandomNumber();
        if (checkGoOrStop(num)){
            distance += "-" ;
            carInformation.put(carName,distance);
        }
    }

    private void whichCarWillMove(){
        Set<String> carNameSet = carInformation.keySet();
        for (String carName : carNameSet){
            writeForwardDistance(carName);
        }
    }

    public void displayCarInformation(){
        System.out.println("\n실행 결과");
        for (int i=0; i<repeatCount; i++){
            whichCarWillMove();
            carInformation.forEach((key, value) -> System.out.println(key + " : " + value));
            System.out.println();
        }
    }

    public void displayWhoIsWinner(){
        List<String> winnerList = findWinner();
        if (winnerList.size() == 1){
            String winner = winnerList.get(0);
            System.out.println("최종 우승자 : " + winner);
        }
        else{
            String result = moreThanOneWinner(winnerList);
            System.out.print("최종 우승자 : " + result);
        }
    }

    public static String moreThanOneWinner(List<String> list){
        StringBuilder result = new StringBuilder();
        for (String name : list){
            result.append(name).append(", ");
        }
        result.setLength(result.length() - 2);
        return result.toString();
    }

    public List<String> findWinner(){
        List<String> winner = new ArrayList<>();
        int maxDistance = -1;
        for (Map.Entry<String, String> entry : carInformation.entrySet()) {
            int value = entry.getValue().length();
            if (value > maxDistance) {
                winner.clear();
                winner.add(entry.getKey());
                maxDistance = value;
            } else if (value == maxDistance) {
                winner.add(entry.getKey());
            }
        }
        return winner;
    }
}

