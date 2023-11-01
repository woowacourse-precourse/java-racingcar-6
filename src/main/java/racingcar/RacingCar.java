package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar {
    public final int MIN_RANDOM_NUMBER = 0;
    public final int MAX_RANDOM_NUMBER = 9;
    public final int GO_NUMBER = 4;

    private final String name;
    private int position = 0;
    public RacingCar(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public void PlayerGoStop() {
        int RandomNumber =  pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if(RandomNumber >= GO_NUMBER) {
            position += 1;
        }
    }
}

