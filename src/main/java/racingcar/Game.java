package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static void play (Car[] car, int times) {
        OutputView.outputResult();
        for (int i = 0; i < times; i++) {
            Game.playOnce(car);
        }
    }
    
    static void playOnce (Car[] car) {
        for (int j = 0; j < car.length; j++) {
            car[j].changeLocation();
            car[j].printLocation();
        }
        System.out.println();
    }
    
    static void chooseWinner(Car[] car) {
        int furthestLocation = getFurthestLocation(car);
        List<String> winners = getWinners(car, furthestLocation);
        OutputView.Winner();
        System.out.println(String.join(", ", winners));
    }
    
    static int getFurthestLocation(Car[] car) {
        int furthestLocation = 0;
        for (int i = 0; i < car.length; i++) {
            if (car[i].getLocation() > furthestLocation) {
                furthestLocation = car[i].getLocation();
            }
        }
        return furthestLocation;
    }
    
    static List<String> getWinners(Car[] car, int furthestLocation) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < car.length; i++) {
            if (car[i].getLocation() == furthestLocation) {
                winners.add(car[i].getName());
            }
        }
        return winners;
    }
}
