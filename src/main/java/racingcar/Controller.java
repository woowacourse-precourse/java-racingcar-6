package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public void gameStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = new Cars();

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = tryNumber();

        System.out.println();   //개행

        System.out.println("실행 결과");
        moveWhlie(tryNumber, cars);

        cars.winnerCar();
        cars.printWinnerCar();
    }


    private void moveWhlie(int tryNumber, Cars car){  // 입력받은 숫자만큼 반복
        for(int i = 0; i < tryNumber; i++){

            car.moveCar();
            System.out.println();  //개행
        }
    }
    public int tryNumber(){
        String tryNumber = Console.readLine();
        numbersizeError(tryNumber);
        numberFormatError(tryNumber);
        return Integer.parseInt(tryNumber);
    }

    public void numbersizeError(String tryNumber) {  //0이하의 숫자일 떄 오류
        int inputNumber = Integer.parseInt(tryNumber);

        if (inputNumber <= 0) {
            throw new IllegalArgumentException(ExceptionError.numbersizeError);
        }
    }

    public void numberFormatError(String tryNumber) {  //숫자가 아닐떄 오류
        try {
            int inputNumber = Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionError.numberFormatError);
        }
    }
}




