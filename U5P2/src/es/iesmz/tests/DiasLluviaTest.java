package es.iesmz.tests;

import java.util.concurrent.atomic.DoubleAccumulator;

import static org.junit.jupiter.api.Assertions.*;

class DiasLluviaTest {

    DiasLluvia date = new DiasLluvia();

    @org.junit.jupiter.api.Test
    void registroDia1() {
        boolean resultadoReal = date.registroDia(0,0, true);
        boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void registroDia2() {
        boolean resultadoReal = date.registroDia(2,11, true);
        boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void registroDia3() {
        boolean resultadoReal = date.registroDia(-2,14, true);
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultadoReal);
    }


    @org.junit.jupiter.api.Test
    void consultarDia1() {
        date.registroDia(0,0,true);
        boolean resultadoReal = date.consultarDia(0,0);
        boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void consultarDia2() {
        date.registroDia(5,2,true);
        boolean resultadoReal = date.consultarDia(5,2);
        boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void consultarDia3() {
        date.registroDia(4,4,true);
        boolean resultadoReal = date.consultarDia(5,5);
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultadoReal);
    }


    @org.junit.jupiter.api.Test
    void contarDiasLluviosos1() {
        date.registroDia(0,0,true);
        date.registroDia(1,1,true);
        date.registroDia(2,2,true);
        date.registroDia(4,4,true);
        int resultadoReal = date.contarDiasLluviosos();
        int resultadoEsperado = 4;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void contarDiasLluviosos2() {
        date.registroDia(0,0,true);
        date.registroDia(1,1,true);
        date.registroDia(2,2,true);
        int resultadoReal = date.contarDiasLluviosos();
        int resultadoEsperado = 3;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void contarDiasLluviosos3() {
        int resultadoReal = date.contarDiasLluviosos();
        int resultadoEsperado = 0;
        assertEquals(resultadoEsperado, resultadoReal);
    }


    @org.junit.jupiter.api.Test
    void trimestreLluvioso1() {
        date.registroDia(0,0,true);
        date.registroDia(1,0,true);
        date.registroDia(4,1,true);
        date.registroDia(1,4,true);
        int resultadoReal = date.trimestreLluvioso();
        int resultadoEsperado = 0;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void trimestreLluvioso2() {
        date.registroDia(0,0,true);
        date.registroDia(10,10,true);
        date.registroDia(11,9,true);
        date.registroDia(2,11,true);
        date.registroDia(11,3,true);

        int resultadoReal = date.trimestreLluvioso();
        int resultadoEsperado = 3;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void trimestreLluvioso3() {
        date.registroDia(0,0,true);
        date.registroDia(1,5,true);
        date.registroDia(3,3,true);
        date.registroDia(3,4,true);

        int resultadoReal = date.trimestreLluvioso();
        int resultadoEsperado = -1;
        assertEquals(resultadoEsperado, resultadoReal);
    }


    @org.junit.jupiter.api.Test
    void primerDiaLluvia1() {
        date.registroDia(0,1,true);
        date.registroDia(4,7,true);
        date.registroDia(3,23,true);
        date.registroDia(4,24,true);
        int resultadoReal = date.primerDiaLluvia();
        int resultadoEsperado = 1;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void primerDiaLluvia2() {
        date.registroDia(1,1,true);
        date.registroDia(4,7,true);
        date.registroDia(3,23,true);
        date.registroDia(4,24,true);
        int resultadoReal = date.primerDiaLluvia();
        int resultadoEsperado = 31;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @org.junit.jupiter.api.Test
    void primerDiaLluvia3() {
        date.registroDia(5,29,true);
        int resultadoReal = date.primerDiaLluvia();
        int resultadoEsperado = 179;
        assertEquals(resultadoEsperado, resultadoReal);
    }
}