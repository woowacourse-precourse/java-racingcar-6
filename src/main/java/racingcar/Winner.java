package racingcar;

public class Winner {


    public void findWinner(int a, int b, int c,String nameA,String nameB, String nameC) {
        if (a > b) {
            if (a > c) {
                System.out.println("최종 우승자 : " + nameA);
            } else if (a == c) {
                System.out.println("최종 우승자 : " + nameA + ", " + nameC);
            } else {
                System.out.println("최종 우승자 : " + nameC);
            }
        } else if (a == b) {
            if (a > c) {
                System.out.println("최종 우승자 : " + nameA + ", " + nameB);
            } else if (a == c) {
                System.out.println("최종 우승자 : " + nameA + ", " + nameB + ", " + nameC);
            } else {
                System.out.println("최종 우승자 : " + nameC);
            }
        } else {
            if (b > c) {
                System.out.println("최종 우승자 : " + nameB);
            } else if (b == c) {
                System.out.println("최종 우승자 : " + nameB + ", " + nameC);
            } else {
                System.out.println("최종 우승자 : " + nameC);
            }
        }
    }

}
