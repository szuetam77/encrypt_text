package pl.kurs.java.encrypt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EncryptAlgoInfoReponse {
    private String name;
    private String description;
}
