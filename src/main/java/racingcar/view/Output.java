package racingcar.view;

public class Output {
    public Output() {
    }

    public void resultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void position(String currentPosition) {
        System.out.println(currentPosition);
    }

    public void winners(String winner) {
        System.out.printf("최종 우승자 : %s", winner);
    }
}
