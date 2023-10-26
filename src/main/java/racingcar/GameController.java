package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class GameController {

    GameModel gameModel = new GameModel();
    GameView gameView = new GameView();
    ArrayList<String> carNames = new ArrayList<>();
    ArrayList<Integer> carPositions = new ArrayList<>();
    public void run () {

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesArray = Console.readLine().split(",");
        for (String carName : carNamesArray) {
            carNames.add(carName);
            carPositions.add(0);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        for(int i = 0; i < carNames.size(); i++) {
            for(int j = 0; j < count; j++) {
                int randInt = Randoms.pickNumberInRange(0,9);
                if(randInt >= 4) {
                    carPositions.set(i, carPositions.get(i) + 1);
                }
            }
        }

        System.out.println("실행 결과");
        for(int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            for(int j = 0; j < carPositions.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }

        // 최대값 찾기
        int maxPosition = 0;
        for(int position : carPositions) {
            if(position > maxPosition) {
                maxPosition = position;
            }
        }

        // 최대값과 일치하는 자동차 이름 찾기
        ArrayList<String> winners = new ArrayList<>();
        for(int i = 0; i < carPositions.size(); i++) {
            if(carPositions.get(i) == maxPosition) {
                winners.add(carNames.get(i));
            }
        }

        // 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
