# 기능 목록 구현

## Model
- [X] 모델 객체의 이름값 설정 기능
- [x] 전진 기능
- [x] 각 차마다 이름, 위치 정보 빌드 기능

## Controller
- [X] 자동차들 전진하는 기능
  - [X] 0 ~ 9 무작위 값 중 4 이상인 경우를 판단하는 기능
    - **camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()**
- [X] 우승차 판별 기능
- [X] 자동차 리스트 생성 기능
- [X] racing 반복 회수 설정 기능
  
## Input
- [X] 이동 횟수 입력 기능
- [X] 자동차 이름 입력 기능
  - **camp.nextstep.edu.missionutils.Console의 readLine()**

## Output
- [X] 자동차 이름을 입력받기 위한 출력문 기능
- [X] 반복 회수 입력받기 위한 출력문 기능
- [X] 전진하는 자동차 출력 기능 (이름도 같이 출력)
  - [X] "실행 결과" 문구 출력 기능
- [X] 최종 우승자 출력 기능
  - [X] "최종 우승자" 문구 출력 기능
  - [X] 우승자 리스트 출력 기능

## Exception
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 기능