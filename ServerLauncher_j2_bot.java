import org.jibble.pircbot.*;

public class ServerLauncher_j2_bot extends PircBot {
    
    public ServerLauncher_j2_bot(String mah_name) {
        this.setName(mah_name);
        newmsgs="";
    }
    
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        if (message.equalsIgnoreCase("!help")) {
            sendMessage(channel, sender + ": I am here to set you free.");
        }
        String[] parts=message.split(" ");
        if (parts[0].equalsIgnoreCase("!msg") ){
            String damessage = "";
            for(int $x=1;$x<parts.length;$x++)
            {
              damessage+=" "+parts[$x];
            }
            if(addMsg(damessage,sender))
            {
              sendMessage(channel,"[IRC] "+sender+":"+damessage);
            }
            else
            {
              sendMessage(channel,sender+": Your message was too long. The limit's closer to 90 characters");
            }
        }
    }
    public String[] getNewMsgs()
    {
      String thenewmsgs=newmsgs;
      newmsgs="";
      String[] thenewmsgs_arr=thenewmsgs.split("!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#$%");
      return thenewmsgs_arr;
    }
    public boolean addMsg(String thenewmsg,String theuser)
    {
      String combined="[IRC] "+theuser+":"+thenewmsg;
      if(combined.length() > 95)
      {
        return false;
      }
      else
      {
        if(newmsgs==""){
          newmsgs=combined;
        }
        else{
          newmsgs+="!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#$%"+combined;
        }
        return true;
      }
      
    }
    public boolean hasMsg()
    {
      return newmsgs!="";
    }
    private String newmsgs;
}
