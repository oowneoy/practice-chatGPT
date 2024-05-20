package example.chatGPT.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.chatGPT.config.ChatGPTConfig;
import example.chatGPT.model.request.ChatGPTRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatGPTService {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.url}")
    private String url;

    private final ChatGPTConfig chatGPTConfig;

    public ResponseEntity<String> sendMessage(String message) {
        HttpHeaders httpHeaders = chatGPTConfig.httpHeaders();
        String requestBody = "";
        ChatGPTRequest chatGPTRequest = new ChatGPTRequest(model, message, 1.0f);

        try {
            requestBody = toJsonString(chatGPTRequest);
            HttpEntity httpEntity = new HttpEntity(requestBody, httpHeaders);

            return chatGPTConfig.restTemplate().exchange(
                    url,
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String toJsonString(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
