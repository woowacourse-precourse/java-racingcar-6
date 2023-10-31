package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class RacingGameManager {
    private List<Car> carList;
    private Long racingTry;

    /**
     * 자동차 경주 진행 함수
     * 입력: 없음
     * 출력: 없음
     */
    public void gameManager() {
        Validator validator = new Validator();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (validator.validate(input)) {
            // 사용자의 입력값이 유효할 경우 ','를 기준으로 경주 자동차 이름 분리 후 객체 추가
            carList = new ArrayList<>();
            Arrays.asList(input.split((","))).forEach(
                    carName -> carList.add(new Car(carName))
            );
            System.out.println("시도할 회수는 몇회인가요?");
        }

        input = Console.readLine();
        if (validator.validate(input))
            // 사용자의 입력값이 유효할 경우 시도 회수 초기화
            this.racingTry = Long.parseLong(input);

        for (int i = 0; i < racingTry; i++) {
            System.out.println("\n실행 결과");
            moveCar();
            showCarMoveResult();
        }

        System.out.println("\n최종 우승자 : " + String.join(", ", getWinnerList()));
    }

    /**
     * 자동차 이동 함수
     * 입력: 없음
     * 출력: 없음
     */
    private void moveCar() {
        for (Car car : carList) {
            // 사용자의 입력값이 4보다 클 경우 이동
            if (Randoms.pickNumberInRange(0,9) >= 4)
                car.increaseMove();
        }
    }

    /**
     * 자동차 이동 결과 표시 함수
     * 입력: 없음
     * 출력: 없음
     */
    private void showCarMoveResult() {
        for (Car car : carList)
            System.out.println(car.getName() + " : " + "-".repeat(car.getMove().intValue()));
    }

    /**
     * 우승자 확인 함수
     * 입력: 없음
     * 출력: List<String>(우승자의 이름을 담은 리스트)
     */
    private List<String> getWinnerList() {
        // Car 객체의 move를 기준으로 오름차순 정렬
        carList.sort(Comparator.comparingLong(Car::getMove));

        // carList에서의 가장 큰 move값 저장
        Long max = carList.get(carList.size()-1).getMove();
        int sameMoveIndex = carList.size()-1;
        // 가장 큰 move값이 여러개일 시를 고려하여 리스트 방문
        while (sameMoveIndex >= 0 && max == carList.get(sameMoveIndex).getMove()) {
            sameMoveIndex--;
        }

        List<String> winnerList = new ArrayList<>();
        // 승자 리스트에 최고값을 가진 Car 객체들의 이름 추가
        carList.subList(sameMoveIndex+1, carList.size()).forEach(
                car -> winnerList.add(car.getName())
        );

        return winnerList;
    }
}
