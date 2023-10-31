package racingcar.vo;

import racingcar.exception.RacingCarError;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<Car> cars = new ArrayList<>();
    private Integer times = 0;

    public void setCarNames() {

        String input = "";
        List<String> names = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        try {
            input = br.readLine();
        } catch (Exception e) {
            new IllegalArgumentException(RacingCarError.NOT_VALID_INPUT.getMsg());
        }

        names = List.of(input.split(","));

        for (int i = 0; i < names.size(); i++) {
            this.cars.add(new Car(names.get(i)));
        }

    }


}
