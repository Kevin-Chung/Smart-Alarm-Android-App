package mobi.smartalarm.Models;

/**
 * Created by Kevin on 5/18/2016.
 */
public class Alarm {
    private String alarmName;
    private String arrivalTime;
    private String activateTime;
    private String alarmDays;

    public Alarm(String alarmName, String arrivalTime, String activateTime, String alarmDays) {
        this.alarmName = alarmName;
        this.arrivalTime = arrivalTime;
        this.activateTime = activateTime;
        this.alarmDays = alarmDays;

    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(String activateTime) {
        this.activateTime = activateTime;
    }

    public String getAlarmDays() {
        return alarmDays;
    }

    public void setAlarmDays(String alarmDays) {
        this.alarmDays = alarmDays;
    }
}
