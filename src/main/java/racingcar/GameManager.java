package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void printResult(String[] cars, int[] distance) {
        System.out.println("실행 결과");
        for(int i = 0; i < cars.length; i++) {
            System.out.println(cars[i] + " : " + distance[i]);
        }
    }
}
