package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Referee {
    private Cars cars;

    public Referee(Cars cars) {
        this.cars = cars;
    }

    // 각 자동차마다 값을 랜덤으로 뽑아 Car.position 값 변경
    public Cars playRound(Cars cars) {
        for(int i=0;i<cars.size();i++){
            updateCarPosition(cars.getIndex(i));
        }
        return cars;
    }
    private Car updateCarPosition(Car car) {
        int move = Randoms.pickNumberInRange(1, 9);
        if (move >= 4) {
            car.carMove(move);
        }
        return car;
    }

    public Cars determineWinners(Cars cars) {
        int maxPosition = 0;

        for (int i = 0; i < cars.size(); i++) {
            maxPosition = Math.max(maxPosition, cars.getIndex(i).getPosition());
        }


        ArrayList<String> winnerNames = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (cars.getIndex(i).getPosition() == maxPosition) {
                winnerNames.add(cars.getIndex(i).getName());
            }
        }
        Cars winners = new Cars(winnerNames);
        return winners;
    }
}