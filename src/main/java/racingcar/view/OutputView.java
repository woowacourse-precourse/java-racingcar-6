package racingcar.view;


public class OutputView {

    // 결과 시작 문구
    public static void printCarResult(){
        System.out.println();
        System.out.println("실행 결과");
    }

    // 각 자동차 이름 출력하기
    public static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    // 각 자동차 거리만큼 출력하기
    public static void printCarPosition(int position) {
        for (int i = 0; i < position; i++){
            System.out.print("-");
        }
    }

    // 띄어쓰기 출력하기
    public static void printSpace(){
        System.out.println();
    }

    // 우승자 안내 문구
    public static void printWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
