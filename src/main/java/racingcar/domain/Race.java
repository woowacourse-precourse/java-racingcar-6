package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Race {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final InputValidation inputValidation = new InputValidation();
    private final List<Car> cars = new ArrayList<>();
    private final ScoreBoard scoreBoard = new ScoreBoard();
    private final Referee referee = new Referee();

    public Race() {
    }

    public void setRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputCarNames = Console.readLine();
        enrollCars(inputCarNames); // 차량 정보 등록하기

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTrial = Console.readLine();

        if (inputValidation.checkTrial(inputTrial)) {
            int trial = Integer.parseInt(inputTrial); // String -> int 변경
            startRace(trial); // 경주 시작
        }
    }

    public void enrollCars(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            if (inputValidation.checkName(carName)) {
                Car car = new Car(carName);
                cars.add(car);
            }
        }
        inputValidation.checkDuplicate(Arrays.asList(carNamesArray));
    }

    private void startRace(int trial) {
        System.out.println("실행 결과");
        for (int i = 0; i < trial; i++) {
            for (Car car : cars) {
                int fuel = numberGenerator.createRandomNumber();
                car.moveOrStop(fuel);
            }
            System.out.println();
        }
        Map<String, Integer> raceResult = scoreBoard.write(cars);
        List<String> winners = referee.findWinners(raceResult);
        referee.announceWinner(winners);
    }
}
