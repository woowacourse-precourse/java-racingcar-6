package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarNames;

public class GameWinner {
    /*
     * 우승자의 정보를 담당
     * */
    private static final int STRING_BEGIN_INDEX = 0;
    private static final int NOT_USED_LENGTH = 2;
    private List<Car> winners = new ArrayList<>();

    public GameWinner(List<Car> gameWinners) {
        this.winners = gameWinners;
    }

    private void addGameWinners(Car car, int bestRecord) {
        if (car.isEqualRecord(bestRecord)) {
            winners.add(car);
        }
    }

    public String namesToString() {
        //변수명 다시 생각해보기 message
        StringBuilder message = new StringBuilder();
        CarNames carNames = createCarNames();
        for (String carName : carNames.getCarNames()) {
            //append 함수 알아보기
            message.append(carName).append(", ");
        }
        return message.substring(STRING_BEGIN_INDEX, message.length() - NOT_USED_LENGTH).toString();
    }

    private CarNames createCarNames() {
        CarNames carNames = new CarNames();
        for (Car gameWinner : winners) {
            gameWinner.intoCarNames(carNames);
        }
        return carNames;
    }
}
