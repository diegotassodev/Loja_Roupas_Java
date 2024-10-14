package parentes_roupas;

import java.util.Calendar;

public class Roupas {
    
    // Atributos Principais
    private int id;
    private String nome;
    private double valor;
    private String marca;
    private String tipo_roupa;
    private String tamanho;
    private int quantiaEstocada;
    private Calendar dataEstocada;
    
    // Construtora
    public Roupas () {
        
    }
    
    // Get e Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo_roupa() {
        return tipo_roupa;
    }

    public void setTipo_roupa(String tipo_roupa) {
        this.tipo_roupa = tipo_roupa;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantiaEstocada() {
        return quantiaEstocada;
    }

    public void setQuantiaEstocada(int quantiaEstocada) {
        this.quantiaEstocada = quantiaEstocada;
    }

    public Calendar getDataEstocada() {
        return dataEstocada;
    }

    public void setDataEstocada(Calendar dataEstocada) {
        this.dataEstocada = dataEstocada;
    }
    
}
