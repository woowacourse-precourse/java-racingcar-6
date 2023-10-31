package racingcar.view;

public class OutPutView {

    public void outputCar(String car){
        System.out.println(car);
    }
    public void outputResult() {
        System.out.println("실행 결과");
    }

    public void outputWinner(String printWinners) {
        System.out.print("최종 우승자 : ");
        System.out.println(printWinners);
    }
}
