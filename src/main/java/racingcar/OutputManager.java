package racingcar;

class OutputManager {
    static void printCarsMoveStatus(Cars cars) {
        System.out.printf("%s\n\n", cars);
    }

    static void printWinner(Cars cars){
        String winnersName = cars.calculateWinner();
        System.out.printf("최종 우승자 : %s", winnersName);
    }

    static void printCarsNameInputGuide(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }
}
