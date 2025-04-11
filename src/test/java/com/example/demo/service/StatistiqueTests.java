package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    void test_ajouter(){
        doNothing().when(statistiqueImpl).ajouter(new Voiture("McLaren", 2_000_000));
    }

    @Test
    void test_prix_moyen_throw() {
        doThrow(ArithmeticException.class).when(statistiqueImpl).prixMoyen();
    }

    @Test
    void test_prix_moyen_une_voiture() {
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Opel",2000));
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(1, 2000));
    }

    @Test
    void test_prix_moyen_plusieurs_voitures() {
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Opel",2000));
        doNothing().when(statistiqueImpl).ajouter(new Voiture("Mclaren",2_000_000));
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(2, 1_001_000));
    }
}
