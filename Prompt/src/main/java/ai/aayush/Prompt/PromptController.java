package ai.aayush.Prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptController
{

    private final ChatClient chatClient;

    public PromptController(ChatClient.Builder builder)
    {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String generate()
    {
        return chatClient
                .prompt("Tell me a joke")
                .call().content();
    }
}