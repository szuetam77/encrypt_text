package pl.kurs.java.encrypt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.kurs.java.encrypt.model.EncryptRequest;
import pl.kurs.java.encrypt.service.Add1EncryptAlgo;
import pl.kurs.java.encrypt.service.ReverseEncryptAlgo;
import pl.kurs.java.encrypt.service.Swap_N_1EncryptAlgo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest({EncryptController.class, Add1EncryptAlgo.class, ReverseEncryptAlgo.class, Swap_N_1EncryptAlgo.class})
public class EncryptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void shouldReturnAllAlgos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/encrypt/algos")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAddAlgo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/encrypt/algos")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is("ADD_1")));
    }

    @Test
    public void getSwapAlgo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/encrypt/algos")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", is("SWAP_N_1")));
    }

    @Test
    public void getReverseAlgo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/encrypt/algos")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name", is("REVERSE")));
    }

    @Test
    public void postReverseAlgo() throws Exception {
        String url = "/encrypt/";
        EncryptRequest request = new EncryptRequest();
        request.setText("testodwracania");
        request.setAlgo("REVERSE");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(request);

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    public void postAddAlgo() throws Exception {
        String url = "/encrypt/";
        EncryptRequest request = new EncryptRequest();
        request.setText("testdodawania");
        request.setAlgo("ADD_1");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(request);

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postSwapAlgo() throws Exception {
        String url = "/encrypt/";
        EncryptRequest request = new EncryptRequest();
        request.setText("testprzesuwania");
        request.setAlgo("SWAP_N_1");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(request);

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }


}