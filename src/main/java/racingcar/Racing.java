package racingcar;

import java.util.List;

public class Racing {
    Setting setting;
    List<Car> cars;
    String str = "-";

    public Racing(Setting setting){
        this.setting = setting;
    }

    public void play(){
        setting.settingStart();
        cars = setting.getCars();
        System.out.println("\n실행 결과");

        for (int i = 0; i < setting.getCycleNumber(); i++) {
            runOnce(cars);
            printOnce(cars);
        }

        Winner winner = new Winner(cars);
        List<String> maxCars = winner.whoIsWinner();
        printWinner(maxCars);
    }

    private void runOnce(List<Car> cars) {
        for (Car car : cars) {
            car.goStop();
        }
    }

    private void printOnce(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.print(str.repeat(car.getDistance()));
            System.out.println();
        }
        System.out.println();
    }

    private void printWinner(List<String> maxCars){
        String result = String.join(", ", maxCars);
        System.out.print("최종 우승자 : "+ result);
    }
}