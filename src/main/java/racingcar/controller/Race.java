package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.AllRaceRecords;
import racingcar.domain.Cars;
import racingcar.domain.MoveCnt;
import racingcar.model.CarMove;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private InputView inputView;
    private OutputView outputView;
    private CarMove carMove;
    private MoveCnt moveCnt;
    private Cars cars;
    private Winner winner;

    public Race() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carMove = new CarMove();
        this.winner = new Winner();
    }

    public void run() {
        gameStart();
        race();
    }

    private void gameStart() {
        inputView.requestCarName(); // 자동차 이름 요청 구문 출력
        cars = new Cars(Console.readLine()); // 유저 입력문 쉼표로 구분해서 Car 리스트에 저장

        inputView.requestMoveCnt(); // 시도할 횟수 요청 구문 출력
        moveCnt = new MoveCnt(Console.readLine());
    }

    private void race() {
        outputView.printResultMsg(); // '실행 결과' 메세지 출력

        AllRaceRecords allRecords = carMove.race(cars, moveCnt);
        outputView.printRaceResult(allRecords, moveCnt); // 레이스 결과 출력

        printWinner(allRecords, moveCnt);
    }

    private void printWinner(AllRaceRecords allRecords, MoveCnt moveCnt) {
        outputView.printWinner(winner.selectWinner(allRecords, moveCnt));
    }


}
