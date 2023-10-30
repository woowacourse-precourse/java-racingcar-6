# 구현 목록

## Domain
#### - Racer
  - racerName : 레이서 이름
  - currentMoving : 현재 이동 거리
  - getter / setter
## repository
#### - ReacerRepository (Interface)
  - save : 레포지토리에 레이서 저장
  - findById : ID를 통해서 레이서 찾기 (index Num)
  - findByName : 이름을 통해서 레이서 찾기
  - getMoving : 현재 레이서 이동 거리 반환

#### - MemoryRacerRepository
- save : 레포지토리에 레이서 저장
- findById : ID를 통해서 레이서 찾기 (index Num)
- findByName : 이름을 통해서 레이서 찾기
- getMoving : 현재 레이서 이동 거리 반환

#### - Service
- setupRacing : 입력받은 레이싱 회원은 repository에 등록
- roundMoving : 각 레이서들의 라운드 이동

### Application
- userInput : 사용자 입력 (레이서 이름, 라운드 횟수)
- userOutput : 사용자 출력 (레이서별 이동 거리)
- Run : 게임 실행