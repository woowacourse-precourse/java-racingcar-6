package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = readLine();
        String[] cars = inputCars.split(",");

        if(!isShortEnough(cars)){
            throw new IllegalArgumentException("자동차의 이름이 5자 보다 큽니다.");
        }

        return cars;
    }
    public int getNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        String inputAttempts = readLine();

        int attempts;
        try{
            attempts = Integer.parseInt(inputAttempts);
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        return attempts;
    }

    private boolean isShortEnough(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                return false;
            }
        }
        return true;
    }




}
