package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingProgram {

    public void start() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carName;
        int count;
        carName = readLine();
        String[] carNameList = carName.split(",");
        //System.out.println(Arrays.toString(carNameList));

        CarRepository carRepository = new CarRepository();

        for (int i = 0; i < carNameList.length; i++) {
            Car car = new Car(carNameList[i]);
            carRepository.add(car);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        count = Integer.parseInt(readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            carRepository.setCarForward();
            carRepository.getCarStatus();
            System.out.println();
        }

        System.out.println("최종 우승자 : ");
    }
}
