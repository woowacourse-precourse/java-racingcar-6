package racingcar.race.rule;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.car.model.Car;

public class RandomRaceRule implements RaceRule {

    private final int MOVABLE_LIMIT = 3;
    private final int MIN_RANDOM_RANGE_NUMBER = 0;
    private final int MAX_RANDOM_RANGE_NUMBER = 9; // 해당 상수값은 외부적으로 주어진 것인데, default를 위한 것이 아니라면 매개변수로도 받을 수 있도록 열어두는 것이 좋지 않을까요?

    private boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_RANGE_NUMBER,
                MAX_RANDOM_RANGE_NUMBER);
        return MOVABLE_LIMIT < randomNumber; // randomNumber >= 4와 같이 작성해주시는게 더 이해하기 편할 것 같다는 개인적인 생각입니다.
    }

    public void round(List<Car> participantList) {
        for (Car car : participantList) {
            if (isMovable()) {
                car.moveForward(); // '자동차가 움직인다'는 행위 자체는 게임에서 이루어지는 것인데, 규칙자체에서 해당 객체를 움직이게 하는게 맞을까요?
            }
        }
    }

    private int getWinnersPosition(List<Car> participantList) {
        Collections.sort(participantList, (o1, o2) -> o2.getPosition() - o1.getPosition());

        int winnerPosition = participantList.get(0).getPosition();
        return winnerPosition;
    }

    public List<String> getWinner(List<Car> participantList) {
        int winnerPosition = getWinnersPosition(participantList); // 게임 자체에서의 승자-패자를 구분하는 규칙 자체인데, RandomRaceRule에 있는게 맞을까요?

        List<String> winnerList = new ArrayList<>();
        for (Car car : participantList) {
            if (car.getPosition() == winnerPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

}
