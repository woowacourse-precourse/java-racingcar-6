package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Service service = new Service();

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        // car name 메소드 나누기
        String carNameInput = Console.readLine();
        String[] carNameList = carNameInput.split(",");
        ArrayList<Car> carList = new ArrayList<>();

        for (String carName :
                carNameList) {
            if (carName.length() > 5) {
                throw new IllegalStateException("자동차의 이름이 5자리 이상입니다.");
            }
            // car 객체 생성
            carList.add(new Car(carName));
        }

        // 시도 횟수 입력
        System.out.print("시도할 회수는 몇회인가요? : ");
        String tryingNumberString = Console.readLine();
        int tryingNumber = Integer.parseInt(tryingNumberString);
        System.out.println();
        System.out.println("실행 결과");
        for (int k = 0; k < tryingNumber; k++) {
            service.carDistancePrint(carList);
        }
        service.findWinner(carList);

    }
}
