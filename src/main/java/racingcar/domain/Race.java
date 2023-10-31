package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {

    private static final int CONDITION_RANDOM_VALUE = 4;
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
        String[] carNames = inputCarNames.split(",");
        enrollCars(carNames); // 차량 정보 등록하기

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTrial = Console.readLine();
        int trial = Integer.parseInt(inputTrial); // String -> int 변경

        System.out.println("실행 결과");
        for (int i = 0; i < trial; i++) {
            for (Car car : cars) {
                startRace(car);
            }
            System.out.println();
        }
        referee.announceWinner(scoreBoard);
    }

    public void enrollCars(String[] carNames) {
        for (String carName : carNames) {
            if (inputValidation.checkName(carName)) {
                Car car = new Car(carName);
                cars.add(car);
            }
        }
        inputValidation.checkDuplicate(Arrays.asList(carNames));
    }

    public void startRace(Car car) {
        // 입력한 시도 횟수에 따른 경주 진행
        if (isAbleToMove()) {
            car.move();
        } else {
            car.stop();
        }
        scoreBoard.write(cars);
    }

    public boolean isAbleToMove() {
        int randomNumber = numberGenerator.createRandomNumber();
        return randomNumber >= CONDITION_RANDOM_VALUE;
    }
}
