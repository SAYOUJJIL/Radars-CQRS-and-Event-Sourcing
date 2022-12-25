package ma.enset.radarservice.query.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.commonapi.events.RadarCreatedEvent;
import ma.enset.commonapi.events.RadarUpdatedEvent;
import ma.enset.commonapi.queries.GetAllRadarsQuery;
import ma.enset.commonapi.queries.GetRadarById;
import ma.enset.radarservice.query.entities.Radar;
import ma.enset.radarservice.query.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RadarServiceHandler {
    private RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        log.info("**************************");
        log.info("RadarCreatedEvent received");
        radarRepository.save(new Radar(event.getId(),event.getMaxSpeed(),
                event.getLongitude(),event.getLatitude()));
    }

    @EventHandler
    public void on(RadarUpdatedEvent event){
        log.info("**************************");
        log.info("RadarUpdatedEvent received");
        Radar radar = radarRepository.findById(event.getId()).get();
        radar.setMaxSpeed(event.getMaxSpeed());
        radar.setLongitude(event.getLongitude());
        radar.setLatitude(event.getLatitude());
        radarRepository.save(radar);
    }

/*    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery getAllRadarsQuery){
        return radarRepository.findAll();
    }

    @QueryHandler
    public Radar on(GetRadarById getRadarById){
        return radarRepository.findById(getRadarById.getId()).get();
    }*/
}