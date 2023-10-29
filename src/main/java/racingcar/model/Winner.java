package racingcar.model;

import racingcar.domain.Car;

import java.util.List;

public class Winner {
    public String selectWinner(List<Car> result) {
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();

        for (Car car : result) {
            int dist = car.getDist();
            String name = car.getName();

            if (dist == max) {
                sb.append(name + ", ");
            } else if (dist > max) {
                max = dist;
                sb.delete(0, sb.length());
                sb.append(name + ", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
