package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.MoveCnt;
import racingcar.model.CarMove;
import racingcar.model.CarName;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Race {
    private InputView inputView;
    private OutputView outputView;
    private CarName carName;
    private CarMove carMove;
    private List<Car> cars;
    private MoveCnt moveCnt;
    private Winner winner;
    private List<List<Car>> allRaceResultList;

    public Race() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carName = new CarName();
        this.carMove = new CarMove();
        this.winner = new Winner();
    }

    public void run() {
        start();
        move();
        printWinner();
    }

    public void start() {
        inputView.requestCarName(); // 자동차 이름 요청 구문 출력
        cars = carName.splitUserInputCarName(Console.readLine()); // 유저 입력문 쉼표로 구분해서 Car 리스트에 저장

        inputView.requestMoveCnt(); // 시도할 횟수 요청 구문 출력
        moveCnt = new MoveCnt(Console.readLine());
    }

    public void move() {
        outputView.printResultMsg(); // '실행 결과' 메세지 출력

        allRaceResultList = carMove.race(cars, moveCnt); // 모든 레이스 실행 결과 각각 담고있는 리스트
        for (List<Car> raceResult : allRaceResultList) { // 각각 실행 결과 출력
            outputView.printEachRaceResult(raceResult);
        }

    }

    public void printWinner() {
        outputView.printWinner(winner.selectWinner(allRaceResultList.get(allRaceResultList.size() - 1)));
    }


}
