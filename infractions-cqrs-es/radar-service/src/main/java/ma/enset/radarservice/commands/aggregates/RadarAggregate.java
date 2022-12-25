package ma.enset.radarservice.commands.aggregates;

import ma.enset.commonapi.commands.CreateRadarCommand;
import ma.enset.commonapi.commands.UpdateRadarCommand;
import ma.enset.commonapi.events.RadarCreatedEvent;
import ma.enset.commonapi.events.RadarUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RadarAggregate {
    @AggregateIdentifier
    private String id;
    private int maxSpeed;
    private double longitude;
    private double latitude;

    public RadarAggregate() {
    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command) {
        if (command.getMaxSpeed() < 0) {
            throw new RuntimeException("Max Speed must be positive");
        }

        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude()
        ));
    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event) {
        this.id = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();
    }

    @CommandHandler
    public void handle(UpdateRadarCommand command) {
        AggregateLifecycle.apply(new RadarUpdatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude()
        ));
    }

    @EventSourcingHandler
    public void on(RadarUpdatedEvent event) {
        this.maxSpeed = event.getMaxSpeed();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();
    }
}