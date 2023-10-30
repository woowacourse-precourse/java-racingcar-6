package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /*2주 차 미션에서는 1주 차에서 학습한 것에 더해 함수를 분리하고,
        각 함수별로 테스트를 작성하는 것에 익숙해지는 것을 목표로 하고 있어요.
        이번에 테스트를 처음 접하시는 분들은 언어별 테스트 도구를 학습하고
        작은 단위의 기능부터 테스트를 작성해보길 바랍니다.
        과제를 제출할 때 이번 주 차 목표를 중심으로 학습하면서 느낀 점을 소감문으로 작성해 주세요.
        이때 학습한 '과정’을 잘 드러내 주세요.*/

        String userInputCarsNames;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        //1. 자동차 이름 입력, 확인, 초기에 이동 횟수 0으로
        userInputCarsNames = Console.readLine();
        UserCar userCar = new UserCar(userInputCarsNames);

        //2. 진행 횟수 입력
        Integer userAttemptNums;
        System.out.println("시도할 회수는 몇회인가요?");
        userAttemptNums = Integer.parseInt(Console.readLine());
        System.out.println(userAttemptNums);

        //3. race 진행
        Race carRace=new Race(userCar.Cars);
        for(int i=0;i<userAttemptNums;i++){
            carRace.forwardInRace();
            carRace.printAllCarAndAdvance();
        }
        carRace.findWinner();
        carRace.printWinner();



    }
}
