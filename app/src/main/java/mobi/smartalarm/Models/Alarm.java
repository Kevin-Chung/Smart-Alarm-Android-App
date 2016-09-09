package mobi.smartalarm.Models;

/**
 * Created by Kevin on 5/18/2016.
 */
public class Alarm {
    private String alarmName;
    private String arrivalTime;
    private String ringTime;
    private String alarmDays;

    public Alarm(String alarmName, String arrivalTime, String ringTime, String alarmDays) {
        this.alarmName = alarmName;
        this.arrivalTime = arrivalTime;
        this.ringTime = ringTime;
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

    public String getRingTime() {
        return ringTime;
    }

    public void setRingTime(String ringTime) {
        this.ringTime = ringTime;
    }

    public String getAlarmDays() {
        return alarmDays;
    }

    public void setAlarmDays(String alarmDays) {
        this.alarmDays = alarmDays;
    }
}
