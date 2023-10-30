package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import racingcar.handler.ExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private int moveCount;
    private List<Car> carList;
    private List<String> winnerList;

    private static String GET_CAR_NAME_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String GET_MOVE_COUNT_STRING = "시도할 회수는 몇회인가요?";
    private static String START_STRING = "실행 결과";
    private static String WINNER_TEMPLATE  = "최종 우승자 : ";

    private static String CAR_NAME_REGEX = "\\w{1,5}(,\\w{1,5})*";

    public Race() {
        init();
    }

    private void init() {
        carList = new ArrayList<Car>();
        winnerList = new ArrayList<String>();

        getCarNames();
        getMoveCount();
    }

    public void start() {
        System.out.println('\n' + START_STRING);
        while(moveCount != 0) {
            carList.forEach(car -> {
                car.move();
                System.out.println(car.status());
            });
            moveCount--;
            System.out.println();
        }

        checkWinner();
    }

    private void checkWinner() {
        int maxPosition = 0;

        for(Car car : carList) {
            if (car.getPostion() == maxPosition) {
                winnerList.add(car.getName());
            } else if(car.getPostion() > maxPosition) {
                maxPosition = car.getPostion();

                winnerList.clear();
                winnerList.add(car.getName());
            }
        }

        showWinner();
    }

    private void getCarNames() {
        System.out.println(GET_CAR_NAME_STRING);
        String carNamesString = Console.readLine();

        if(!carNamesString.matches(CAR_NAME_REGEX)) {
            ExceptionHandler.inputException();
        }

        Arrays.stream(carNamesString.split(",")).toList().forEach( carName -> {
            if(!carName.isEmpty()) {
                carList.add(new Car(carName));
            }
        });
    }

    private void getMoveCount() {
        System.out.println(GET_MOVE_COUNT_STRING);
        String moveCountString = Console.readLine();

        try {
            moveCount = Integer.parseInt(moveCountString);
        } catch (NumberFormatException ex) {
            ExceptionHandler.inputException();
        }
    }

    private void showWinner() {
        System.out.println(WINNER_TEMPLATE + String.join(",", winnerList));
    }
}
