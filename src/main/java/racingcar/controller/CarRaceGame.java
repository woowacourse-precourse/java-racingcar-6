package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.AllRaceRecords;
import racingcar.domain.Cars;
import racingcar.domain.MoveCnt;
import racingcar.model.CarMove;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGame {
    private InputView inputView;
    private OutputView outputView;
    private CarMove carMove;
    private Winner winner;

    public CarRaceGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carMove = new CarMove();
        this.winner = new Winner();
    }

    public void run() {
        Cars cars = getCarName();
        MoveCnt moveCnt = getMoveCnt();

        AllRaceRecords allRecords = race(cars, moveCnt);
        printWinner(allRecords, moveCnt);
    }

    private Cars getCarName() {
        inputView.requestCarName(); // 자동차 이름 요청 구문 출력
        Cars cars = new Cars(Console.readLine()); // 유저 입력문 쉼표로 구분해서 Car 리스트에 저장

        return cars;
    }

    private MoveCnt getMoveCnt() {
        inputView.requestMoveCnt(); // 시도할 횟수 요청 구문 출력
        MoveCnt moveCnt = new MoveCnt(Console.readLine());

        return  moveCnt;
    }

    private AllRaceRecords race(Cars cars, MoveCnt moveCnt) {
        outputView.printResultMsg(); // '실행 결과' 메세지 출력

        AllRaceRecords allRecords = carMove.race(cars, moveCnt);
        outputView.printRaceResult(allRecords, moveCnt); // 레이스 결과 출력

        return allRecords;
    }

    private void printWinner(AllRaceRecords allRecords, MoveCnt moveCnt) {
        outputView.printWinner(winner.selectWinner(allRecords, moveCnt));
    }


}
