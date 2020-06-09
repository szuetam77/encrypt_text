package pl.kurs.java.encrypt.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseEncryptAlgo implements EncryptAlgo {

    @Override
    public String encrypt(String source) {
        return new StringBuilder(source).reverse().toString();
    }

    @Override
    public String key() {
        return "REVERSE";
    }

    @Override
    public String description() {
        return "Reverse current string";
    }
}
