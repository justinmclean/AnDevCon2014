import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimerStateTests {

    private TimerStateTestable timer;

    public TimerStateTests() {
    }

    @Before
    public void setUp() throws Exception {
        timer = new TimerStateTestable();
    }

    @After
    public void tearDown() throws Exception {
        timer = null;
    }

    @Test
    public void initialState() {
        assertTrue("ElapsedTime is 0", timer.elapsedTime() == 0);
        assertTrue("Seconds is 0", timer.seconds() == 0);
        assertTrue("Minutes is 0", timer.minutes() == 0);
        assertTrue("Hours is 0", timer.hours() == 0);
        assertTrue("IsRunning is false", timer.isRunning() == false);
    }

    @Test
    public void timerStarted() {
        timer.start();
        assertTrue("IsRunning is true", timer.isRunning() == true);
        timer.setElapsedTime(1000);
        assertTrue("ElapsedTime is not 0", timer.elapsedTime() > 0);
    }
    
    @Test
    public void displayTime() {
        timer.setElapsedTime(2 * 1000 * 60 * 60 + 25 * 1000 * 60 + 7 * 1000);
        timer.stop();
        assertTrue("Time is correct", timer.display().equals("2:25:07"));
    }

}
