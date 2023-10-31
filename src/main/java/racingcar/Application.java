package racingcar;

import racingcar.domain.CarList;
import racingcar.view.InputView;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarList carList = new CarList(InputView.nameInput());
        Integer trynum = InputView.numberInput();
        Game.run(carList,trynum);



//        carList.printCarList();
//        System.out.println("pobi : -");
//        System.out.println("woni : ");
//        System.out.println("최종 우승자 : pobi");

    }
}
