package mobi.smartalarm.ListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mobi.smartalarm.Models.Alarm;
import mobi.smartalarm.R;

/**
 * Created by Kevin on 4/16/2016.
 */
public class AlarmListAdapter extends RecyclerView.Adapter<AlarmListAdapter.ViewHolder> {
    private String[] mDataset;
    private ArrayList<Alarm> data;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView alarmName, alarmArrivalTime, alarmDays, alarmRingTime;
        ImageView alarmIcon;

        public ViewHolder(View v) {
            super(v);
            alarmName = (TextView) v.findViewById(R.id.alarm_name);
            alarmArrivalTime = (TextView) v.findViewById(R.id.alarm_arrival_time);
            alarmDays = (TextView) v.findViewById(R.id.alarm_days);
            alarmRingTime = (TextView) v.findViewById(R.id.alarm_ring_time);
        }
        public void bind(Alarm data){
            alarmName.setText(data.getAlarmName());
            alarmArrivalTime.setText(data.getArrivalTime());
            alarmDays.setText(data.getAlarmDays());
            alarmRingTime.setText(data.getRingTime());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AlarmListAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    public AlarmListAdapter(ArrayList<Alarm> data, Context context) {
        Toast.makeText(context,data.size()+"",Toast.LENGTH_SHORT).show();
        this.data = data;
        this.context = context;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public AlarmListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alarm_list_item, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(data.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return data.size();
    }
}
