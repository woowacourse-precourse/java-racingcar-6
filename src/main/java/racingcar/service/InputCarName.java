package racingcar.service;
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.view.PrintAll;
import racingcar.service.ParsingCarName;
import racingcar.repository.SaveCarList;
import java.util.List;

public class InputCarName {
    public List<Car> getCarName(){
        ParsingCarName parsingCarName = new ParsingCarName();
        PrintAll printAll = new PrintAll();
        SaveCarList saveCarList = new SaveCarList();

        //인풋으로 받아서 ParsingCarName에 String으로 다시 보내기
        //=> 그러면 ParsingCarName에서 String분리하고 분리해서, SaveCarName에 저장.
        //=>SaveCarName에서는 domain Car 통해서 Car도메인 형태로 개별 형태 저장하면서 List로 만들음 => 이게 좀 이해가 안감. Run에 있는 Car List?
        printAll.inputCarPrint();//경주할 자동차 이름을 입력하세요.
        String inputCars = Console.readLine();
        parsingCarName.parsingInput(inputCars);

        //parsingCarName(Console.readLine()) 도 가능?
    return saveCarList.entireCarList();
    }
}
