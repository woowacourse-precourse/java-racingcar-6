package racingcar;

import racingcar.constants.Constants;

import java.util.ArrayList;

public class Racing {

    private void race(Car[] cars, int count){
        System.out.println(Constants.raceStr);
        int i = 0;
        while (i < count) {
            int j = 0;
            while (j < cars.length) {
                cars[j].moveCar();
                cars[j].printCar();
                j++;
            }
            System.out.println();
            i++;
        }
    }

    private int getMaxMove(Car[] cars){
        int maxMove = -1;

        int i = 0;
        while (i < cars.length) {
            maxMove = Math.max(maxMove, cars[i].move.length());
            i++;
        }
        return maxMove;
    }

    private ArrayList<String> getWinners(Car[] cars, int maxMove){
        ArrayList<String> winners = new ArrayList<>();

        int i = 0;
        while (i < cars.length) {
            int move = cars[i].move.length();
            if (move == maxMove) winners.add(cars[i].name);
            i++;
        }
        return winners;
    }

    private void printWinners(ArrayList<String> winners){
        System.out.print(Constants.winnerStr);
        for (int i = 0; i < winners.size(); i++){
            if (i > 0) {
                System.out.printf(", %s", winners.get(i));
                continue;
            }
            System.out.print(winners.get(i));
        }
    }

    public void run(){
        String names = userInput.inputNames();
        String number = userInput.inputNumber();
        ArrayList<String> winners;
        int maxMove;

        Cars cars = new Cars(names);
        Count count = new Count(number);
        race(cars.carList, count.val);
        maxMove = getMaxMove(cars.carList);
        winners = getWinners(cars.carList, maxMove);
        printWinners(winners);
    }
}
