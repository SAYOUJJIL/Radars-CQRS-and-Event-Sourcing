package ma.enset.commonapi.commands;

import lombok.Getter;

public class CreateRadarCommand extends BaseCommand<String> {

    @Getter private int maxSpeed;
    @Getter private double longitude;
    @Getter private double latitude;

    public CreateRadarCommand(String id, int maxSpeed, double longitude, double latitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
