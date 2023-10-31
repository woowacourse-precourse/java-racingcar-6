package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {
    //미리 cars를 sort 한 상태에서 시행 필수!!
    public int getWinnerPoint(Race race){
        return race.getCars().get(0).getPoint();
    }

    //미리 cars를 sort 한 상태에서 시행 필수!!
    public List<Car> makeWinnersList(Race race, int point){
        List<Car> winners = new ArrayList<>();
        for(Car car: race.getCars()){
            if(car.getPoint() == point){
                winners.add(car);
            }else{
                break;
            }
        }
        return winners;
    }

    public List<String> makeWinnerNameList(List<Car> winners){
        List<String> winnerNames = new ArrayList<>();
        for(Car car: winners){
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

    public String makeWinnerNameForPrint(List<String> winnerNames){
        return String.join(",", winnerNames);
    }
}
