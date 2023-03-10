package es.iesmz.tests;

import java.lang.reflect.Array;

public class DiasLluvia {
    private boolean[][] date = new boolean[12][30];

    public boolean registroDia(int mes, int dia, boolean lluvia) {
        if (mes < 12 && mes >= 0 && dia < 30 && dia >= 0){
            date[mes][dia] = true;
            return date[mes][dia];
        } else return false;
    }

    public boolean consultarDia(int mes, int dia) {
        return date[mes][dia];
    }

    public int contarDiasLluviosos() {
        int contDias = 0;
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date[i].length; j++) {
                if (date[i][j]) {
                    contDias++;
                }
            }
        }
        return contDias;
    }

    public int trimestreLluvioso() {
        int lluviaInvierno = 0;
        int lluviaPrimavera = 0;
        int lluviaVerano = 0;
        int lluviaOtonyo = 0;
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date[i].length; j++) {
                if (i <= 2 && date[i][j]) {
                    lluviaInvierno++;
                } else if (i > 2 && i <= 5 && date[i][j]) {
                    lluviaPrimavera++;
                } else if (i > 5 && i <= 8 && date[i][j]) {
                    lluviaVerano++;
                } else if (i > 8 && i <= 11 && date[i][j]){
                    lluviaOtonyo++;
                }
            }
        }
        int MAYOR_DIAS = Integer.MIN_VALUE;
        int CANT_DIAS = -2;
        int[] estaciones = {lluviaInvierno, lluviaPrimavera, lluviaVerano, lluviaOtonyo};
        for (int i = 0; i < estaciones.length; i++) {
            if (CANT_DIAS < estaciones[i]){
                CANT_DIAS = estaciones[i];
                MAYOR_DIAS = i;
            } else if (CANT_DIAS == estaciones[i]){
                MAYOR_DIAS = -1;
            }
        }
        return MAYOR_DIAS;
    }

    public int primerDiaLluvia() {
        int dia = Integer.MIN_VALUE;
        int Primerdia = 0;
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date[i].length; j++) {
                if (date[i][j]) {
                    if (dia < Primerdia){
                        dia = (i * 30) + j;
                        Primerdia = dia;
                    }
                }
            }
        }
        return dia;
    }
}
