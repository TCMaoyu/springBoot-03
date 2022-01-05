package cn.whut.springboot03.pojo;

public class Data {
    public int id;

    public String orderId;

    public long beginTime;

    public long endTime;

    public float beginLon;

    public float beginLat;

    public float endLon;

    public float endLat;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public float getBeginLon() {
        return beginLon;
    }

    public void setBeginLon(float beginLon) {
        this.beginLon = beginLon;
    }

    public float getBeginLat() {
        return beginLat;
    }

    public void setBeginLat(float beginLat) {
        this.beginLat = beginLat;
    }

    public float getEndLon() {
        return endLon;
    }

    public void setEndLon(float endLon) {
        this.endLon = endLon;
    }

    public float getEndLat() {
        return endLat;
    }

    public void setEndLat(float endLat) {
        this.endLat = endLat;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", beginLon=" + beginLon +
                ", beginLat=" + beginLat +
                ", endLon=" + endLon +
                ", endLat=" + endLat +
                '}';
    }
}
