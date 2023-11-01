package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

/**
 * 자동차 경주 게임의 진행 로직을 맡은 객체입니다.
 */
public class Game {
    private ArrayList<Car> cars;

    public Game(ArrayList<Car> cars) {
        this.cars = cars;
    }

    /**
     * 경기를 진행합니다. 0부터 9까지의 랜덤한 정수를 생성한 후 점수가 4이상인 자동차의 스코어를 올립니다.
     */
    public void play() {
        for (Car car : cars) {
            int i = Randoms.pickNumberInRange(0, 9);
            if (i>=4) {
                car.upScore();
            }
        }
    }

    /**
     * 스코어가 최대인 자동차를 찾아 반환합니다.
     * @return (Car) 점수 최대인 자동차 (동점이 있을 경우 여러개)
     */
    public ArrayList<Car> pickWinners() {
        ArrayList<Car> winners = new ArrayList<>();
        int highestScore = Integer.MIN_VALUE;

        for (Car car : cars) {
            int currentScore = car.getScore();
            if (currentScore > highestScore) {
                winners.clear();
                winners.add(car);
                highestScore = currentScore;
            } else if (currentScore == highestScore) {
                winners.add(car);
            }
        }

        return winners;
    }
}
