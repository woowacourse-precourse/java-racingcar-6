package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RequestRacing {

    public RacingInfo createRacingInfo() {
        return new RacingInfo(requestCarNames(), requestRacingTimes());
    }

    private String[] requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        validationCarNames(carNames);
        return carNames;
    }

    private int requestRacingTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String racingTimes = Console.readLine();
        validationRacingTimes(racingTimes);
        return Integer.parseInt(racingTimes);
    }

    public void validationCarNames(String[] names) {
        for (String name : names) {
            String temp = name.replace(" ", "");
            if (temp.length() > 5 || temp.length() == 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validationRacingTimes(String times) {
        try {
            Integer.parseInt(times);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
