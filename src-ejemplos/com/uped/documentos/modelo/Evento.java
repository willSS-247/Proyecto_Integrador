package com.uped.documentos.modelo;

interface Registro {
    default String etiqueta() {
        return "REG";
    }
}
interface Auditoria {
    default String etiqueta() {
        return "AUD";
    }
}

public class Evento implements Registro, Auditoria{
    @Override
    public String etiqueta(){
    return Registro.super.etiqueta() + " + " + Auditoria.super.etiqueta();
}
}