package racingcar.view;

import racingcar.Entity.Car;

import java.util.List;

public class SystemOutputMessage {
    public void showCarPosition(String name, int position) {
        System.out.print(name + " : ");
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinnerMessage(List<Car> winner) {
        StringBuilder str = new StringBuilder();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            if(i == winner.size()-1) str.append(winner.get(i).getName());
            else str.append(winner.get(i).getName()).append(", ");

        }
        System.out.print(str);
    }
}
