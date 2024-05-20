package example.chatGPT.controller;

import example.chatGPT.service.ChatGPTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat-gpt")
@Slf4j
public class ChatGPTController {
    private final ChatGPTService chatGPTService;

    @PostMapping
    public ResponseEntity<String> test(@RequestBody String question) {
        log.info("question: {}", question);
        return chatGPTService.sendMessage(question);
    }
}
