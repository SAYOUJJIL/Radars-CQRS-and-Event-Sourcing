package ma.enset.commonapi.events;

import lombok.Getter;

public class RadarUpdatedEvent extends BaseEvent<String>{
    @Getter private int maxSpeed;
    @Getter private double longitude;
    @Getter private double latitude;

    public RadarUpdatedEvent(String id, int maxSpeed, double longitude, double latitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
