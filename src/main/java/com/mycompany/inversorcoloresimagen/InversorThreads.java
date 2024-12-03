package com.mycompany.inversorcoloresimagen;

import java.awt.image.BufferedImage;

/* @author Gabriel Murillo */


public class InversorThreads implements Runnable{
    
    private final BufferedImage imagen;
    private final int inicioFila;
    private final int finFila;

    public InversorThreads(BufferedImage imagen, int inicioFila, int finFila) {
        this.imagen = imagen;
        this.inicioFila = inicioFila;
        this.finFila = finFila;
    }

    @Override
    public void run() {
        
    }
    
    
}
