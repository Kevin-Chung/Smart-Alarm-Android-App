package mobi.smartalarm.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import mobi.smartalarm.ListAdapters.AlarmListAdapter;
import mobi.smartalarm.Models.Alarm;
import mobi.smartalarm.R;
import mobi.smartalarm.Utils.RequestCodes;

public class AlarmsListActivity extends AppCompatActivity {

    private RecyclerView alarmList;
    private ArrayList<Alarm> alarms;
    private LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Context context = this;

        alarms = initAlarms();
        Log.d("inside","alarmlistactivity");
        alarmList = (RecyclerView) findViewById(R.id.alarm_list);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        alarmList.setLayoutManager(layoutManager);

        alarmList.setAdapter(new AlarmListAdapter(alarms,context));
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        alarmList.setHasFixedSize(true);



        // create new fab button and bind to the view.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_alarm);

        //add action listener for when button is clicked. Launch activity to create new alarms
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addActivityIntent = new Intent(AlarmsListActivity.this, CreateAlarm.class);
                startActivityForResult(addActivityIntent, RequestCodes.createAlarmCode);
            }
        });
    }

    public ArrayList<Alarm> initAlarms(){
        ArrayList<Alarm> alarmList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            alarmList.add(new Alarm("name "+i,"Expected arrival time"+i, "Expected ring time: "+i,"s m t w t f s"));
        }
        return alarmList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alarms_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
