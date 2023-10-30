package racingcar.view;

public class Output {
    public Output() {}

    public void resultHeader() {
        System.out.println("실행 결과");
    }

    public void position(String currentPosition) {
        System.out.println(currentPosition);
        System.out.println();
    }
}
