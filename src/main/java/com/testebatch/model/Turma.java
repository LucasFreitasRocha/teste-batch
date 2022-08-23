package com.testebatch.model;

public class Turma {
    private Long id;
    private String Codigo;
    private String name;

    public Turma() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", Codigo='" + Codigo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
