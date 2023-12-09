package racingcar.Util;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.Service.UserInputCarName;
import static racingcar.Infomation.NumberConstant.*;

public class RandomAdvanceOrStop {

    public static final String HYPHEN = "-";
    UserInputCarName userInput = new UserInputCarName();
    Car car;

    public void judgeAdvanceOrStop() {  //직진인지 멈춤인지 판단
        for (int i = 0; i < car.getTryNumber(); i++) {
            if (judgeadvanceOrStopNumber() >= CAR_ADVANCE_NUMBER){
                Move();
            }
            printCarList();
            /*
                pobi :
                hol :
                mol :
             */
        }
    }

    private int judgeadvanceOrStopNumber()  {   //1부터 9까지 랜덤한 수 구하기
        return  Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private void Move() {
        for (int i = 0; i < car.carList.length; i++) {
            car.carList[i] = car.carList[i].concat(HYPHEN);
        }
    }

    private void printCarList() {
        for (int i = 0; i < car.getCarList().length; i++) {
            System.out.println(car.carList[i] + ":");
        }
    }
}
