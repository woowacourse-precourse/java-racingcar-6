package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.utils.Parser;
import racingcar.view.RequestMessage;

import java.util.List;

public class Controller {

    private final CarRepository carRepository = new CarRepository();
    private final Parser parser = new Parser();
    public void run(){
        saveCarName(getCarNameInput());
    }

    private void saveCarName(List<String> playerInput){
        for(String elements : playerInput){
            carRepository.save(new Car(elements));
        }
    }
    private List<String> getCarNameInput(){
        RequestMessage.setCarName();
        return parser.stringCarNameToArrayList(Console.readLine());
    }
    //TODO : 레포지토리 활용해서 도메인에 유저 입력 저장하는 거 개발하고 커밋하기
}
