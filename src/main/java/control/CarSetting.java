package control;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import model.Car;
import valid.ValidCheck;

public class CarSetting {
    private String[] carName;
    private Car[] car;
    ValidCheck validCheck = new ValidCheck();

    public void setCars() {
        for (int index = 0; index < carName.length; index++) {
            car[index] = new Car();
            car[index].setCarName(carName[index]);
        }
    }

    public void runningCars() {
        for (int index = 0; index < carName.length; index++) {
            if (isGreaterThan()) {
                car[index].increaseRunCount();
            }
        }
    }

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isGreaterThan() {
        int randomNumber = makeRandomNumber();
        return randomNumber >= 4;
    }

    public void setCarName() {
        carName = Console.readLine().split(",");
        for (String name : carName) {
            validCheck.checkNameLength(name);
            validCheck.checkNameNoInput(name);
        }

        setCar();
    }



    public void setCar() {
        car = new Car[carName.length];
        setCars();
    }

    public Car[] getCar() {
        runningCars();
        return car;
    }

}
