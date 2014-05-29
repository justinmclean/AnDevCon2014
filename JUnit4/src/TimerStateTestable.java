import com.androiddevbook.onyourbike.chapter10.model.TimerState;


public class TimerStateTestable extends TimerState {
    private long fakeTime = -1;

    public void setElapsedTime(long time) {
        fakeTime = time;
    }

    @Override
    public long elapsedTime() {
        if (fakeTime == -1) {
            return super.elapsedTime();
        } else {
            return fakeTime;
        }
    }
}
