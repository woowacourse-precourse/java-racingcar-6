package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static HashMap<String, Integer> race = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = readLine();
        initializeRace(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int number = Integer.parseInt(readLine());

        System.out.println("실행 결과");
        for(int i=0; i<number; i++){
            racing();
        }

        ArrayList<String> winner = new ArrayList<>();
        getWinner(winner);
        printWinner(winner);
    }

    public static void initializeRace(String inputCarNames){
        String[] carNames = inputCarNames.split(",");

        for (String carName : carNames) {
            if(!isGoodName(carName)){
                throw new IllegalArgumentException("Car name Error : " + carName);
            }
            race.put(carName, 0);
        }
    }

    public static boolean isGoodName(String carName){
        return carName.length() <= 5;
    }

    public static void racing(){
        for(String carName: race.keySet()){
            int forward = getForwardDistance();

            printCarProgress(carName, forward);

            if(forward >= 4) {
                race.put(carName, race.getOrDefault(carName, 0) + forward);
            }
        }
        System.out.println();
    }

    public static int getForwardDistance() {
        return Randoms.pickNumberInRange(0,9);
    }

    public static void printCarProgress(String carName, int forward) {
        System.out.print(carName + " : ");
        for(int i=0; i<forward; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void getWinner(ArrayList<String> winner){
        int max = Integer.MIN_VALUE;
        for(String carName: race.keySet()){
            int forwardCount = race.get(carName);

            if(forwardCount > max){
                winner.clear();
                winner.add(carName);
                max = forwardCount;
            }
            else if(forwardCount == max){
                winner.add(carName);
            }
        }
    }

    public static void printWinner(ArrayList<String> winner){
        System.out.print("최종 우승자 : ");
        String result = String.join(",", winner);
        System.out.println(result);
    }
}
