package racingcar;

import java.util.List;

public class MoveForward {
    public static List<Integer> judge(List<Integer> randomNumbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) < 4)
                randomNumbers.set(i, 0);
        }
        return randomNumbers;
    }
    public static void moving(Car[] cars, List<Integer> randomNumbers){
        List<Integer> move = judge(randomNumbers);
        for(int i = 0; i < cars.length; i++){
            cars[i].steps += move.get(i);
        }
    }
}
