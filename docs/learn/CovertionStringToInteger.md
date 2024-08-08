# 문자가 숫자인지 확인하는 방법
https://developer-talk.tistory.com/768
시도 횟수 입력을 받아야하는 상황에 입력이 정수를 입력했는지 아닌지 예외를 처리하는 요구상황이 있기 때문에 문자가 숫자인지 확인하는 방법을 서칭했다. 

## Integer.parseInt
가장 간단한 방법은 `Integer.parseInt`를 이용하는 방법이다. 

```
try {
	int trialNumber = Integer.parseInt(inputString);
} catch (NumberFormatException ex) {
	throw new IlligalArgumentException();
}
return trialNumber;
```

`parseInt`를 실행하면 문자열이 정수인지 판단해 아니라면 NumberFormatException을 수행할 수 있다. 
하지만 여기서 다른 문제점이 있었는데 위의 방식으로 하면 간단하지만 하나의 메서드가 두개의 기능을 수행함을 발견했기 때문이다.

1. 예외 처리하기
2. inputString을 int 형으로 전환하기 

따라서 다른 방법을 이용하기로 했다. 

## 정규표현식 
기본적으로 String 클래스는 `match()`라는 정규표현식을 준수하는지 검사하고 true/false를 리턴하는 메서드가 있다. 정규 표현식을 사용하면 정수인지 확인할 수 있다.
- `[+-]?` : + 또는 - 중 "한개"가 있어야한다. (만약 1주차 과제라면 "1", "2"가 아닌지 구분하기 위해 정규표현식으로 `restartNumber.matches("[12]?")`를 사용했을 것이다. )
- `\\d*` : "한 개 이상"의 정수가 있어야한다.   
- `\\d+` : 한 개 이상의 정수를 "허용"한다. 

```
public int convertTrialNumberInputToInteger(String trialNumberInput) {  
    validateTrialNumberNotInteger(trialNumberInput);  
    return Integer.parseInt(trialNumberInput);  
}  
  
public void validateTrialNumberNotInteger(String trialNumber) {  
    if (trialNumber.matches("\\d*")) {  
        return;  
    }  
    throw new IllegalArgumentException("시도 횟수는 정수를 입력해주세요."); 
}
```

이를 내 코드에 적용시켰다. 성공적으로 기능을 분리할 수 있었고 요구사항을 만족할 수 있었다.