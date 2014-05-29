import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.androiddevbook.onyourbike.chapter10.model.TimerState;

public class TimerStateTests {

    private TimerState timer;

    public TimerStateTests() {
    }

    @Before
    public void setUp() throws Exception {
        timer = new TimerState();
    }

    @After
    public void tearDown() throws Exception {
        timer = null;
    }
    
    private void delay() {
    	try {
    		Thread.sleep(1000);
    	}
    	catch (InterruptedException e) {
    		// do nothing
    	}
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
        delay();
        assertTrue("ElapsedTime is not 0", timer.elapsedTime() > 0);
    }
}
