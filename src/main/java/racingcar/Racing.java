package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class Racing implements RacingBehavior{

    private final User user;
    private HashMap<String, Integer> map;

    public Racing(User user) {
        this.user = user;
    }

    @Override
    public void checkStopAndGo() {
        map = user.getMap();
        String[] carNames = user.getCarNames();
        for(int k = 0; k< carNames.length; k++) {
            int stopAndGo = Randoms.pickNumberInRange(0,9);

            if(stopAndGo >= 4) {
                map.put(carNames[k], map.get(carNames[k]) + 1);
            }
            System.out.println(carNames[k] + " : " + "-".repeat(map.get(carNames[k])));
        }
        System.out.println();
    }

}
