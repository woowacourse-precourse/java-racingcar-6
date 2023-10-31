package racingcar;

import java.util.List;
import racingcar.dto.PerGameCarResultDto;

public class View {

    public void println(String input) {
        System.out.println(input);
    }

    public void printResult(List<PerGameCarResultDto> resultDtos) {
        for (PerGameCarResultDto resultDto : resultDtos) {
            String moveResult = new String(new char[resultDto.getMoveCnt()]).replace('\0', '-');
            System.out.println(resultDto.getCarName() + " : " + moveResult);
        }
        System.out.println();
    }

}
