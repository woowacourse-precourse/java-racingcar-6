package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.CarService;
import racingcar.view.UserInput;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자 입력값
        UserInput input = inputUser();
        CarService carService = new CarService(input);
        gameStart(carService); //게임 규격 생성
    }

    //전체 게임 횟수만큼 게임 반복 및 실행 start 기능
    static void gameStart(CarService carService) {
        int count = carService.input.gameCount;
        ArrayList<Car> carsList = carService.carList;
        //자동차 객체 임시 컨트롤
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < carsList.size(); j++) {
                //전진, 멈춤 판별
                boolean flag = carService.judgeRunOrStop();
                //판별된 상태에 따른 상태 세팅
                carService.setCurrentCar(flag, carsList.get(j));
            }
            //현재의 게임 객체들 상태 출력
            carService.printCurrentCar(carsList);
        }
        //모든 게임 완료된 상테에서 최종 우승자 가리기
        int winScore = carService.getMaxScore(carsList);
        ArrayList<String> winnerName = carService.getWinnerName(carsList, winScore);
        System.out.println("이긴 사람");
        for (int i = 0; i < winnerName.size(); i++) {
            System.out.print(winnerName.get(i) + ", ");
        }
    }

    //1) 사용자 입력 처리 기능
    static UserInput inputUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = Integer.parseInt(Console.readLine());

        return new UserInput(carName, gameCount);
    }
}

