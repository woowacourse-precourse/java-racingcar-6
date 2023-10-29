package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racing {

    // 입력 받기
    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    // 실행 결과
    public String racing() {
        System.out.println("실행 결과");
        CreateCar createCar = new CreateCar();
        int carCount = createCar.carCount(createCar.carName(createCar.input()));
        String[] carName = createCar.carName(createCar.input());

        RacingRound racingRound = new RacingRound();
        int attemptCount = racingRound.attemptCount();

        for (int i = 0; i < attemptCount; i++) {
            for (int j = 0; j < carCount; j++) {
                Forward forward = new Forward();
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
    // 우승자 출력
    public String winner() {
        System.out.println("최종 우승자: pobi");
        return null;
    }

//    public void result() {
//        System.out.println("실행 결과");
//        CreateCar createCar = new CreateCar();
//        int carCount = createCar.carCount(createCar.carName(createCar.input()));
//        String[] carName = createCar.carName(createCar.input());
//
//        RacingRound racingRound = new RacingRound();
//        int attemptCount = racingRound.attemptCount();
//
//        for (int i = 0; i < attemptCount; i++) {
//            for (int j = 0; j < carCount; j++) {
//                Forward forward = new Forward();
//                if (forward.canForward()) {
//                    System.out.println(carName[j] + " : " + "-");
//                } else {
//                    System.out.println(carName[j] + " : " + "");
//                }
//            }
//            System.out.println();
//        }
//    }
}
