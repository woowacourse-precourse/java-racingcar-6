package racingcar;

class OutputManager {
    static void printCarsMoveStatus(Cars cars) {
        System.out.printf("%s\n\n", cars);
    }

    static void printWinner(Cars cars){
        String winnersName = cars.calculateWinner();
        System.out.printf("최종 우승자 : %s", winnersName);
    }
}
