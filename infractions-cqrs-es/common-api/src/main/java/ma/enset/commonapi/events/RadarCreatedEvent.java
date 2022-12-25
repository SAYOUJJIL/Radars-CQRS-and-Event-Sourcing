package ma.enset.commonapi.events;

import lombok.Getter;

public class RadarCreatedEvent extends BaseEvent<String> {
    @Getter private int maxSpeed;
    @Getter private double longitude;
    @Getter private double latitude;

    public RadarCreatedEvent(String id, int maxSpeed, double longitude, double latitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
