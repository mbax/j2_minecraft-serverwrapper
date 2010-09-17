import org.jibble.pircbot.*;

public class ServerLauncher_j2_bot extends PircBot {
    
    public ServerLauncher_j2_bot() {
        this.setName("j2server_mc2");
    }
    
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        if (message.equalsIgnoreCase("!help")) {
            sendMessage(channel, sender + ": I am here to set you free.");
        }
    }
}
