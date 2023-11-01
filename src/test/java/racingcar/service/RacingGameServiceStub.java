package racingcar.service;


import racingcar.common.Message;
import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

class RacingGameServiceStub {
    int remainChance;
    List<Car> entry;
    int maxDistance;

    void init() {
        entry = new ArrayList<>();
        remainChance = 0;
        maxDistance = 1;
    }

    void mainSequence() {
        while (remainChance > 0) {
//                movingSequence();
            remainChance--;
            System.out.println("자동차목록_정상출력" + remainChance);
        }
    }

    void endSequence() {
        List<String> winners = entry.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName).toList();

        System.out.println(Message.WINNER.getMessage() + String.join(", ", winners));
    }

    void setCars(boolean cond) {
//            outputView.printMessage(Message.START);
        getCarsNameReplaced(cond).forEach(name -> entry.add(new Car(name)));
    }

    List<String> getCarsNameReplaced(boolean cond) {
        if (cond) {
            return List.of(new String[]{"yujin", "rei"});
        }
        throw new IllegalArgumentException();
    }

    void setRemainChange(boolean cond) {
//            outputView.printMessage(Message.COUNT);
        remainChance = getPlayCountReplaced(cond);
    }

    int getPlayCountReplaced(boolean cond) {
        if (cond) {
            return 1;
        }
        throw new IllegalArgumentException();
    }

    int getMaxDistance() {
        int max = 0;

        for (Car car : entry) {
            max = Math.max(max, car.getDistance());
        }
        return max;
    }

}
