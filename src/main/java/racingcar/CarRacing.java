package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String INPUT_TIMES_MESSAGE = "시도할 회수는 몇회인가요?";
    static final String RESULT_MESSAGE = "실행 결과";
    static final String WINNER_MESSAGE = "최종 우승자 : ";

    List<Car> cars = new ArrayList<Car>();
    int times;

    public void start() {
        setCars();
        setTimes();
        
        progress();
        showWinners();
    }

    private void showWinners() {
        System.out.println(WINNER_MESSAGE + getWinners());
    }

    private String getWinners() {
        int maxPosition = getMaxPosition(this.cars);

        String winners = "";

        for (Car car : this.cars) {
            if (car.getPosition() < maxPosition) {
                continue;
            }

            if (!winners.equals("")) {
                winners += ", ";
            }

            winners += car.getName();
        }

        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    private void progress() {
        System.out.println(RESULT_MESSAGE);

        for (int i = 0; i < this.times; i++) {
            for (Car car : this.cars) {
                car.move();
                car.showPosition();
            }
            System.out.println();
        }
    }

    private void setTimes() {
        this.times = getTimes();
    }

    private int getTimes() {
        System.out.println(INPUT_TIMES_MESSAGE);
        String input = Console.readLine();

        validateTime(input);

        return Integer.parseInt(input.trim());
    }

    private void validateTime(String input) {
        if (checkInputEmpty(input)) {
            throw new IllegalArgumentException();
        }

        if (!checkInputNumber(input)) {
            throw new IllegalArgumentException();
        }

        if (checkInputNegativeNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkInputNegativeNumber(String input) {
        return Integer.parseInt(input) < 0;
    }

    private boolean checkInputNumber(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void setCars() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String[] carNames = Console.readLine().split(",");

        for (int i = 0; i < carNames.length; i++) {
            validateName(carNames[i]);
            cars.add(new Car(carNames[i].trim()));
        }

    }

    private void validateName(String carName) {
        if (checkInputEmpty(carName)) {
            throw new IllegalArgumentException();
        }

        if (checkInputLength(carName)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkInputLength(String carName) {
        return carName.length() > 5;
    }

    private boolean checkInputEmpty(String input) {
        return input.equals("");
    }
}
