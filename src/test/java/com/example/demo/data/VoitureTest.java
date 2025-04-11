package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture voiture = new Voiture("McLaren",2_300_000);
        assertEquals(2_300_000, voiture.getPrix());
        Assert.isTrue("McLaren".equals(voiture.getMarque()), "La voiture doit être une McLaren P1");
    }


}
