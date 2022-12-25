package ma.enset.radarservice.query.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RadarResponseDTO {
    private int maxSpeed;
    private double longitude;
    private double latitude;
}
