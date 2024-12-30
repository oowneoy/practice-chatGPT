## spring-chatGPT
Spring Boot 환경에서 openAI 의 chatGPT 모델을 연동해 질의응답 기능을 제공합니다.

## 개발 환경
- Spring Boot 3.2.5
- Java 17
- Gradle

## 설치 및 실행 방법
1. 필수 요구사항
- Java 17 이상
- Gradle 환경
- openAI API Key
- openAI 언어 모델 (ex, `gpt-4o`)
2. 클론
  ```
  git clone https://github.com/oowneoy/spring-chatGPT.git
  ```
3. 의존성 설치
  ```
./gradlew build
  ```
4. 애플리케이션 실행

## API 요청 테스트
### (24.12.31)
- 제공된 엔드포인트는 OpenAI 의 [공식 API](https://platform.openai.com/docs/api-reference/chat) 를 통해 챗봇 응답을 생성하는 데 사용되는 REST API 와 통신합니다.
  - 간단한 질의응답 테스트로, 이전의 대화를 기억하지 않습니다.
### 요청 형식
```
POST /api/v1/chat-gpt
Content-Type: application/json

{
    "question" : "'서점은 어디 있어요?' 를 프랑스어로 번역해줘."
}
```
### 응답 형식
```
{
    "id": ...
    "object": "chat.completion",
    "created": 1735575738,
    "model": "gpt-4o-2024-08-06",
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "\"'서점은 어디 있어요?'를 프랑스어로 번역하면 'Où est la librairie?'입니다.\"",
                "refusal": null
            },
            "logprobs": null,
            "finish_reason": "stop"
        }
    ],
    "usage": {
        "prompt_tokens": 33,
        "completion_tokens": 27,
        "total_tokens": 60,
        "prompt_tokens_details": {
            "cached_tokens": 0,
            "audio_tokens": 0
        },
        "completion_tokens_details": {
            "reasoning_tokens": 0,
            "audio_tokens": 0,
            "accepted_prediction_tokens": 0,
            "rejected_prediction_tokens": 0
        }
    },
    "system_fingerprint": ...
}

```
