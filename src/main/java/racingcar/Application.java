package racingcar;

//            // TODO: 실행 결과

//        }
//
//        // TODO: 전진 "-" 개수 비교
//        int maxCount = 0;
//        List<String> maxCountCars = new ArrayList<>();
//
//        for (int o = 0; o < forwardCountInt.length; o++) {
//            if (forwardCountInt[o] > maxCount) {
//                maxCount = forwardCountInt[o];
//                maxCountCars.clear();
//                maxCountCars.add(cars[o]);
//            }
//            else if (forwardCountInt[o] == maxCount) {
//                maxCountCars.add(cars[o]);
//            }
//        }
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