package racingcar.view;

public class ResultOutput {

    public void printAnnounce() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacing(String[] names, String[] locations) {
        for (int i=0; i < names.length; i++) {
            System.out.printf("%s : %s%n", names[i], locations[i]);
        }
        System.out.println();
    }

    public void printResult(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
