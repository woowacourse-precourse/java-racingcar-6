package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    //1. 자동차 이름 적기(쉼표(,)를 기준으로 구분하며 이름은 5자 이하만)
    //2. 시도할 횟수 적기
    //3. 만약 잘못 입력하면 에러 발생 후 종료(예외처리1,2,3)
    //4. 처음 시작 위치는 0부터 시작이고 시도 횟수까지만 실행
    //5. 전진하는 조건이 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우에만 전진, 4 미만이면 정지
    //6. 시도 횟수 만큼 실행하고 마지막에 가장 많이 전진한 자동차를 선정(최대 값으로 뽑으면 되겠지?) 그런데 만약 최대 값이 여러 명이면 같이 우승자로 선정
    //7. 우승자가 한명이면 한명 만 출력 여러 명이면 쉼표(,)를 사용하여 출력


    //2차 리팩토링 해야 할 것
    //1. 우승자 컨마 지우기
    //2. 코드 간소화-> 함수로 모듈화
    //3. 예외처리를 Exeption클래스로 묶어서 각각 예외처리마다 하나의 함수로 구현
    //4. 제어문 2개 이하로 수정

    public static void main(String[] args) {

        System.out.println("자동차 이름을 쉼표(,)로 구분하여 입력하세요:");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        int n = carNames.length;

        //(예외 처리1)
        ExeptionProcess Exception = new ExeptionProcess();
        for (String name : carNames) {
            if (!Exception.isValidCarName(name)) {
                throw new IllegalArgumentException("유효 하지 않은 자동차 이름: " + name);
            }
        }

        //(예외 처리2)입력된 자동차 이름의 길이가 5 이하 인지 검사
        for (String carName : carNames) {
            if (carName.replaceAll("\\s", "").length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다: " + carName);
            }
        }

        //Car클래스에 입력 값으로 초기화
        Car[] car = new Car[n];

        for(int i =0; i< car.length; i++) {
            car[i] = new Car(carNames[i]);
        }

        System.out.println("시도할 회수를 입력하세요:");
        String tryCountInput = Console.readLine();

        //(예외 처리3)
        Exception.isInputDataInteger(tryCountInput);
        int tryCount = Integer.parseInt(tryCountInput);

        //실행 결과값 출력
        System.out.println("실행 결과");
        for(int j=0; j<tryCount; j++)
        {
            //차1,차2,차3의 거리
            for (int i =0; i< car.length; i++) {
                int distance = Randoms.pickNumberInRange(0, 9);
                car[i].move(distance);
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        //우승자 발표

        //1, 단독 우승인지, 2명이상 공동 우승인지 구분을 해야한다
        //2. 어떻게 구분을 지을지  최대값?으로 구분을 지을까
        //3. 단독이면 그이름 한명만 출력 공동이면 공동 우승한 사람 다 출력
        int max=0;
        for (int i = 0; i < n; i++) {
            if (car[i].position > max) {
                max = car[i].position;
            }
        }
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < n; i++) {
            if (car[i].position == max) {
                System.out.print(car[i].name + ", ");
            }

        }
    }
}