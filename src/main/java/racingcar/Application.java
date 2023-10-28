package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.print("경주 할 자동차의 이름을 입력해주세요(이름은 쉼표(,) 기준으로 구분): ");
        // car name 메소드 나누기
        String carNameInput = Console.readLine();
        String[] carNameList = carNameInput.split(",");
        ArrayList<Car> CarList = new ArrayList<>();

        for (String carName :
                carNameList) {
            if (carName.length() > 5) {
                throw new IllegalStateException("자동차의 이름이 5자리 이상입니다.");
            }
            // car 객체 생성
            CarList.add(new Car(carName));
        }

        // 시도 횟수 입력
        System.out.print("시도 할 횟수를 입력해주세요 : ");
        String tryingNumberString = Console.readLine();
        int tryingNumber = Integer.parseInt(tryingNumberString);
        System.out.println();
        System.out.println("실행 결과");
        for (int k = 0; k < tryingNumber; k++) {
            // car 문자열 출력
            for (int i = 0; i < CarList.size(); i++) {

                // random 값 생성
                int randomNum = Randoms.pickNumberInRange(0, 9);
                if (randomNum > 3) {
                    CarList.get(i).addDistance();
                }
                // 출력
                String carString = CarList.get(i).carString();
                System.out.println(carString);
            }
            System.out.println();
        }
        int max = 0;
        // 게임 종료 후 우승자를 가림
        for (int i = 0; i < CarList.size(); i++) {
            max = CarList.get(0).getDistance().length();
            if (CarList.get(i).getDistance().length() > max) {
                max = CarList.get(i).getDistance().length();
            }
        }
        ArrayList<String> winners = new ArrayList<>();
        for (int i = 0; i < CarList.size(); i++) {
            if (max == CarList.get(i).getDistance().length()) {
                winners.add(CarList.get(i).getName());
            }
        }
        System.out.print("최종 우승자 : ");
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(winners.get(i-1) + ", ");
        }
        System.out.print(winners.get(winners.size()-1));

    }
}
