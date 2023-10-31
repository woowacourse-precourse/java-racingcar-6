package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void inputCars() {

        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        //자동차 이름 입력
        String inputCars = readLine();
        //쉼표로 구분
        String[] car = inputCars.split(",");

        int carNum = car.length;

        //5자 이하만 가능하도록 제한
        for(String name : car) {
            if(name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }

        //횟수 입력
        System.out.println("시도할 횟수를 입력하세요.");
        int num = Integer.parseInt(readLine());

        //조건 확인합니다. 자동차는 두 대 이상이어야 승부가 가능하고, 시도할 횟수도 1회 이상이어야 한다.
        if(carNum < 2 || num < 1){
            throw new IllegalArgumentException();
        }

    }

    
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //입력
        inputCars();

        //경주 시작
        start();


    }


    // 0.자동차 이름과 이동 횟수를 입력한다.

}
