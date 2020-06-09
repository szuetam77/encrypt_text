package pl.kurs.java.encrypt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ReverseEncryptAlgo.class})
public class ReverseEncryptAlgoTest {

    @Autowired
    private ReverseEncryptAlgo reverseEncryptAlgo;

    @Test
    public void shouldReturnReverseAlgoResult() {
        String text = "abc";
        String result = reverseEncryptAlgo.encrypt(text);
        assertEquals("cba", result);
    }

}