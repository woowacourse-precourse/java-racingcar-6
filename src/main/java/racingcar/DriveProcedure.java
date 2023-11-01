package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Application.cars;

public class DriveProcedure {

    public static void drive(Integer saveTrialNumber) {
        for (int i = 0; i<saveTrialNumber; i++) {
            updateDriveNum();
            driveResult();
            System.out.println("");
        }
    }
    private static Integer createDriveCarNum () {
        Integer driveNumber = isMoreThanFour(createRandomNum());
        return driveNumber;
    }
    private static Integer createRandomNum() {
        Integer randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
    private static Integer isMoreThanFour (Integer randomNum) {
        if (randomNum >= 4) {
            return 1;
        } else {
            return 0;
        }
    }
    private static void updateDriveNum() {
        for (Car car : cars) {
            Integer newDriveNum = createDriveCarNum();
            car.setDriveNum(newDriveNum);
        }
    }
    private static String makeResultSign(int number) {
        String resultSign="";
        for (int i = 0; i<number; i++) {
            resultSign+="-";
        }
        return resultSign;
    }
    private static void driveResult() {
        for (Car car : cars ) {
            System.out.println(car.getName()+" : "+makeResultSign(car.getDriveNum()));
        }
    }

}
