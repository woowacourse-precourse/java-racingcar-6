package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import racingcar.constants.Constants;
import racingcar.validation.Validation;

class Car {
    String name;
    String move;
    Car(String name, String move){
        this.name = name;
        this.move = move;
    }

    void printCar() {
        System.out.printf("%s : %s\n", this.name, this.move);
    }

    void moveCar() {
        int val = Randoms.pickNumberInRange(0, 9);
        if (val >= 4) this.move += "-";
    }
}
public class Cars {
    Car[] carList;

    Car[] initCars(){
        System.out.println(Constants.carsStr);
        String names = Console.readLine();

        Validation.validNames(names);
        int cntComma = names.split(",").length;
        String[] arrname = names.split(",");
        Car[] cars = new Car[cntComma];
        for (int i = 0; i < cntComma; i++){
            cars[i] = new Car(arrname[i], "");
        }
        return cars;
    }

    Cars(){
        this.carList = initCars();
    }
}
