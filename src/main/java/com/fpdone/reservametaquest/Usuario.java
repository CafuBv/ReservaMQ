package com.fpdone.reservametaquest;

import java.util.Objects;

public class Usuario {

    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private int cantidad;


    public Usuario(String nombre, String fechaInicio, String fechaFin, int cantidad) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(fechaInicio, usuario.fechaInicio) && Objects.equals(fechaFin, usuario.fechaFin) && Objects.equals(cantidad, usuario.cantidad);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
