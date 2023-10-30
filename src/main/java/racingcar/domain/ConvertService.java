package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class ConvertService {
  public ConvertService() {}
  public List<String> StringConvertList(String input){
    return Arrays.asList(input.split(","));
  }
  public int StringConvertInt(String input){
    return Integer.parseInt(input);
  }
}
