package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public View(){

    }

    public String inputConsole(){
        return readLine();
    }

    public void printCurrentCarsResult(Cars cars){
        for(Car car:cars.getCars()){
            printCurrentCarResult(car);
        }
        System.out.println();
    }

    public void printCurrentCarResult(Car car){
        System.out.println(car.getNameValue()+" : "+car.getCurrentPositionStatus());
    }

    public void printNameInputMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptCountInputMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printAttemptResultMessage(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printFinalWinnerMessage(String result){
        System.out.println();
        System.out.print("최종 우승자 : "+result);
    }
}
