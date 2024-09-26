# ✨ 프로젝트 소개

이 프로젝트는

**<span style="color:royalblue">우아한 테크코스 6기 프리코스</span>**

**<span style="color:red">(2주차 미션) 자동차 경주 프로젝트</span>**  입니다.

<br>

```
<자동차 경주 프로젝트 간단 설명>

사용자가 경주에 참여할 자동차 이름을 입력하고

경주를 시도할 횟수를 입력하면

자동차 경주를 실시하고 경기 결과를 출력
```

![참고](https://velog.velcdn.com/images/rednada1486_/post/c5376df4-334e-44e1-b328-81011f2de109/image.gif)

<br><br><br>

# ✨ 프로젝트 구조

(미숙하지만.. ^^)

**<span style="color:red">MVC 패턴을 적용해서</span>**

프로젝트를 만들어 보았습니다.

![프로젝트 구조](https://velog.velcdn.com/images/rednada1486_/post/af376d1c-489e-48e3-874b-5ccadb3170cd/image.png)

<br>

💼 Model : 비즈니스 로직을 담당
```
domain
    ㄴ Car : 개별 차량과 관련된 비즈니스 로직을 담당 
       
service
    ㄴ RacingService : 자동차 경주를 진행할 때 필요한 비즈니스 로직을 담당
```

<br>

👁️ View : 사용자에게 데이터를 시각적으로 표시하는 부분

```
view
    ㄴ InputView : 사용자가 입력한 값을 가져오는 역할을 담당
    
    ㄴ OutputView : 사용자에게 결과물을 보여주는 역할을 담당
```

<br>

🕹️ Controller : Model과 View 사이의 상호작용을 조정하고 제어하는 부분

``` 
controller
    ㄴ RacingController : 사용자 입력값을 받아서 자동차 경주를 진행하고 결과값을 출력함
```

<br>

🔧 기타 : 프로젝트를 할 때 유용한 기능 모음

```
utils 
     ㄴ StringUtils : 문자열과 관련된 기능을 모아놓음
```

<br><br><br>

# ✨ 기능 구현  목록

<br>

📕 domain.Car :

    ✏️ 기능1. 랜덤 값에 따라 자동차를 한 칸 전진한다. ➡ move()

    ✏️ 기능2. 특정 자동차의 이름과 이동거리를 반환한다. ➡ toString()

<br>

📕 service.RacingService :

    ✏️ 기능3. 현재 라운드를 진행한다. ➡ playRound()

    ✏️ 기능6. 우승자들을 찾는다. ➡ generateWinnerList()

        ✏️ 기능5. 경기가 끝났을 때, 가장 많이 이동한 자동차의 이동거리를 찾는다. ➡ getMaxMovingDistance()

<br>

📕 controller.RacingController :

    ✏️ 기능18. 경기 흐름을 제어한다. ➡ play()

        ✏️ 기능8. 경주에 출전하는 자동차의 이름을 등록한다. ➡ registerPlayer()
    
            ✏️ 기능9. 유저의 입력을 쉼표 기준으로 분리한다. ➡ userInputToStringCarArray()
    
            ✏️ 기능10. 자동차의 이름이 6글자 이상이면 에러를 발생시킨다. ➡ validateCarName()
    
            ✏️ 기능12. 사용자 입력값을 자동차 리스트로 변환한다. ➡ stringCarArrayToCarList()

        ✏️ 기능13. 경주의 전체 라운드 수를 등록한다. ➡ registerTotalRound()
    
            ✏️ 기능14. 경주 전체 라운드 수로 입력한 값을 숫자로 바꾼다. ➡ userInputToInt()
     
            ✏️ 기능15. 경주 전체 라운드 수로 입력한 값이 숫자가 아니면 에러를 발생시킨다. ➡ userInputToInt()

        ✏️ 기능16. 전체 경주를 진행하고 결과를 출력한다. ➡ playRacing()
    
        ✏️ 기능17. 전체 경주 종료 후 우승자 목록을 출력한다. ➡ announceWinner()

<br>

📕 view.InputView :

    ✏️ 기능11. 경주에 출전하는 차량 목록을 유저로 부터 입력받는다.  ➡ readPlayer()
    
    ✏️ 기능19. 경주의 전체 라운드 수를 유저로 부터 입력받는다.  ➡ readTotalRound()

<br>

📕 view.OutputView :

	✏️ 기능4. 현재 라운드의 결과를 출력한다. ➡ printRoundResult()

	✏️ 기능7. 최종 결과를 출력한다. ➡ printWinner()

		✏️ 기능20. 최종 결과 문구를 만든다. ➡ makeFinalWinnerOutputStatement()


<br><br><br>

# ✨ 이번 프로젝트에서 중점을 둔 부분

이번 프로젝트에서는 다음 사항을 지키려고 노력하면서 프로그래밍을 진행하였습니다.

    📌 MVC 패턴 적용해서 클래스 분리
    
    📌 메서드가 하나의 역할만 수행할 수 있도록 최대한 기능을 분리하기
    
    📌 테스트 코드 작성