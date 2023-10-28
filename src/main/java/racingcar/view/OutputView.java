package racingcar.view;

public class OutputView {

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
}
