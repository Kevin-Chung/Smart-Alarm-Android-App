package mobi.smartalarm.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import mobi.smartalarm.R;

public class CreateAlarm extends AppCompatActivity implements View.OnClickListener{

    private Button saveButton, cancelButton;
    private Context context;
    private Place place;
    private CoordinatorLayout coordinatorLayout;
    private EditText alarmName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        saveButton = (Button)findViewById(R.id.save_alarm);
        cancelButton = (Button) findViewById(R.id.cancel_alarm);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator_layout);
        alarmName = (EditText)findViewById(R.id.alarm_name);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                Toast.makeText(context,place.toString(),Toast.LENGTH_SHORT).show();
                //lol
                setPlace(place);
            }

            @Override
            public void onError(Status status) {
                Log.d("error",status.getStatusMessage());
            }
        });

        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

    }

    //lol workarNound
    public void setPlace(Place palce){
        this.place = place;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.save_alarm:{
                Snackbar.make(coordinatorLayout,"save alarm",Snackbar.LENGTH_SHORT).show();
             //   Log.d("place",place.getId());
                if(alarmValid()){
                    //finish
                }
                break;
            }
            case R.id.cancel_alarm:{

                finish();
                break;
            }
        }
    }

    public boolean alarmValid(){
        /*if(place == null){
            return false;
        }if( alarmName.getText().length() == 0){
            return false;
        }*/

        return false;
    }
}
