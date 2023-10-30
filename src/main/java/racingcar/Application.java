package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userName = Console.readLine();
        String[] carNameInput = userName.split(",");
        List<String> carNameList = new ArrayList<>();

        for (String carName : carNameInput) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carNameList.add(carName);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int userInput = Integer.parseInt(Console.readLine());

        int carSize = carNameList.size();
        int[] distances = new int[carSize];

        for (int i = 0; i < userInput; i++) {
            for (int j = 0; j < carSize; j++) {
                int cp = Randoms.pickNumberInRange(0, 9);
                if (cp >= 4) {
                    distances[j] += 1;
                }
            }

            for (int carindex = 0; carindex < carSize; carindex++) {
                System.out.print(carNameList.get(carindex) + " : ");
                for (int a = 0;a < distances[carindex]; a++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println("\n");
        }
        int maxdistance = 0;
        for (int distance : distances) {
            if (distance > maxdistance) {
                maxdistance = distance;
            }
        }
        StringBuilder winners = new StringBuilder();
        for (int i=0;i< carSize;i++){
            if (distances[i] == maxdistance){
                if(winners.length() > 0 ){
                    winners.append(", ");
                }
                winners.append(carNameList.get(i));
            }
        }
        System.out.println("최종 우승자 : "+ winners );
    }
}
