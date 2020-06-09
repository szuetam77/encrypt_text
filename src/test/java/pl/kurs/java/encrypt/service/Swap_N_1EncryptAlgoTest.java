package pl.kurs.java.encrypt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Swap_N_1EncryptAlgo.class})
public class Swap_N_1EncryptAlgoTest {

    @Autowired
    private Swap_N_1EncryptAlgo swap_n_1EncryptAlgo;

    @Test
    public void shouldReturnSwapAlgoResult() {
        String text = "abc";
        String result = swap_n_1EncryptAlgo.encrypt(text);
        assertEquals("bac", result);
    }
}