package racingcar.Domain;
import camp.nextstep.edu.missionutils.Randoms;
public class RaceNumberGenerator {
    public static int generateRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
