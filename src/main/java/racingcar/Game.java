package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    public void gameStart() {
        InputValidation inputValidation = new InputValidation();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsName = Console.readLine();

        //자동차들 입장
        Cars cars = new Cars(carsName);

        System.out.println("시도할 회수는 몇회인가요?");
        String tryInput = Console.readLine();

        //tryInput validation 체크
        Integer tryIndex = inputValidation.tryInputNumberValidate(tryInput);

        //게임 전광판에 띄워 게임 진행 출력
        GameBoard gameBoard = new GameBoard(cars, tryIndex);
        gameBoard.viewGamePlaying();

        //최종 우승자 출력
        gameBoard.viewGameWinner();
    }
}
