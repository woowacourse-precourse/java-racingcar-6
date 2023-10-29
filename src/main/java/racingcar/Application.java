package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();
        Race race = new Race();
        
        String[] carArray = cars.enterCars();
        cars.validateCarsName(carArray);
        
        race.initScorePerCar(carArray);
        race.enterRaceNum();
        race.raceProgress();
        
        int maxDistance = -1;
        List<String> winCars = new ArrayList<>();
        for (String scorePerCarKey : scorePerCar.keySet()) {
            String distance = scorePerCar.get(scorePerCarKey);//마지막에 각 키에 따른 밸류 길이 비교
            if (distance.length() > maxDistance) {
                maxDistance = distance.length();
            }
        }
    
        for (String scorePerCarKey : scorePerCar.keySet()) {
            if (scorePerCar.get(scorePerCarKey).length() == maxDistance) {
                winCars.add(scorePerCarKey);
            }
        }
        System.out.println("최종 우승자 : " + String.join(",", winCars));
    }
    
}
