package ma.enset.immatriculationservice.query.controllers;


import lombok.AllArgsConstructor;
import ma.enset.commonapi.queries.GetAllVehiculesQuery;
import ma.enset.commonapi.queries.GetVehiculeById;
import ma.enset.immatriculationservice.query.entities.Vehicule;
import ma.enset.immatriculationservice.query.repositories.VehiculeRepository;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule/queries")
@CrossOrigin("*")
public class VehiculeQueryController {
    private QueryGateway queryGateway;
    private VehiculeRepository vehiculeRepository;

    @GetMapping("/allVehicules")
    public List<Vehicule> getAllVehicules() {
        return queryGateway.query(new GetAllVehiculesQuery(), ResponseTypes.multipleInstancesOf(Vehicule.class)).join();
    }

    @QueryHandler
    public List<Vehicule> on(GetAllVehiculesQuery query) {
        return vehiculeRepository.findAll();
    }

    @GetMapping("/getVehicule/{id}")
    public Vehicule getVehicule(@PathVariable String id) {
        return queryGateway.query(new GetVehiculeById(id),ResponseTypes.instanceOf(Vehicule.class)).join();
    }

    @QueryHandler
    public Vehicule on(GetVehiculeById query) {
        return vehiculeRepository.findById(query.getId()).orElse(null);
    }
    
}
