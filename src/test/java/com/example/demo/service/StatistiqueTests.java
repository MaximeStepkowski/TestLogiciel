package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @MockBean
    Voiture voiture;

    @Test
    void testGetPrix(){
        Voiture voiture = new Voiture("Opel",2_000);
        assertEquals(2_000, voiture.getPrix());
    }

    @Test
    void testPrixMoyen(){
        StatistiqueImpl statistiqueImpl = new StatistiqueImpl();

        when(voiture.getPrix()).thenReturn(2_000);

        Voiture voiture2 = mock(Voiture.class);
        when(voiture2.getPrix()).thenReturn(2_000_000);

        statistiqueImpl.ajouter(voiture);
        statistiqueImpl.ajouter(voiture2);

        assertEquals(1_001_000, statistiqueImpl.prixMoyen().prixMoyen);
    }
}
