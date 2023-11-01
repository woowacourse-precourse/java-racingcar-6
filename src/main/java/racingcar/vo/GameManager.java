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
    private Integer times = 0;

    public void setGame() {

        List<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        input();

        names = List.of(this.input.split(","));
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

    private void setTimes() {

        this.times = Integer.parseInt(this.input);

    }

    private void input() {

        try {

            this.input = br.readLine();

        } catch (Exception e) {

            throw new IllegalArgumentException(RacingCarError.NOT_VALID_INPUT.getMsg());

        }

    }


    public void playGame() {

        for (int i = 0; i < this.times; i++) {

            for (int j = 0; j < this.cars.size(); j++) {

                this.cars.get(j).choiceActive();

            }

        }

    }

    public void announcementWinner() {

        StringBuilder sb = new StringBuilder();

        cars.sort(Comparator.comparing(Car::getPositionLength));

        sb.append("최종 우승자 : " + cars.get(cars.size() - 1).getName());

        for (int i = cars.size() - 1; i >= 0; i--) {

            Car nowCar = cars.get(i);
            Car prevCar = cars.get(i - 1);

            if (nowCar.getPositionLength() == prevCar.getPositionLength()) {

                sb.append(", " + prevCar.getName());

            } else {

                break;

            }

        }

        System.out.println(sb.toString());
    }
}
