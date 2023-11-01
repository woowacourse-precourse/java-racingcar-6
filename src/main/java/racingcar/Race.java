package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Race {
    private int inputMove;

    private int randomNum;

    public void inputMove() {
        System.out.println("시도할 회수는 몇회인가요?");
        inputMove = Integer.parseInt(Console.readLine());
        System.out.println(inputMove);
    }

    public boolean isGo() {
        randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }

    public String endRace() {
        Car car = new Car();
        int maxValue = Collections.max(car.getCarDist().values());

        List<String> maxValueKeys = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : car.getCarDist().entrySet()) {
            if (entry.getValue() == maxValue) {
                maxValueKeys.add(entry.getKey());
            }
        }
        return String.join(",",maxValueKeys);
    }
}