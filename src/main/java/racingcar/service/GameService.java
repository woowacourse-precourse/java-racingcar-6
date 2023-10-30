package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public static int getRanNum(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static int checkMovement(int num){
        if(num >= 4) return num;
        else return 0;
    }

    //1판 실행
    public List<Car> racing(List<Car> cars){
        //경주
        for(Car car : cars){
            int move = getRanNum();
            car.setMove(move);
        }

        return cars;
    }

    public List<Car> setRacingResult(List<Car> cars){
        int maxMove = 0;
        for(Car car : cars){
            int move = checkMovement(car.getMove()); //4이상인지 체크
            car.setMove(move);
            maxMove = Math.max(maxMove, move);
        }

        for(Car car : cars){
            if(car.getMove() == maxMove) car.setWin(car.getWin()+1);
        }
        return cars;
    }


    //최종 승자
    public List<String> getFinalWinner(List<Car> cars){
        List<String> finalWinners = new ArrayList<>();

        int maxWin = 0;
        for(Car car : cars){
            maxWin = Math.max(maxWin, car.getWin());
        }

        for(Car car : cars){
           if(car.getWin() == maxWin) finalWinners.add(car.getName());
        }

        return finalWinners;
    }



}
