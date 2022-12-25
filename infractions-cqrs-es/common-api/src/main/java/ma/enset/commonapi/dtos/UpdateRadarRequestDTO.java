package ma.enset.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRadarRequestDTO {
    private String id;
    private int maxSpeed;
    private double longitude;
    private double latitude;
}
