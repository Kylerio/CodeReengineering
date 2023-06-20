import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.command.ApplicationCommandOption;
import discord4j.discordjson.json.ApplicationCommandOptionData;
import discord4j.discordjson.json.ApplicationCommandRequest;
import discord4j.rest.RestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws Exception {
        var token = Optional.ofNullable(System.getenv("TOKEN"))
                .orElseThrow(() -> new Exception("Bot token not found."));
        // You shouldn't need to change anything above this

        var slashCommandHandler = new SlashCommandHandler();

        // You shouldn't need to change anything below this
        DiscordClientBuilder.create(token)
                .build()
                .withGateway(gateway -> {
                    var printOnLogin = gateway.on(ReadyEvent.class, event -> Mono.fromRunnable(() -> {
                                var self = event.getSelf();
                                System.out.printf("Logged in as %s#%s%n", self.getUsername(), self.getDiscriminator());
                            }))
                            .then();

                    var handleSlash = gateway.on(ChatInputInteractionEvent.class, slashCommandHandler::handle)
                            .then();

                    registerCommands(gateway.getRestClient());

                    return printOnLogin.and(handleSlash);
                })
                .block();
    }

    private static void registerCommands(RestClient client) {
        final var appId = client.getApplicationId()
                .block();
        if (appId == null) return;

        var qrCommandRequest = CommandBuilder.buildQRCommandRequest();
        var qrSaveRequest = CommandBuilder.buildQRSaveRequest();
        var qrLoadRequest = CommandBuilder.buildQRLoadRequest();

        client.getApplicationService()
                .bulkOverwriteGlobalApplicationCommand(appId, List.of(qrCommandRequest, qrSaveRequest, qrLoadRequest))
                .subscribe();
    }
}

public class CommandBuilder {
    public static ApplicationCommandRequest buildQRCommandRequest() {
        return ApplicationCommandRequest.builder()
                .name("qr")
                .description("encode some text into a QR image")
                .addOption(buildTextOption("text", "text to encode"))
                .build();
    }

    public static ApplicationCommandRequest buildQRSaveRequest() {
        return ApplicationCommandRequest.builder()
                .name("qrsave")
                .description("save a QR with a name")
                .addOption(buildTextOption("text", "text to encode"))
                .addOption(buildTextOption("name", "a unique name to save your QR"))
                .build();
    }

    public static ApplicationCommandRequest buildQRLoadRequest() {
        return ApplicationCommandRequest.builder()
                .name("qrload")
                .description("load a saved QR")
                .addOption(buildTextOption("name", "the name of your saved QR"))
                .build();
    }

    private static ApplicationCommandOptionData buildTextOption(String name, String description) {
        return ApplicationCommandOptionData.builder()
                .name(name)
                .description(description)
                .type(ApplicationCommandOption.Type.STRING.getValue())
                .required(true)
                .build();
    }
}
