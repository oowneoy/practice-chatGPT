package example.chatGPT.model.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatGPTRequest {

    private String model;
    private List<Message> messages;
    private float temperature;

    public ChatGPTRequest(String model, String prompt, float temperature) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
        this.temperature = temperature;
    }
}
