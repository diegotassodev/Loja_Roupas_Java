package modelos;

import java.util.Calendar;

public class NotaFiscal {
    
    // Atributos Principais
    private int idProdutoComprado;
    private int idClienteComprador;
    public int quantiaComprada;
    public double valorCompra;
    public Calendar dataComprada;
    
    public NotaFiscal () {
        
    }
    
    // Get e Set
    public int getIdProdutoComprado() {
        return idProdutoComprado;
    }

    public void setIdProdutoComprado(int idProdutoComprado) {
        this.idProdutoComprado = idProdutoComprado;
    }

    public int getIdClienteComprador() {
        return idClienteComprador;
    }

    public void setIdClienteComprador(int idClienteComprador) {
        this.idClienteComprador = idClienteComprador;
    }

    public int getQuantiaComprada() {
        return quantiaComprada;
    }

    public void setQuantiaComprada(int quantiaComprada) {
        this.quantiaComprada = quantiaComprada;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Calendar getDataComprada() {
        return dataComprada;
    }

    public void setDataComprada(Calendar dataComprada) {
        this.dataComprada = dataComprada;
    }
    
}
