package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovement {

    public static void moveCar(Car car){
        int randomNumber = createRandomNumber();

        if (randomNumber >= 4){
            car.updateDistance();
        }
    }

    private static int createRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber;
    }
}
