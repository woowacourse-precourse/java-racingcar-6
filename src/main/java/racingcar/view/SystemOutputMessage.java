package racingcar.view;

public class SystemOutputMessage {
    public static void showStartGameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showCarPosition(String name, int position) {
        System.out.print(name + " : ");
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
