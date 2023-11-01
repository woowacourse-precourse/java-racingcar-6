package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    static final int MOVE_CRITERIA = 4;
    static final int START_MOVE_COUNT = -1;

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

        List<String> leaders = findTheLeaders(racingCars);
        printLeaders(leaders);
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

    public List<String> findTheLeaders(List<RacingCar> racingCars){
        int largestMove = START_MOVE_COUNT;

        for(RacingCar car : racingCars){
            largestMove = Math.max(largestMove, car.getMoveCount());
        }

        List<String> leaders = new ArrayList<>();

        for(RacingCar car : racingCars){
            if(car.getMoveCount() == largestMove){
                leaders.add(car.getName());
            }
        }

        return leaders;
    }

    public void printLeaders(List<String> leaders){
        System.out.print("최종 우승자 : ");

        if(leaders.size() == 1){
            for(String leader : leaders){
                System.out.print(leader);
            }
        } else{
            int lastLeaderIndex = leaders.size() - 1;

            for(int i = 0; i < lastLeaderIndex; i++){
                System.out.print(leaders.get(i) + ", ");
            }
            System.out.println(leaders.get(lastLeaderIndex));
        }
    }
}
