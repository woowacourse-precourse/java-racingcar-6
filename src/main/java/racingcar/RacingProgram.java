package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingProgram {

    public void start() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carName;
        int count;
        carName = readLine();
        String[] carNameList = carName.split(",");

        CarRepository carRepository = new CarRepository();

        for (int i = 0; i < carNameList.length; i++) {
            Car car = new Car(carNameList[i]);
            carRepository.add(car);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        try {
            count = Integer.parseInt(readLine());
            if (count < 1) {
                throw new IllegalArgumentException("정상적인 회수를 입력하세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 회수는 숫자 입력만 가능합니다.");
        }

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            carRepository.setCarForward();
            carRepository.getCarStatus();
            System.out.println();
        }

        carRepository.getWinner();
    }
}
