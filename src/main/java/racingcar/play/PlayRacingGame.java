package racingcar.play;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Texts;
import racingcar.model.Winners;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class PlayRacingGame {

    private Cars cars;
    private int roundCount;
    private int maxCount;

    public PlayRacingGame() {
        roundCount = 0;
        maxCount = 0;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public void input() {
        System.out.println(Texts.STARTINPUT);
        String tmpName = Console.readLine();

        cars = new Cars(tmpName);
        inputNameException();

        System.out.println(Texts.TRYCOUNTINPUT);
        String tmpCount = Console.readLine();

        inputRoundCountException(tmpCount);

        roundCount = Integer.parseInt(tmpCount);
    }

    public void play() {
        System.out.println(Texts.EXCUTERESULT);
        Round round = new Round();
        for (int i = 0; i < roundCount; i++) {
            round.playRound(cars);
            round.printRound(cars);
            System.out.println();
        }
        maxCount = cars.getMaxCount();
    }

    public void printGameResult() {
        Winners winners = new Winners(cars, maxCount);
        winners.printWinners();
    }

    public void inputNameException() {
        for (Car car : cars.getCars()) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("이름을 5글자 이하로 입력하세요");
            }
            if (car.getName().isEmpty()) {
                throw new IllegalArgumentException("이름이 비어있을 수 없습니다.");
            }
        }
    }

    public void inputRoundCountException(String roundCount) {
        if (roundCount.isEmpty()) {
            throw new IllegalArgumentException("round 수를 입력하세요");
        }
        if (Integer.parseInt(roundCount) < 0) {
            throw new IllegalArgumentException("음수일수 없습니다");
        }
    }
}
