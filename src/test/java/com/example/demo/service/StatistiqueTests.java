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
    StatistiqueImpl statistiqueImpl;

    @Test
    void getPrixMockBean(){
        Voiture voiture = new Voiture("Opel",2000);
        when(voiture.getPrix()).thenReturn(1);
        assertEquals(1, voiture.getPrix());
    }

    @Test
    void testPrixMoyen(){
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(2,1));
        Voiture voiture = new Voiture("Opel",2000);
        Voiture voiture2 = new Voiture("Mclaren",2_000_000);
        statistiqueImpl.ajouter(voiture);
        statistiqueImpl.ajouter(voiture2);
        assertEquals(1, statistiqueImpl.prixMoyen().prixMoyen);
    }
}
