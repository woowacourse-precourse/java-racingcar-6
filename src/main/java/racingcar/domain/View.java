package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class View {
    public void viewResult(String name, int position){
        StringBuilder msg = new StringBuilder(name + " : ");
        Optional<String> formattedPosition = Stream.generate(() -> "-").limit(position).reduce((a, b) -> a+b);
        formattedPosition.ifPresent(msg::append);
        System.out.println(msg);
    }
}
