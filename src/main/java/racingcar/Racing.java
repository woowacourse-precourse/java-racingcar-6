package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    Setting setting;
    List<Car> cars;

    public Racing(Setting setting){
        this.setting = setting;
    }

    public void play(){
        cars = setting.getCars();
        System.out.println("실행 결과");

        for (int i = 0; i < setting.getCycleNumber(); i++) {
            runOnce(cars);
            printProcess(cars);
        }

        Winner winner = new Winner(cars);
        List<Car> maxCars = winner.whoIsWinner();
        printWinner(maxCars);
    }

    private void runOnce(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if(Randoms.pickNumberInRange(0,9)>=4){
                car.setDistance();
            }
        }
    }

    private void printProcess(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.print(car.getName() + " : ");
            for (int j = 0; j < car.getDistance(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printWinner(List<Car> maxCars){
        System.out.print("최종 우승자 : ");
        System.out.print(maxCars.get(0).getName());
        for (int i = 1; i < maxCars.size(); i++) {
            System.out.println(", "+maxCars.get(0).getName());
        }
    }
}