package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Race {
    private final Car car;
    private int inputMove;

    public Race() {
        car = new Car();
        inputMove();
        startRace();
        endRace();
    }

    public void inputMove() {
        System.out.println("시도할 회수는 몇회인가요?");
        inputMove = Integer.parseInt(Console.readLine());
    }

    public boolean isGo() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }
    public void startRace(){
        System.out.println("\n실행 결과");
        for (int i = 0; i < inputMove; i++){
            racingCar();
            printDist();
        }
    }

    private void racingCar(){
        for (String carName : car.getCar()){
            if (isGo()){
                car.goCar(carName);
            }
        }
    }

    private void printDist(){
        for (String carName : car.getCar()){
            System.out.println(carName + " : " + "-".repeat(car.getCarDist().get(carName)));
        }
        System.out.println();
    }

    public void endRace() {
        int maxValue = Collections.max(car.getCarDist().values());

        List<String> maxValueKeys = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : car.getCarDist().entrySet()) {
            if (entry.getValue() == maxValue) {
                maxValueKeys.add(entry.getKey());
            }
        }

        System.out.println("최종 우승자 : " + String.join(",",maxValueKeys));
    }
}