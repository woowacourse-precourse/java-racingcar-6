package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.verifier.CarNameVerifier;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    private GameData gameData;
    private List<Car> cars;
    public void startGame() {
        initializeGameData();
        initializeCars();
        OutputView.printResultMsg();
        while (!gameData.isRacesFinished()) {
            playSingleRace();
            gameData.nextRound();
            OutputView.printRoundResultMsg(cars);
        }
        printWinners();
    }

    // GameDate 초기화
    private void initializeGameData() {
        String carNamesInput = InputView.receiveCarNames();
        new CarNameVerifier(carNamesInput);
        String[] carNames = carNamesInput.split(",");
        int tryCount = Integer.parseInt(InputView.getRound());
        gameData = new GameData(carNames, tryCount);
    }
    // Cars 초기화.
    private void initializeCars() {
        cars = new ArrayList<>();
        for (String name : gameData.getCarNames()) {
            cars.add(new Car(name.trim()));
        }
    }

    // 한 라운드를 진행
    private void playSingleRace() {
        int randomRoundValue;

        for (Car car : cars) {
            randomRoundValue = Randoms.pickNumberInRange(0, 9); //0 ~ 9 사이의 랜덤한 값을 생성
            if (randomRoundValue >= 4) {  //4이상이면 전진.
                car.move();
            }
        }
    }
    // 최고로 많이 전진한 Position 찾은 후 maxPosition Car 객체의 List 반환
    private List<Car> findWinners() {
        //스트림으로 Car 객체들을 스트림으로 변환 후 각 스트림에 대해 getPosition 메서드를 호출하여 Position 매핑
        // 그 후 매핑 된 값들 중 최대값 출력
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
        //filter 통과한 객체들만 return
        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    // 최종 우승자 출력
    private void printWinners() {
        List<Car> winners = findWinners();
        OutputView.printWinners(winners);
    }


}