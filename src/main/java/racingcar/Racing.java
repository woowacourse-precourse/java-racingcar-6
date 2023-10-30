package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class car {
    String name;
    String move;
    car(String name, String move){
        this.name = name;
        this.move = move;
    }

    void printCar() {
        System.out.printf("%s: %s\n",
                this.name, this.move);
    }

    void moveCar() {
        int val = Randoms.pickNumberInRange(0, 9);
        if (val >= 4) this.move += "-";
    }
}

public class Racing {


    private car[] initCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        int cntComma = names.split(",").length;
        String[] arrname = names.split(",");
        car[] cars = new car[cntComma];

        for (int i = 0; i < cntComma; i++){
            cars[i] = new car(arrname[i], "");
        }
        return cars;
    }

    public void run(){
        car[] cars = initCars();
        int count = initCount();

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
}
