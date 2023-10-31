package racingcar.domain;

import java.util.Map;

public class Game {
    public void printResult(Map<String, Integer> racers) {
        CarMove carMove = new CarMove();
        for (String index : racers.keySet()) {
            if (carMove.moveOrNot()) {//저장된 key값 확인
                int result = racers.get(index) + 1;
                racers.put(index, result);
            }
            System.out.print(index + " : ");
            for (int a = 0; a < racers.get(index); a++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}