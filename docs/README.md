# 기능 목록 구현

## CarModel
### Field
- [X] 이름값 (5 자 이하)
### Method
- [ ] 전진 기능
- [ ] 정지 기능

## CarManager
### Field
- [X] carModel 들을 담은 list
### Method
- [ ] 자동차들 전진하는 기능
  - 0 ~ 9 무작위 값 중 4 이상일 경우 전진
    - **camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()**
- [ ] 우승자 판별 기능
- [X] 자동차 리스트 생성 기능
  
## InputView
### Method
- [X] 이동 횟수 입력 기능
- [X] 자동차 이름 입력 기능
  - **camp.nextstep.edu.missionutils.Console의 readLine()**

## OutputView
### Method
- [X] 자동차 이름을 입력받기 위한 출력문 기능
- [X] 반복 회수 입력받기 위한 출력문 기능
- [ ] 전진하는 자동차 출력 기능 (이름도 같이 출력)
  - [X] "실행 결과" 문구 출력 기능
  - [ ] 각 자동차마다 전진 횟수 출력 기능
- [ ] 최종 우승자 출력 기능
  - [X] "최종 우승자" 문구 출력 기능
  - [ ] 우승자 리스트 출력 기능

## Exception
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 기능
## Random
- [X] 0 ~ 9 사이의 무작위 정수 생성 기능
  - **camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()**