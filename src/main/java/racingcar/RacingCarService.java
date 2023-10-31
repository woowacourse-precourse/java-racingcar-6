package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingCarService {
    static final int MOVE_CRITERIA = 4;

    void play(List<RacingCar> racingCars, int totalTurn) {
        System.out.println();
        System.out.println("실행 결과");
        for(int turn = 0; turn < totalTurn; turn++){
            for(RacingCar car : racingCars){
                int moveNum = Randoms.pickNumberInRange(0,9);

                operateCar(car, moveNum);

                printRace(racingCars);
            }
        }
    }
    public RacingCar operateCar(RacingCar car, int moveNum){
        if(moveNum >= MOVE_CRITERIA){
            car.setMoveCount(car.getMoveCount() + 1);
        }

        return car;
    }

    public void printRace(List<RacingCar> racingCars){
        for(RacingCar car : racingCars){
            System.out.print(car.getName() + " : ");

            for(int i = 0; i < car.getMoveCount(); i++){
                System.out.print("-");
            }

            System.out.println();
        }

        System.out.println();
    }
}
