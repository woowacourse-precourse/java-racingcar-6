package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Racing {

    CreateCar createCar = new CreateCar();
    int carCount = createCar.carCount(createCar.carName(createCar.input()));
    String[] carName = createCar.carName(createCar.input());

    RacingRound racingRound = new RacingRound();
    int attemptCount = racingRound.attemptCount();

    Forward forward = new Forward();

    // 입력 받기
    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    // 실행 결과
    public String racing() {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            for (int j = 0; j < carCount; j++) {
                if (forward.canForward()) {
                    System.out.println(carName[j] + " : " + "-");
                } else {
                    System.out.println(carName[j] + " : " + "");
                }
            }
            System.out.println();
        }
        return null;
    }

    // TODO: 경주 상태  나타내기
    public Map<String, Integer> state(String[] carName) {
        Map<String, Integer> raceState = null;
        for (int i = 0; i < carName.length; i++) {
            raceState.put(carName[i], 0);
        }
        return raceState;
    }


    // TODO:  우승자 출력
//


}
