package racingcar.vo;

import racingcar.exception.RacingCarError;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameManager {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<Car> cars = new ArrayList<>();
    private String input = "";

    public void setGame() {

        List<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        input();

        names = List.of(input.split(","));
        setCarName(names);


        System.out.println("시도할 회수는 몇회인가요?");
        input();
        setTimes();

    }

    private void setCarName(List<String> names) {

        for (int i = 0; i < names.size(); i++) {

            this.cars.add(new Car(names.get(i)));

        }

    }

    private Integer setTimes() {

        return Integer.parseInt(input);

    }

    private void input() {
        try {

            input = br.readLine();

        } catch (Exception e) {

            new IllegalArgumentException(RacingCarError.NOT_VALID_INPUT.getMsg());

        }
    }


    public void playGame(Integer times) {

        for (int i = 0; i < times; i++) {

            for (int j = 0; j < this.cars.size(); j++) {

                cars.get(j).choiceActive();

            }

        }

    }

}
