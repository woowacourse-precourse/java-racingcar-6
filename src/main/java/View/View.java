package View;

public class View {
    public static void inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGameProgress(String progress) {
        System.out.println(progress);
    }


    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
