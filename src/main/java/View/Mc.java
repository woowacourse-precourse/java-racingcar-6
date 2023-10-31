package View;

import Model.Car;

import java.util.ArrayList;
import java.util.List;

public class Mc {

    public void showResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showWinner(List<Car> winners) { // 처음에는 하나의 메소드안에 우승자가 1명일 때랑 여러명일때 코드를 같이 넣었는데 indent 제한 때문에 수정
        if (winners.size() == 1) {
            oneWinner(winners);
        } else {
            coWinner(winners);
        }
    }

    public void oneWinner(List<Car> winners) {
        System.out.print("최종 우승자 : " + winners.get(0).getName());
    }

    public void coWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
