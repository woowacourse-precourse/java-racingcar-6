package racingcar.view;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;
import java.util.StringJoiner;

public class PlayeroutputView {

    public static void round(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            String onestepMessage = generateOnestepMessage(car.getPosition());
            System.out.println(carName + " : " + onestepMessage);
        }
        System.out.println();
    }

    public static String generateOnestepMessage(int position) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < position; i++) {
            message.append("-");
        }
        return message.toString();
    }

    public static void updateRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                car.setPosition(car.getPosition() + 1);
            }
        }
    }

    public static int result(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public static void resultPrize(List<Car> cars, int prize) {
        StringJoiner winners = new StringJoiner(", ");
        for (Car car : cars) {
            if (car.getPosition() == prize) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + winners);
    }

}
