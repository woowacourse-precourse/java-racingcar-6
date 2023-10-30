package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Referee;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Referee referee = new Referee();
        referee.notifyInsertCars();
        referee.setCars(Console.readLine());
    }
}
