package org.modelo.radar;

import org.modelo.Comprable;

import org.modelo.ListaJugadores;

import java.util.ArrayList;

public class Radar3x3 extends Radar implements Comprable{
    private final int precio = 10;

    public Radar3x3() {
        super(1);
    }

    private boolean posValida(int pPos, int pAnchuraTablero){
        if(pPos >= 0 && pPos < pAnchuraTablero * pAnchuraTablero) return true;
        return false;
    }

    @Override
    public ArrayList<Integer> obtenerPosicionesReveladas(int pAnchuraTablero, boolean pEnemigo) {
        ArrayList<Integer> area = new ArrayList<Integer>();
        area.add(posRadar);


        if(sePuedeUtilizar()){
            if(posValida(posRadar-10, pAnchuraTablero)&&(posRadar/10-(posRadar-10)/10)==1){
                    area.add(posRadar-10);

            }
            if((posValida(posRadar+10, pAnchuraTablero)&&(posRadar/10-(posRadar+10)/10)==-1)){
                    area.add(posRadar+10);

            }if(posValida(posRadar-1, pAnchuraTablero)&&((posRadar-1)/10==posRadar/10)){
                    area.add(posRadar-1);
            }
            if(posValida(posRadar+1, pAnchuraTablero)&&((posRadar+1)/10==posRadar/10)){
                    area.add(posRadar+1);
            }
            if((posValida(posRadar+11, pAnchuraTablero)&&(posRadar/11-(posRadar+11)/11)==-1)&&posRadar%10!=9){
                    area.add(posRadar+11);
            }
            if((posValida(posRadar-11, pAnchuraTablero)&&(posRadar/11-(posRadar-11)/11)==1&&posRadar%10!=0)){
                    area.add(posRadar-11);
            }
            if((posValida(posRadar-9, pAnchuraTablero)&&(posRadar/9-(posRadar-9)/9)==1)&&posRadar%10!=9){
                    area.add(posRadar-9);
            }
            if((posValida(posRadar+9, pAnchuraTablero)&&(posRadar/9-(posRadar+9)/9)==-1)&&posRadar%10!=0){
                    area.add(posRadar+9);
            }

            decrementarNumUsos();
        }

        posicionesUsos.addAll(area);
        //cambiarPosicionRadar(pEnemigo);
        if(pEnemigo){
            ListaJugadores.getInstance().getEntidad(1).quitarRadar(posRadar);
        }
        else{
            ListaJugadores.getInstance().getEntidad(0).quitarRadar(posRadar);
        }

        return area;
    }


    // ------- Tienda -------
    // Los objetos del jugador y del enemigo incrementan su numero de usos al comprar
    @Override
    public void comprar(){
        incrementarNumUsos();
    }
}
