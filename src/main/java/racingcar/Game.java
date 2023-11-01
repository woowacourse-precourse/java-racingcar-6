package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars;
    private int round;

    /**
     * Game 객체를 생성합니다.
     *
     * @param cars  게임에 참여할 Car 객체의 리스트입니다.
     * @param round 게임을 진행할 라운드 수입니다.
     */
    public Game(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    /**
     * 게임을 진행합니다. 각 라운드마다 모든 자동차의 move 메소드를 호출하고 결과를 출력합니다.
     */
    public void play() {
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.move();
            }
            displayResult();
        }
    }

    /**
     * 최종 우승자의 이름 리스트를 반환합니다.
     *
     * @return 최대 위치에 있는 자동차의 이름 리스트입니다.
     */
    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaximumPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    /**
     * 참여한 모든 자동차 중에서 최대 위치 값을 찾아 반환합니다.
     *
     * @return 참여한 모든 자동차 중에서 최대 위치 값입니다.
     */
    private int getMaximumPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    /**
     * 현재까지의 게임 결과를 출력합니다.
     */
    private void displayResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
