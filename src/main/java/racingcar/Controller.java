package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.ExceptionHandler.run_ExceptionHandler;
import static racingcar.Input.*;
import static racingcar.View.*;
import static racingcar.Winner.whoIsTheWinner;

public class Controller {

    List<Car> cars = new ArrayList<>();
    Input input = new Input();

    public Controller() {
    }

    public void run() {
        PRINT_START_GAME();
        inputAllValues();

        run_ExceptionHandler();

        makeCarList();

        PRINT_RESULT(); //실행 결과
        race();
        getWinnerName();
    }

    public void inputAllValues() {
        input.inputCarNames();
        PRINT_HOW_MANY_TRY();
        inputN();
    }

    //분할된 자동차 이름으로 Car 객체 생성해야해
    public void makeCarList() {
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(i, new Car(carNames.get(i)));
        }
    }

    public void race() {
        for (int i = 0; i < getN(); i++) {
            allCarGoStop();
            PRINT_RUN_RESULT(cars); //이름 : - 출력
        }
    }

    private void allCarGoStop() {
        for (int j = 0; j < cars.size(); j++) {
            cars.get(j).GoStop(); //자동차 별로 count 증가
        }
    }

    public void getWinnerName() {
        String winner = whoIsTheWinner(cars);
        PRINT_REPORT_WINNER(winner);
    }
}
