import java.io.Serializable;
public class TaskObject implements Serializable, ITask{
    int input;
    int result;

    @Override
    public void setExecNumber(int x) {
        this.input = x;
    }

    @Override
    public void exec() {
        if(this.input==1){
            this.result = 1;
            return;
        }
        int i = this.input;
        while(true){
            if(PrimeChecker.isPrime(i)){
                this.result = i;
                return;
            }
            i--;
        }
    }

    @Override
    public int getResult() {
        return result;
    }
    
}
