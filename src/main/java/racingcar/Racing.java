package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

class car {
    String name;
    String move;
    car(String name, String move){
        this.name = name;
        this.move = move;
    }

    void printCar() {
        System.out.printf("%s: %s\n", this.name, this.move);
    }

    void moveCar() {
        int val = Randoms.pickNumberInRange(0, 9);
        if (val >= 4) this.move += "-";
    }
}

public class Racing {

    private car[] initCars(){
        System.out.println("경주할 자동차 이름을 입력하세요." +
                "(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        int cntComma = names.split(",").length;
        String[] arrname = names.split(",");
        car[] cars = new car[cntComma];

        for (int i = 0; i < cntComma; i++){
            cars[i] = new car(arrname[i], "");
        }
        return cars;
    }

    private int strToInt(String s){
        int lenS = s.length();

        if (lenS > 1) {
            char c = s.charAt(lenS - 1);
            return (strToInt(s.substring(0, lenS - 1)) * 10
                    + (c - '0'));
        }
        return s.charAt(0) - '0';
    }

    private int initCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();

        return strToInt(count);
    }

    private void race(car[] cars, int count){
        System.out.println("실행 결과");
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

    private int getMaxMove(car[] cars){
        int maxMove = -1;

        int i = 0;
        while (i < cars.length) {
            maxMove = Math.max(maxMove, cars[i].move.length());
            i++;
        }
        return maxMove;
    }

    private ArrayList<String> getWinners(car[] cars, int maxMove){
        ArrayList<String> winners = new ArrayList<String>();

        int i = 0;
        while (i < cars.length) {
            int move = cars[i].move.length();
            if (move == maxMove) winners.add(cars[i].name);
            i++;
        }
        return winners;
    }

    private void printWinners(ArrayList<String> winners){
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++){
            if (i > 0) {
                System.out.printf(", %s", winners.get(i));
                continue;
            }
            System.out.print(winners.get(i));
        }
    }

    public void run(){
        ArrayList<String> winners;
        car[] cars = initCars();
        int count = initCount();
        int maxMove;

        race(cars, count);
        maxMove = getMaxMove(cars);
        winners = getWinners(cars, maxMove);
        printWinners(winners);
    }
}
