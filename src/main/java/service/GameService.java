package service;

import model.RaceCar;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameService {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    private List<RaceCar> raceCars = new ArrayList<>();

    public void createCarObject(List<String> names) {
        for(String name : names) {
            RaceCar raceCar = new RaceCar(name);
            raceCars.add(raceCar);
        }
    }

    public List<RaceCar> MoveForward() {
        for(RaceCar raceCar : raceCars) {
            int randomNumber = pickNumberInRange(MIN_NUM, MAX_NUM);

            if(randomNumber >= 4) {
                raceCar.MoveForward();
            }
        }
        return raceCars;
    }

}