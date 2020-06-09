package pl.kurs.java.encrypt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Add1EncryptAlgo.class})
public class Add1EncryptAlgoTest {

    @Autowired
    private Add1EncryptAlgo add1EncryptAlgo;

    @Test
    public void shouldReturnAddAlgoResult() {
        String text = "abc";
        String result = add1EncryptAlgo.encrypt(text);
        assertEquals("bcd", result);
    }

}