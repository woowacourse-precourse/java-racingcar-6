## 0. 개발 전
### - 작동 흐름
- MC : "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
- player : 이름(5자 이하)

- MC : "시도할 회수는 몇회인가요?"
- player : n의 값 받기(자동차는 전진 또는 멈춤) (0~9)

- 실행 결과
- "최종 우승자 :" + 자동차 이름
- 

### - 구현 목표
- MC가 말하는 것 출력
- 자동차 클래스 생성 
- 자동차 이름 값이 조건에 맞지 않을 경우 IllegalArgumentException 발생
- 사용자의 이동 횟수 받고 해당 횟수만큼 진행
- 0~9 사이 무작위 값 후 4이상일 경우 전진
- 우승자 출력

## 1. 1차 개발
- car class 생성으로 게임 값의 처리를 class 내에서 작업 가능
- 1차 과제를 통해 예외 처리에 대한 학습으로 이번 예외 발생에는 어려움이 없었음

---
# < 최종 코드 리뷰 >

##  Main
- 사용자가 입력값을 받아 리스트 제작
- List<Car>을 통해 정보들의 기본 리스트 생성
- 입력값인 n번의 게임 수행
- 우승자 도출
- Game()
    - input : List<Car> / return : void
    - 리스트 크기만큼 돌며 Car에 존재하는 GoOrStop 메소드를 통해 게임 진행  
- makeCarlist()
  - input : String[] / return : List<Car>
  - 자동차 이름의 list를 Car 타입의 list로 변환
- getCarName()
  - input : null / return : String[]
  - 자동차 입력을 받고 split을 통해 문자열 타입의 리스트 생성
- checkInput()
  - input : String / return : void
  - 자동차 이름이 유효한 값인지 확인
- checkInput_len()
  - input : String / return : boolean
  - 입력값이 5이하면 true 아니면 false return 
- findWinner()
  - input : List<Car> / return : void
  - sort를 통한 정렬을 진행하여 마지막 go 값이 큰 자동차 이름으로 시작
  - 이후 for문을 통해 max_score 과 값이 동일하면 출력
  - 아니면 break를 통해 빠져나옴

## (Class) Car
- 문자열 타입의 name, 정수형 타입의 go 로 구성
- set, get을 통해 다른 class에서 사용 가능하도록 하였음
- InitCarInfo()
    - input : String / return : void
    - name은 입력값으로 go 값은 0으로 초기화
- GoOrStop()
    - input : null / return : void
    - makerandom 을 통해 만들어진 값이 4이상이면 go값 증가
    - 이후 go 값에 대한 print 진행
- printInfo()
  - input : int / return : String
  - go가 진행된 만큼 '-'을 최종 문자열에 붙여넣음
- makerandom()
  - input : null / return : int
  - 0~9 사이의 무작위 값을 return

