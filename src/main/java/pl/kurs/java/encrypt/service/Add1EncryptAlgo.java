package pl.kurs.java.encrypt.service;

import org.springframework.stereotype.Service;

@Service
public class Add1EncryptAlgo implements EncryptAlgo {

    @Override
    public String encrypt(String source) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i]++;
        }
        return new String(chars);
    }

    @Override
    public String key() {
        return "ADD_1";
    }

    @Override
    public String description() {
        return "Adding +1 to each character according to ASCII table";
    }
}
