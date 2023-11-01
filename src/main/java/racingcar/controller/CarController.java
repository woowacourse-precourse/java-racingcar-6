package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.model.Cars;
import racingcar.model.Car;
import racingcar.util.Validate;
import racingcar.view.Input;
import racingcar.view.Output;

public class CarController {
    private static final String delimiter = ",";
    private Input input;
    private Output output;
    private Cars cars;

    public CarController() {
        this.input = new Input();
        this.output = new Output();
    }

    public void racing() {
        try {
            // 자동차 이름들 입력 및 유효성 검사
            String inputCars = input.promptForCarNames();
            Validate.inputIsNull(inputCars);

            // 입력받은 자동차 이름들을 Cars 변환
            cars = inputCarsStringToCarsClass(inputCars);

            String tempForwardAttempt = inputForForwardAndReturnStringType();
            int forwardAttempt = forwardStringToInteger(tempForwardAttempt);

            output.resultHeader();

            // 입력 받은 시도횟수만큼 전진 반복하며 결과 출력
            attemptForwardAndOutputResult(forwardAttempt, cars);

            String winner = getWinner(cars);

            output.winners(winner);
        } finally {
            Console.close();
        }
    }

    public String getWinner(Cars cars) {
        int max = cars.getMaxPosition();

        List<String> winner = cars.getWinner(max);

        return String.join(", ", winner);
    }

    /**
     * 입력받은 자동차들 String -> Cars 변환
     *
     * @param inputTemp : 입력받은 자동차들
     * @return : Cars Class
     */
    private Cars inputCarsStringToCarsClass(String inputTemp) {
        Validate.inputStringNotContainsComma(inputTemp); // 구분자가 컴마가 아닌 경우 유효성 검사
        Validate.lastCharIsComma(inputTemp); // 구분자 뒤 자동치 이름이 없는 경우 유효성 검사

        List<String> carList = splitCarNamesReturnList(inputTemp); // , 를 기준으로 구분하여 List<String> 생성

        return stringListToCarsModel(carList);
    }

    private List<String> splitCarNamesReturnList(String carMembers) {
        return Arrays.asList(carMembers.split(delimiter));
    }

    private Cars stringListToCarsModel(List<String> carList) {
        List<Car> cars = new ArrayList<>();

        for (String name : carList) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    // 시도횟수 console 입력 및 유효성 검사
    private String inputForForwardAndReturnStringType() {
        String attemptsForward = input.promptForAttempts();

        Validate.inputIsNull(attemptsForward);

        return attemptsForward;
    }

    // 입력받은 시도 횟수 String -> int 변환
    private int forwardStringToInteger(String move) {
        int result = Validate.forwardIsNumericAndReturnInteger(move);

        Validate.forwardIsPositiveNumber(result);

        return result;
    }



    private void attemptForwardAndOutputResult(int forwardAttempt, Cars cars) {
        // 전진 시도 횟수만큼 전진
        for (int forward = 0; forward < forwardAttempt; forward++) {

            // 각 자동차들 마다 랜덤으로 생성한 값이 4 이상인 경우 전진
            cars.forward();

            // 전진이 완료된 이후 현재 위치 정보 출력
            forwardResultOutput(cars);

            // 각 자동차들의 위치 정보가 모두 출력 되면 줄만 하나 출력
            System.out.println();
        }
    }

    private void forwardResultOutput(Cars cars) {
        cars.getCars()
                .stream()
                .forEach(car -> output.position(car.getForwardPosition()));
    }
}
