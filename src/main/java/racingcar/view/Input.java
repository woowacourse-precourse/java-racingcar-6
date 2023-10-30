package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.Constant.INIT_CAR_NAME;

public class Input {

    public String[] InputCarName(){
        System.out.println(INIT_CAR_NAME);
        String input = Console.readLine();
        if(!input.contains(" "))
            throw new IllegalArgumentException("쉽표(,)를 통해 구분해 주세요.");

        String[] cars = input.split(",");
        if(cars.length == 1)
            throw new IllegalArgumentException("자동차는 2대 이상이 경기에 참여해야 합니다");
        for(String carName : cars){
            if(carName.length() < 6){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return cars;
    }
}
