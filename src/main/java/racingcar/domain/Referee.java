package racingcar.domain;

import java.util.List;

public class Referee {

    public String showWinner(List<Car> carList) {
        String winner = "";
        int position = 0;
        for (int i = 0; i < carList.size(); i++) {
            if (position < carList.get(i).carPosition) {
                position = carList.get(i).carPosition;
                winner = carList.get(i).carName;
            } else if (position == carList.get(i).carPosition) {
                winner += ", " + carList.get(i).carName;
            }
        }
        return "최종 우승자 : " + winner;
    }
}
