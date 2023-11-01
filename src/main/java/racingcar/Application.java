package racingcar;


//
//        // TODO: 우승자 출력
//        if (!maxCountCars.isEmpty()) {
//            System.out.print("최종 우승자 : ");
//            for (int i = 0; i < maxCountCars.size(); i++) {
//                System.out.print(maxCountCars.get(i));
//                if (i < maxCountCars.size() - 1) {
//                    System.out.print(", ");
//                }
//            }
//        }
//    }
//}

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}