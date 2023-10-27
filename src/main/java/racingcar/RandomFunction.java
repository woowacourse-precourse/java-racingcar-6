package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomFunction {
    public RandomFunction() {
    }
    public void CreateRandomFunction(List<Integer> UserRace, int usersNumber) {
        for(int i = 0; i < usersNumber; i++){
            if(pickNumberInRange(0,9) > 4){
                UserRace.set(i, UserRace.get(i) + 1);
            }
        }
    }
}