package org.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Tienda {
    private static Tienda miTienda = null;
    private HashMap<EObjetoComprable, Integer> precios;
    private ArrayList<EObjetoComprable> stock;

    private Tienda(){
        precios = new HashMap<EObjetoComprable, Integer>();
        precios.put(EObjetoComprable.BOMBAONETAP,3);
        precios.put(EObjetoComprable.RADAR3x3,2);
        stock = new ArrayList<EObjetoComprable>();
        for(int i=0;i<5;i++){
            stock.add(EObjetoComprable.BOMBAONETAP);
            stock.add(EObjetoComprable.RADAR3x3);
        }
    }

    public static Tienda getInstance(){
        if(miTienda == null) miTienda = new Tienda();
        return miTienda;
    }

    public boolean sePuedeComprar(EObjetoComprable pObjeto, int dineroDisponible){
        // PRE: Recibe como parámetros el objeto a comprar y el dinero disponibl
        // POST: Devuelve un booleano indicando si la compra se puede realizar
        Integer precio = precios.get(pObjeto);
        boolean compraSatisfactoria = precio <= dineroDisponible;
        if(compraSatisfactoria){
            compraSatisfactoria = stock.contains(pObjeto);
        }

        return compraSatisfactoria;
    }

    public int comprar(EObjetoComprable pObjeto, int dineroDisponible){
        // POST: Actualiza el stock y devuelve el dinero después de la compra
        stock.remove(pObjeto);
        Integer precio = precios.get(pObjeto);
        System.out.println(precio);
        return dineroDisponible - precio;

    }

    public int obtNumArmamento(EObjetoComprable pObjeto){
        int numObjeto=0;
        for(EObjetoComprable objeto:stock){
            if(objeto.equals(pObjeto)){
                numObjeto++;
            }
        }
        return numObjeto;
    }
    public int getPrecio(EObjetoComprable armamento){
        return precios.get(armamento);
    }
}
