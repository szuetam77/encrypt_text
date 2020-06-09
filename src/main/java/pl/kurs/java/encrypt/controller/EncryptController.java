package pl.kurs.java.encrypt.controller;

import org.springframework.web.bind.annotation.*;
import pl.kurs.java.encrypt.model.EncryptAlgoInfoReponse;
import pl.kurs.java.encrypt.model.EncryptRequest;
import pl.kurs.java.encrypt.service.EncryptAlgo;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class EncryptController {

    private final Map<String, EncryptAlgo> encryptAlgos;

    public EncryptController(Set<EncryptAlgo> allAlgos) {
        this.encryptAlgos = allAlgos.stream().collect(Collectors.toMap(EncryptAlgo::key, Function.identity()));
    }

    @GetMapping("/encrypt/algos")
    public List<EncryptAlgoInfoReponse> getAll() {
        return encryptAlgos.values().stream().map(algo -> EncryptAlgoInfoReponse.builder()
                .name(algo.key())
                .description(algo.description())
                .build()).collect(Collectors.toList());
    }


    @PostMapping("/encrypt")
    public String encryptText(@RequestBody @Valid EncryptRequest request) {
        return encryptAlgos.get(request.getAlgo()).encrypt(request.getText());
    }
}