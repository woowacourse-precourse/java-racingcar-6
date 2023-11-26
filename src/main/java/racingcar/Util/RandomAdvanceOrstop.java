package racingcar.Util;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Cars;
import racingcar.Service.UserInput;
import static racingcar.Model.NumberConstant.*;

public class RandomAdvanceOrstop {


    public static final String HYPHEN = "-";

    UserInput userInput = new UserInput();

    Cars car;

    public void judgeAdvanceOrStop() {
        if (judgeadvanceOrStopNumber() >= CAR_ADVANCE_NUMBER){
            Move();
        }
    }


    private int judgeadvanceOrStopNumber()  {   //전진하는 메소드, 출력
        return  Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }


    private void Move() {
        for (int i = 0; i < car.carList.length; i++) {
            car.carList[i] = car.carList[i].concat(HYPHEN);
        }
    }
}
