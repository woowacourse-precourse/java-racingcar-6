package racingcar.view;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.domain.CarService;

public class Output {
    public CarService carService;

    public Output(CarService carService) {
        this.carService = carService;
    }

    /**
     * 결과 출력과 관련된 함수
     */
    //++현재 상태를 출력하는 함수
    public void printCurrentCar(ArrayList<Car> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).carName + " : ");
            for (int j = 0; j < list.get(i).count; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    //++최종 우승자를 출력하는 함수
    public void printFinalWinner(ArrayList<Car> carsList) {
        //모든 게임 완료된 상테에서 최종 우승자 가리기
        int winScore = carService.getMaxScore(carsList);
        ArrayList<String> winnerName = carService.getWinnerName(carsList, winScore);
        System.out.print("최종 우승자 : ");

        String result = String.join(", ", winnerName);
        System.out.println(result);
    }
}
