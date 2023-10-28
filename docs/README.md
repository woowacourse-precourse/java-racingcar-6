# ⚾&nbsp;&nbsp;Precourse-Week2 Mission **[레이싱 카]**

## 💌&nbsp;&nbsp;목차

- [📦&nbsp;&nbsp;패키지 구조](#패키지-구조)
- [✨&nbsp;&nbsp;구현 목록](#구현-목록)
- [🎨&nbsp;&nbsp;29명의 소중한 코드리뷰 적용기](#29명의-소중한-코드리뷰-적용기)
- [🎨&nbsp;&nbsp;구현 간 고민했던 내용들](#구현-간-고민했던-내용들)

---

## 📦&nbsp;&nbsp;패키지 구조

<div align="center">
<table>
    <tr>
        <th align="center">Package</th>
        <th align="center">Class</th>
        <th align="center">Description</th>
    </tr>
    <tr>
        <td><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/2f32b4cd-187c-4b92-a136-2d86cd3341cd" width="20px">&nbsp;&nbsp;controller</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Game</b></td>
        <td>게임 로직을 메인으로 동작하는 컨트롤러 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="4"><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/f16a8719-281f-4535-a958-c1c62d69cfa2" width="20px">&nbsp;&nbsp;domain</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Car</b></td>
        <td>움직임을 동작하는 개별 자동차 클래스</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Cars</b></td>
        <td>개별 자동차를 멤버변수로 갖는 일급 컬렉션 클래스</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;MovementCondition</b></td>
        <td>자동차의 전진 조건을 생성하고 검증하는 클래스</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Name</b></td>
        <td>자동차 이름에 대한 원시값 포장 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="3"><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/219d6ae0-19c4-4984-970d-ea244700b6a9" width="20px">&nbsp;&nbsp;dto</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/3ef9d8a2-d4bb-42a1-900f-754799cac3fd" height="32px">&nbsp;&nbsp;FinalResponse</b></td>
        <td>최종 우승자를 리턴하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/3ef9d8a2-d4bb-42a1-900f-754799cac3fd" height="32px">&nbsp;&nbsp;RoundResponse</b></td>
        <td>라운드 별 각 자동차의 점수를 시각화해 리턴하는 DTO 레코드</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/3ef9d8a2-d4bb-42a1-900f-754799cac3fd" height="32px">&nbsp;&nbsp;RoundResponses</b></td>
        <td>각 라운드별 모든 자동차의 점수를 리턴하는 DTO 레코드</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="2"><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/1de269e3-5ceb-4e91-b9a9-922e81bc0e6a" width="20px">&nbsp;&nbsp;exception</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/b8e837c7-bc6a-4bbc-a4c3-267ec11da553" height="32px">&nbsp;&nbsp;ErrorMessage</b></td>
        <td>예외를 던질 때 사용되는 에러 메세지 Enum 클래스</td>
    </tr>
    <tr>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;RacingCarException</b></td>
        <td>전역에서 에러를 핸들링하는 Custom Exception</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/6236ca3c-b1b5-4ee9-b2ba-062252930498" width="20px">&nbsp;&nbsp;parser</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;Parser</b></td>
        <td>Input을 생성자 멤버변수 형식에 맞게 파싱하는 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/1cb95818-66f2-42b0-b03c-b7cc8cc27dad" width="19px">&nbsp;&nbsp;validator</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;InputValidator</b></td>
        <td>Input Value에 대한 기본 유효성 검증을 진행하는 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td rowspan="1"><b><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/ea629f71-ed2c-4277-bc10-d93a0758e377" width="20px">&nbsp;&nbsp;view</b></td>
        <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/d3866f61-24f0-4bf2-a68c-1eb18596bf2f" height="32px">&nbsp;&nbsp;View</b></td>
        <td>View Layer에서 입/출력을 담당하는 클래스</td>
    </tr>
    <tr>
        <td><b>&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/a7b13c6b-dc98-4571-b8bc-7d50d2ca5b49" width="20px" align="center">&nbsp;&nbsp;constants</b></td>
                <td><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/b8e837c7-bc6a-4bbc-a4c3-267ec11da553" height="32px">&nbsp;&nbsp;Message</b></td>
        <td>사용자에게 출력할 정적 메세지 Enum 클래스</td>
    </tr>
    <tr><td colspan="3"></td></tr>
    <tr>
        <td colspan="3" align="center"><b>Package Structure Overview</b></td>
    </tr>
    <tr>
        <td colspan="3">null</td>
    </tr>

</table>
</div>

<br>

---

## ✨&nbsp;&nbsp;구현 목록

### Non-Functional Requirement

+ [X] 자동차 경주
  프로그램은 [MVC 패턴]("https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC") 에 따라
  설계한다.
+ [X] [YAGNI]("https://ko.wikipedia.org/wiki/YAGNI") 원칙에 의거해, 필요 구현 요소를 밀도있게 구현하는 것을 목표로 한다.

<br>

### Functional Requirement (Controller Code Flow)

+ [X] [Game] 사용자에게 자동차 이름을 `,(Comma)`를 기준으로 입력 받는다

    * [View] 사용자에게 자동차 이름 요청 폼을 출력하고, 문자열을 입력받는다.
    * [InputValidator] 유효성 검사 : Comma로 끝나거나, whiteSpace를 포함하는 요청 예외처리한다.
    * [Parser] 플레이어에게 입력받은 String을 Comma를 기준으로 파싱해 List<String> 형태로 변환한다.
    * [InputValidator] 유효성 검사 : List<String>에 동일한 이름이 포함된 경우 예외처리한다.

<br>

+ [X] [Game] 파싱된 List<String> 문자열로 List<Car>를 멤버변수로 갖는 Cars 객체를 생성한다.

    * [Cars] stream 문법을 사용해, 모든 List<String> 원소를 바탕으로 Car 객체를 생성한다.
    * [Cars] 위에서 만든 Car 객체를 List<Car> 형태로 리턴해 Cars의 멤버변수로 생성한다.

<br>

+ [X] [Game] 사용자에게 라운드 횟수를 입력받는다.

    * [View] 사용자에게 라운드 횟수 요청 폼을 출력하고, 숫자형 문자열을 입력받는다.
    * [InputValidator] 유효성 검사 : 정수형이 아닌 숫자나 문자열이 요청되면 예외처리
    * [InputValidator] 유효성 검사 : 1 미만의 숫자가 요청되면 예외처리
    * [Parser] 라운드 횟수를 정수형으로 파싱해 컨트롤러에 리턴한다.

<br>

+ [X] [Game] 라운드 횟수에 따라, 각 라운드를 반복 진행한다

    * [Cars] for-each 문법을 사용해, 멤버변수의 모든 car를 대상으로 move 메소드를 호출
    * [(Each) Car] `MoveCondition.create` 함수를 호출해 1~9 사이의 랜덤 정수를 담은 조건 객체를 생성한다.
    * [(Each) Car] `MoveCondition.movable` 함수를 호출해 이동 가능 여부 메세지를 보내고, 이동 여부에 따라 행동한다.

<br>

+ [X] [Game] 각 라운드 종료`(모든 Each Car가 1회전 경주를 마친 상황)`

    * [Cars] buildRoundResponses 함수를 호출해 일급 컬렉션 멤버변수를 아래 과정을 통해 DTO로 변환한다.
    * [RoundResponses] stream 문법을 사용해 모든 List<Car>를 순회하며 List<RoundResponse>를 생성한다.
    * [RoundResponse] 각 RoundResponse는 name과 score를 가지며, toEntity 편의 메소드로 <br>`이름 : --` 형태로 출력한다.
    * [RoundResponses] 레코드의 일급 컬렉션 멤버변수인 List<RoundResponse>를 순회하며 모든 자동차의 라운드 결과를 <br>`이름 : --` 형태의 `String`으로 리턴한다.
    * [View] RoundResponses.toEntityList()를 통해 각 라운드 진행 현황을 사용자에게 출력한다.

<br>

+ [X] [Game] 모든 라운드 종료`(라운드 횟수 만큼 모든 자동차가 경주를 진행한 상황)`되었을 때

    * [Cars] buildFinalResponse 함수를 호출해 일급 컬렉션 멤버변수를 아래 과정을 통해 DTO로 변환한다.
    * [FinalResponse] FinalResponse는 List<String> winnerNames 가지며, toEntity 편의 메소드로 <br>`최종 우승자 : 해빈, 햅, 빈빈`
      형태의 `String`으로
      리턴한다.
    * [View] FinalResponse.toEntity()를 통해 최종 우승자를 사용자에게 출력한다.
    * [Console] Console.close() 명령어를 통해 `Scanner.close()` 기능을 수행한다.

<br>

--------------------------------------------------------

## 🎨&nbsp;&nbsp;29명의 소중한 코드리뷰 적용기

<div align="center">
<table>
    <tr>
        <th align="center">대분류</th>
        <th align="center">질문</th>
        <th align="center">Reviewers</th>
    </tr>
    <tr>
        <td rowspan="4"><b><img align="center" src="https://github.com/woowacourse-precourse/java-racingcar-6/assets/112257466/9a2cdecd-2df4-4541-86ec-4e8fa1017643" height="32px">&nbsp;&nbsp;README.md</b></td>
        <td>깔끔한 기능 구현 목록... 감탄하고 갑니다. 🤗<br>개발의 전체적인 과정을 볼 수 있는 것 같아 좋아요👀<br>리드미가 너무 보기 좋네요! 나중에 협업할 때도 되게 좋을 것 같습니다</td>
        <td rowspan="4">@jcoding-play 외 9명</td>
    </tr>
</table>
</div>

## 🎨&nbsp;&nbsp;구현 간 고민했던 내용들

### 1️⃣&nbsp;&nbsp;&nbsp;View Layer <-> [MVC 패턴]("https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC")에서 Model Layer와 Domain Layer의 관계

### 1️⃣&nbsp;&nbsp;&nbsp;정적 팩토리 메소드의 장단점

### 1️⃣&nbsp;&nbsp;&nbsp;엇갈린 코드리뷰
