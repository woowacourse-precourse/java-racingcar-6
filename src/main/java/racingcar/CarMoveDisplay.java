package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveDisplay {
//    private RaceInfo raceInfo;


//    public CarMoveDisplay(RaceInfo raceInfo) {
////        this.raceInfo = raceInfo;
////        carRace();
////        carRace(raceInfo);
//    }

    public static void carRace(RaceInfo raceInfo) {
        System.out.println("실행 결과");
        int i = 1;
        while (i <= raceInfo.getAttemptCount()) {
            for (Car car : raceInfo.getCarList()) {
                if (decideCarMovement()) {
                    car.increaseCarDistance();
                }
                racePrint(car);
            }

            System.out.println();
            i++;
        }
    }

    public static boolean decideCarMovement() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }

    public static void racePrint(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getCarDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
