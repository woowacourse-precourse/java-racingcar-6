package racingcar;

import inAndOut.Input;
import racingcar.car.CarList;
import racingcar.racing.Racing;
import racingcar.racing.WinnerCheck;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // 사용자 입력
        Input input = new Input(scanner);
        input.setInput();
        // 자동차 리스트 생성
        CarList carList = new CarList(input.getCarNames());
        //경주시작
        Racing racing = new Racing(carList);
        racing.raceStart(input.getCount());
        // 우승자 발표
        WinnerCheck winnerCheck = new WinnerCheck(carList.getCarList());
        winnerCheck.getWinner();
    }
}
