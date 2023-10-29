package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void game() throws IllegalArgumentException {

        //사용자에게 입력값 (경주할 자동차 이름, 게임을 시도할 회수) 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String stringCars = readLine();
        List<String> cars = List.of(stringCars.split(","));

        //입력값이 5자 이하인지 확인
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String stringNumberOfGames = readLine();

        //입력값이 숫자인지 확인
        try {
            int numberOfGames = Integer.parseInt(stringNumberOfGames);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }




    }

    public static void main(String[] args) {
        game();
    }
}
