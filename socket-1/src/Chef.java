import java.io.Serializable;
import java.util.Random;

public class Chef implements Serializable {
    String message;
    String dish;
    String nextMessage;
    String exitMessage;
    int time;
    String quality;
    String[] qualityLabel = new String[]{"丸焦げの","ふつうの","とっても美味しそうな"};

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getNextMessage(){
        return nextMessage;
    }

    public void setNextMessage(String nextMessage){
        this.nextMessage = nextMessage;
    }

    public String getExitMessage(){
        return exitMessage;
    }

    public void setExitMessage(String exitMessage){
        this.exitMessage = exitMessage;
    }

    public int getTime() {
        return this.time;
    }

    public String getQuality(){
        return this.quality;
    }

    public void cook(){
        this.time = new Random().nextInt(20);
        this.quality = qualityLabel[new Random().nextInt(3)];
    }
}
