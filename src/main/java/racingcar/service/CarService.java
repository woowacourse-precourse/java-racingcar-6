package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public void playGame(List<Car> carsList, int count) {
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            goAheadIfRandomNumberGtThree(carsList);
            printGameResultPerOneGame(carsList);
        }

        List<Car> winnerList = pickWinner(carsList);
        printWinnerPerGame(winnerList);
    }

    private static void goAheadIfRandomNumberGtThree(List<Car> carsList) {
        for (int j = 0; j < carsList.size(); j++) {
            Car car = carsList.get(j);
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.goAhead();
            }
        }
    }

    private void printGameResultPerOneGame(List<Car> carsList) {
        for (int j = 0; j < carsList.size(); j++) {
            Car car = carsList.get(j);
            System.out.print(car.getCarName() + " : ");
            for (int k = 0; k < car.getGoCount(); k++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private List<Car> pickWinner(List<Car> carsList) {
        int max = 0;
        for (int i = 0; i < carsList.size(); i++) {
            Car car = carsList.get(i);
            max = Math.max(max, car.getGoCount());
        }

        List<Car> winnerList = new ArrayList<>();
        for (int i = 0; i < carsList.size(); i++) {
            Car car = carsList.get(i);
            if (car.getGoCount() == max) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    private void printWinnerPerGame(List<Car> winnerList) {
        for (int i = 0; i < winnerList.size(); i++) {
            Car car = winnerList.get(i);
            System.out.print(car.getCarName() + " : ");
            for (int j = 0; j < car.getGoCount(); j++) {
                System.out.print("-");
            }
            System.out.print(" ");
        }

        printFinalWinner(winnerList);
    }

    private static void printFinalWinner(List<Car> winnerList) {
        System.out.print("최종 우승자 : ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < winnerList.size(); i++) {
            if (winnerList.size() > 1) {
                res.append(winnerList.get(i).getCarName() + ", ");
            }
            else {
                System.out.print(winnerList.get(i).getCarName());
                return;
            }
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        System.out.println(res);
    }
}
