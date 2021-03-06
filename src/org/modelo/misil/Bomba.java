package org.modelo.misil;

import java.util.ArrayList;

public class Bomba extends Misil {

    public Bomba() {
        super(998, true, ETipoMisil.BOMBA);
    }

    // Obtener el area del disparo
    public ArrayList<Integer> obtArea(int pPosicionDisparo, int pAnchuraTablero){
        ArrayList<Integer> listaInt = new ArrayList<Integer>();

        if(sePuedeDisparar()){
            listaInt.add(pPosicionDisparo);

            decrementarNumMisiles();
        }

        return listaInt;
    }
}