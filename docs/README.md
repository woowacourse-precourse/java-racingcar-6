# Controller - 자동차 객체와 출력 객체의 연결 + 진행

## 1. Search

    searchMax(): 자동차 객체 배열 중 제일 많이 전진한 위치를 찾아 반환하는 메서드.
    searchWinner(): 제일 많이 전진한 위치와 같은 자동차 객체를 찾아서 반환하는 메서드.

## 2. Service

    startRace(): 시행 횟수와 자동차 객체 배열을 받아 자동차 전진 진행을 맡는 메서드.
    playGame(): Model과 View 데이터를 연결하며 전체적인 경주를 진행하는 메서드.

## 3. User

    inputCarName(): 자동차 이름을 입력 받는 메서드.
    inputAttempts(): 시행 횟수를 입력 받는 메서드.
    checkNumber(): 입력 받은 시행 횟수가 숫자인지 확인하고 아니면 예외 발생하는 메서드.
    checkParticipants(): 자동차 경주에 참가한 수가 2 이상인지 확인하고 아니면 예외 발생하는 메서드.
    registerCars(): 자동차 객체를 등록하는 메서드.

# **Model**

## 1. Car - 자동차 객체

    Car(): 자동차 객체 초기화.
    setScore(): 랜덤 값을 통해 4이상이면 전진하는 메서드.
    getScore(): 전진한 횟수 반환하는 메서드.
    getName(): 자동차 이름 반환하는 메서드.
    checkWord(): 자동차 이름이 5자 초과하는지, 영문 이외의 값을 입력했는지 확인하고 해당되면 예외발생하는 메서드.

# **View**

## 1. Output - 출력 객체

    printInput(): 처음 시작 메시지를 출력하는 메서드.
    printRound(): 시도할 횟수를 물어보는 메서드.
    printResult(): "실행 결과" 출력하는 메서드.
    printScore(): 자동차 전진 진행 상황을 출력하는 메서드.
    printWinner(): 최종 우승자 출력하는 메서드.