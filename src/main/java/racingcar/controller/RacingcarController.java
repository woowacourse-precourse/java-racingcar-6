package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryRacingcarRepository;
import racingcar.service.RacingcarService;
import racingcar.view.ReaultView;

public class RacingcarController {

    private final CarRepository carRepository = new MemoryRacingcarRepository();
    private final RacingcarService racingcarService = new RacingcarService();
    private final ReaultView reaultView = new ReaultView();

    public void register() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameList = Console.readLine();

        for(String name : nameList.split(",")) {
            carRepository.save(name);
        }


        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int times = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            System.out.println("입력값이 잘못되었습니다.");
        }
    }

    public void change

}
