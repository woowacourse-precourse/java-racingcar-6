package racingcar.Entity;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.exception.LengthException.validateLength;

public class Participantes {
    public static List<String> InputParticipantes(){
        String str = readLine();
        List<String> participantes = new ArrayList<String>();
        String[] splitstr = str.split(",");
        for(int i = 0;i<splitstr.length;i++)
        {
            validateLength(splitstr[i]);
            participantes.add(splitstr[i]);
        }
        return participantes;
    }
}
