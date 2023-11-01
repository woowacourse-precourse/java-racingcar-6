package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveDisplay {


    public static void carMove(RaceInfo raceInfo) {
        System.out.println("실행 결과");
        int i = 1;
        while (i <= raceInfo.getAttemptCount()) {
            for (Car car : raceInfo.getCarList()) {
                if (decideCarMovement()) {
                    car.increaseCarDistance();
                }

                carMovePrint(car);
            }

            System.out.println();
            i++;
        }
    }

    public static boolean decideCarMovement() {
        int randomNum = Randoms.pickNumberInRange(Constants.RANDOM_NUMBER_MIN, Constants.RANDOM_NUMBER_MAX);
        return randomNum >= Constants.RANDOM_NUMBER_LIMIT;
    }

    public static void carMovePrint(Car car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getCarDistance(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }


}
