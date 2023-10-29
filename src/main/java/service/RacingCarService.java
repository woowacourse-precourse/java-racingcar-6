package service;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCarService {

    public int generateRandomNumber() {
        int randomNumber = pickNumberInRange(1,9);
        return randomNumber;
    }
}
