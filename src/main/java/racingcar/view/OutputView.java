package racingcar.view;

public class OutputView {

    private OutputView() {
    }

    public static void printRacingStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAskCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult(){
        System.out.println("실행 결과");
    }

    public static void printCarsMove(String name, int postion){
        StringBuilder carString = new StringBuilder();
        carString.append(name);
        carString.append(":");
        for (int i = 0; i < postion; i++) {
            carString.append(" -");
        }
        System.out.println(carString);
    }


    public static void printWinner(String s) {
        System.out.println("최종 우승자 :" +" "+s);
    }
}
