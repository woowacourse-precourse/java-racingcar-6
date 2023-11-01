# 미션 - 자동차 경주

## 🚀 개요
- 자동차 경주 게임 구현
  - 입력
    1. 텍스트와 ','로 구성된 자동차 이름 리스트 입력
    2. 이동 시도 회수 입력
  - 전진 조건
    - 0~9 사이의 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진
  - 경기 종료
    - 사용자의 입력 회수 만큼 이동 후 우승자 출력 후 종료
  - 출력
    - 차수별 실행 결과
    - 우승자 안내 문구
      1. 단독 우승
      2. 공동 우승
## 🚀 기능 목록
> 1. 입력 기능 
>   - 1.1 자동차 이름 입력 : Input.getCars()
>   - 1.2 이동 시도 횟수 입력 : Input.getAttempts()
> 2. 유효한 입력 검증
>   - 2.0 빈 입력 검증 : Validation.validationEmpty(String input)
>   - 2.1 자동차 이름 입력 검증 : Validation.validationCarName(String name)
>   - 2.2 이동 시도 횟수 입력 검증 : Validation.validationAttempts(String attempts)
>   - 2.3 중복된 이름 검증 : Validation.validationDuplication(List<Car cars) 
> 3. 자동차 객체
>   - 자동차 객체 기능
>     - 3.1 자동차 전진 기능 : Car.moveCar()
>       - 3.1.1 자동차 현 위치 출력 기능 : Car.printLocation()
>     - 3.3 자동차 현 위치 반환 기능 : Car.getLength()
> 4. 출력 기능
>   - 4.1 게임 진행 결과 출력 기능 -> 기능 목록 3.1.1
>   - 4.2 우승자 명시 메서드 : Output.printWinners(List<Car> cars)
> 5. 게임 관리 기능
>    - 5.1 게임 시작 기능 : gameStart()
>    - 5.2 게임 종료 기능 : gameEnd()
>    - 5.3 게임 진행 기능 : gamePlay()
>    - 5.4 최장 거리 계산 기능 : getLongestDistance()
> 6. 에러 관리 : ErrorCollection

