package com.androiddevbook.onyourbike.chapter10.tests;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

import com.androiddevbook.onyourbike.chapter10.IOnYourBike;
import com.androiddevbook.onyourbike.chapter10.R;
import com.androiddevbook.onyourbike.chapter10.activities.TimerActivity;

public class TimerActivityTests extends ActivityUnitTestCase<TimerActivity> {

    private TimerActivity activity;

    public TimerActivityTests() {
        super(TimerActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        setApplication(new MockOnYourBike());
        
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                TimerActivity.class);
        startActivity(intent, null, null);
        activity = getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();

        activity = null;
    }
    
    public void testInitialUI() {
        TextView counter = (TextView) activity.findViewById(R.id.timer);
        Button start = (Button) activity.findViewById(R.id.start_button);
        Button stop = (Button) activity.findViewById(R.id.stop_button);
        Button takePhoto = (Button) activity.findViewById(R.id.photo_button);

        assertNotNull(counter);
        assertNotNull(start);
        assertNotNull(stop);
        assertNotNull(takePhoto);
    }

}
