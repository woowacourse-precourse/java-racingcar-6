package racingcar.controller;

import racingcar.DTO.CarDTO;
import racingcar.model.Car;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView INPUT_VIEW;
    private final OutputView OUTPUT_VIEW;
    private List<Car> cars;
    private int totalRoundCount;

    public GameController(InputView INPUT_VIEW, OutputView OUTPUT_VIEW) {
        this.INPUT_VIEW = INPUT_VIEW;
        this.OUTPUT_VIEW = OUTPUT_VIEW;
    }

    public void setupGame() {
        List<String> carNames = INPUT_VIEW.inputName();
        List<Car> cars = createCars(carNames);
        setCars(cars);

        int inputNumber = INPUT_VIEW.inputNumber();
        setTotalRoundCount(inputNumber);
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    public Round createRound() {
        return new Round();
    }

    public List<List<CarDTO>> play() {
        // 현재 라운드 및 결과를 저장하는 변수 초기화
        Round currentRound;
        List<CarDTO> currentRoundResult;
        List<List<CarDTO>> EachRoundResult = new ArrayList<>();

        // 게임 시작 메시지 출력
        OUTPUT_VIEW.printPlayStart();

        // 전체 라운드 진행
        while (Round.getCurrentRoundCount() < totalRoundCount) {
            // 새 라운드 생성
            currentRound = createRound();

            // 라운드 시작 및 종료
            currentRound.startRound(cars);
            currentRound.endRound();

            // 라운드 결과 생성 및 저장
            currentRoundResult = currentRound.generateResult(cars);
            EachRoundResult.add(currentRoundResult);

            // 현재 라운드 결과 출력
            OUTPUT_VIEW.printRoundResult(currentRoundResult);
        }

        // 모든 라운드 종료 후 우승한 자동차 정보 추출
        List<CarDTO> finalRoundResult = Round.calculateFurthestCarInfo(EachRoundResult);

        // 최종 우승자 출력
        toOutputView(finalRoundResult);

        return EachRoundResult;
    }

    public void toOutputView(List<CarDTO> finalRoundResult) {
        OUTPUT_VIEW.printWinner(finalRoundResult);
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setTotalRoundCount(int totalRoundCount) {
        this.totalRoundCount = totalRoundCount;
    }
}
