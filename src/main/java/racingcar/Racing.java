package racingcar;

public class Racing {

    // 입력 받기
    // 실행 결과
    // 우승자 출
    public void result() {
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
    }
}
