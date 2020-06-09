package pl.kurs.java.encrypt.service;

import org.springframework.stereotype.Service;

@Service
public class Swap_N_1EncryptAlgo implements EncryptAlgo {

    @Override
    public String encrypt(String source) {
        char[] array = source.toCharArray();
        for (int i = 1; i < array.length; i+= 2) {
            char swap = array[i];
            array[i] = array[i - 1];
            array[i - 1] = swap;
        }
        return new String(array);
    }

    @Override
    public String key() {
        return "SWAP_N_1";
    }

    @Override
    public String description() {
        return "Swap chars";
    }
}
