package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameStarter {
//    private final int MAX_value = 9;
//    private final int MIN_value = 0;
//    private final int FORWARD_value = 4;
    public static void gameIniter(List<Car> cars, Integer round){
        System.out.println("\n" +
                "실행 결과");
        for(int i=0; i<round; i++){
            gameRunner(cars);
        }
        compareScore(cars);
    }
    public static void gameRunner(List<Car> cars){
        for(Car car: cars){
            move(car);
        }
        System.out.println();
    }
    public static void move(Car car){
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        if (pickedNumber >= 4){
            car.move();
        }
        movingPrinter(car.getName(), car.getPosition());
    }
    public static void movingPrinter(String carName, int position){
        System.out.println(carName +" : "+ "-".repeat(position) );
    }
    public static void compareScore(List<Car> cars){
        HashMap<String, Integer> scoreHashMap = new HashMap<>();
        for(Car car: cars){
            scoreHashMap.put(car.getName(), car.getPosition());
        }
        selectWinner(scoreHashMap);
    }
    public static void selectWinner(HashMap<String, Integer> scoreHashMap){
        int MAX_value = Collections.max(scoreHashMap.values());
        List<String> winnerList = new ArrayList<>();
        for(String key: scoreHashMap.keySet()){
            if(scoreHashMap.get(key).equals(MAX_value)){
                winnerList.add(key);
            }
        }
        winnerPrinter(winnerList);
    }
    public static void winnerPrinter(List<String> winnerList){
        String result = "최종 우승자 : ";
        if(winnerList.size() >= 2){
            winnersPrinter(winnerList, result);
        }else{
            for(String winner: winnerList){
                result += winner; // 2명 이상일 경우 쉼표와 공백 한칸 추가
            }
            System.out.println(result); //우승자 출력
        }
    }
    public static void winnersPrinter(List<String> winnerList, String result){
        for(int i =0; i< winnerList.size(); i++){
            if(i != winnerList.size()-1){
                result += (winnerList.get(i) + ", ");
            }else{
                result += winnerList.get(i);
            }
        }
        System.out.println(result);
    }
}
