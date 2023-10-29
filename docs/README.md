# 자동차 경주 게임

## 구현 기능 목록

#### 구현을 위한 역할을 4가지(Main, DAO, Service, Verify)로 나누었다. 

# Main
+ Application
  + main() 메소드를 실행할 클래스



# DAO
+ RacingCarInformationDao
  + 사용자의 이름과 이동 횟수 정보를 담을 객체 (LinkedHashMap 자료구조 활용)
  

+ WinnerInformationDao
  + 우승자의 자동차 이름을 담을 객체 (List 자료구조 활용)




# Service
+ GameGuideTextPrintService
    + 게임 진행을 도와주는 텍스트 출력 서비스


+ RacingCarNameScanService
  + 자동차의 이름을 입력을 받는 서비스


+ TryNumberScanService
    + 시도할 횟수를 입력 받는 서비스
        + static tryNumber 변수


+ RandomNumberPickService
    + 0~9 사이에서 무작위 값을 뽑는 서비스


+ RacingCarForwardService
  + 자동차의 전진 횟수 추가 서비스


+ RacingCarInfoGetService
    + 자동차의 전진 횟수의 값을 얻는 서비스
    

+ RacingCarInfoPrintService
  + 자동차 이름과 전진 횟수를 출력하는 서비스


+ WinnerInfoAddService
  + 경주가 끝나고 우승 자동차의 이름을 리스트에 저장하는 서비스


+ WinnerInfoGetService
  + 우승 자동차의 이름을 가져오는 서비스


+ WinnerInfoPrintService
  + 우승 자동차의 이름을 출력하는 서비스


+ ProgressCheckService
  + 매 시도 횟수 마다 상황을 체크하는 서비스





# verify
+ RacingCarNameVerify
  + 자동차의 이름 입력이 조건에 부합 하는지 검증.


+ TryNumberVerify
  + 시도 횟수 입력이 조건에 부합 하는지 검증.


+ ForwardPointVerify
  + 랜덤 숫자 값이 전진하는 조건에 부합 하는지 검증.


