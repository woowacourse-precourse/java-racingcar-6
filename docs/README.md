# 자동차 경주 기능 구현 목록

## 사용자 값 입력받는 기능
- ✅ "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"를 출력한다.
- ✅ getCarNames 메서드 구현
    - ✅ 경주 할 자동차 이름 입력받기(이름은 쉼표(,) 기준으로 구분)
        - ✅ `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 자동차의 이름들을 입력받는다.
        - ✅ stringToStringList 메서드 구현 
          - ✅ 입력받은 문자열을 List 형태로 변환한다.
        - ✅ validateCarNameLength 메서드 구현
            - ✅ 자동차 이름의 길이가 5이하이면 통과
            - ✅ 아니라면 IllegalArgumentException 예외 발생
- ✅ getCount 메서드 구현
    - ✅ 시도할 회수 입력받기
        - ✅ `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 시도할 회수를 입력받는다.
        - ✅ validateStringIsDigit 메서드 구현
            - ✅ 입력된 값이 숫자면 통과
            - ✅ 아니라면 IllegalArgumentException 예외 발생
        - ✅ 문자열을 정수 타입으로 변환하여 반환한다.

## 자동차를 구현하는 기능
- ✅ getCarListByCarNames 메서드 구현
    - ✅ 입력받은 자동차의 이름으로 Car 객체 생성한다.
    - ✅ 생성한 Car 객체들을 List 형태로 반환한다.

## 전진하는지 멈추는지 판별하는 기능
- ✅ forwardOrStop 메서드 구현
    - ✅ `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용해 1부터 9사이의 난수를 입력받는다.
    - ✅ 그 난수가 4이상이면 전진하고 아니면 멈춘다.
    - ✅ 전진하면 Car 객체의 forward 인스턴스 변수에 +1을 한다.

## 결과 출력하는 기능
- ✅ showResult 메서드 구현
    - ✅ "실행 결과"를 출력한다.
    - ✅ 입력받은 회수만큼 반복문을 실행한다.
        - ✅ forwardOrStop 메서드 실행
        - ✅ printResult 메서드 구현
            - ✅ 매개변수로 Car 객체의 리스트를 받아 자동차의 name과 forward 수를 출력한다.
            - ✅ countForward 메서드 구현
                - ✅ Car 객체의 forward 수만큼 "-"를 출력한다.

## 우승자 판별하는 기능
- ✅ getWinner 메서드 구현
    - ✅ 매개변수로 Car 객체의 List를 받는다.
    - ✅ 새로운 List를 만들어 Car 객체의 forward를 비교해 제일 큰 Car 객체의 name을 List에 담는다.
    - ✅ 제일 큰 forward가 여럿이면, 그에 해당하는 Car 객체들의 name을 List에 담는다.
    - ✅ 우승자의 이름이 들어있는 List를 반환한다.

## 우승자 출력하는 기능
- ✅ printWinner 메서드 구현
    - ✅ List에 담긴 우승자의 이름을 `String.join()`을 사용해 출력한다.


## 예외 처리 기능
- ✅ 사용자가 입력한 값에 대한 예외 처리
- ✅ 이외의 값이 입력된 경우 `IllegalArgumentException` 예외 발생
    - ✅ 사용자가 입력한 자동차의 이름을 쉼표(,) 기준으로 구분하면 통과
    - ✅ 사용자가 입력한 자동차 이름의 길이가 5이하이면 통과
    - ✅ 사용자가 입력한 회수가 숫자인 경우 통과