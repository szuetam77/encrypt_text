package pl.kurs.java.encrypt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kurs.java.encrypt.error.ValidAlgo;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncryptRequest {

    @NotEmpty
    private String text;
    @NotEmpty
    @ValidAlgo
    private String algo;

}
