package racingcar.model;

import java.util.ArrayList;

public class FindWinner {

    private StringBuilder winnerList = new StringBuilder();

    public FindWinner(ArrayList<Car> classList) {
        int threshold = -1;

        for (Car car : classList) {
            int position = car.getPosition();

            if (position > threshold) {
                winnerList.setLength(0); // 클리어
                winnerList.append(car.getName());
                threshold = position;

            } else if (position == threshold) {
                winnerList.append(", ").append(car.getName());

            }

        }

    }

    public StringBuilder getWinner() {
        return winnerList;
    }

}
