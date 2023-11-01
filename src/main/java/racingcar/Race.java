package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;

//Race Class 
public class Race {
    //멤버 필드 
    LinkedHashMap<String, Integer> racingCars;

    //Race 생성자 
    Race(LinkedHashMap<String, Integer> racingCars) {
        this.racingCars = racingCars;
    }
    //racingCars 초기화 
    void racingCarInit(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            this.racingCars.put(cars[i], 0);
        }
    }

    //race 시작 
    void raceStart(int gameCount) {
        /*
         * 파라미터 gameCount를 받아와 그 횟수만큼의 경기를 시작합니다. 
         * moveCount는 moveCountInit()의 return값을 받아 값을 할당합니다. 
         * move는 concatMove의 return 값을 받아 할당합니다. 
         * 만약 moveCount가 4이상이라면 해당 car의 값을 새로운 값으로 할당시키게 됩니다. 
         */
        while (gameCount-- > 0) {
            for (Map.Entry<String, Integer> car : this.racingCars.entrySet()) {
                int moveCount =  this.moveCountInit();
                String move = this.concatMove("-", moveCount);
                System.out.println(String.format("%s : %s", car.getKey(), move));
                if (moveCount >= 4) {
                    car.setValue(car.getValue() + moveCount);
                }
            }
            System.out.println();
        }
    }
    // 전진 횟수 초기화 
    int moveCountInit() {
        return Randoms.pickNumberInRange(0, 9);
    }

    /*
     * 파라미터를 move와 moveCount를 받고 
     * moveCount 값만큼 move를 이어 붙입니다. 
     */
    String concatMove(String move, int moveCount) {
        StringBuilder sb = new StringBuilder(move.length() * moveCount);
        for (int i = 1; i <= moveCount; i++) {
            sb.append(move);
        }
        return sb.toString();
    }
}
