# 미션 - 자동차 경주

## 프로그램 구조
### RacingStarter Class
    - racingstart()
    - nameInput()
    - repeatCountInput()

### Racing Class
    - List<Car> Cars
    - createCars()
    - racingRun()
    - checkResult()

### Car Class
    - String carName
    - int carDistance
    - go()

### Judge Class
    - judgeResult()

### ExceptionHandler Class
    - checkNameInputException()
    - checkRepeatCountInputException()

    -고려해야할 예외사항
        - 이름이 1글자 이상 5글자 이하인가
        - 이름이 문자 외의 글자가 들어가 있는가
        - 반복 회수가 숫자인가