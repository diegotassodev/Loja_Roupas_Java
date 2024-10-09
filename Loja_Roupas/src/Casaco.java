import java.util.Calendar;
public class Casaco extends Roupas {
    // Constructor da classe Clasaco
    public Casaco(){
        super(); // Chama o constructor da classe Roupa
    }

    // Métodos do CRUD
    public void criarCasaco(int id, String nome, double valor, String marca, String tipo_roupa, String tamanho, int quantiaEstocada, Calendar   dataEstocada){
        setId(id);
        setNome(nome);
        setValor(valor);
        setMarca(marca);
        setTipo_roupa(tipo_roupa);
        setTamanho(tamanho);
        setQuantiaEstocada(quantiaEstocada);
        setDataEstocada(getDataEstocada());
    }

    // Método pra exibir as informações do casaco
    public void exibirCasaco(){
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Valor: " + getValor());
        System.out.println("Marca: " + getMarca());
        System.out.println("Tipo de roupa: " + getTipo_roupa());
        System.out.println("Tamanho: " + getTamanho());
        System.out.println("Quantia estocada: " + getQuantiaEstocada());
        System.out.println("Data estocada: " + getDataEstocada());
    }

    //Método para atualizar as informações do casaco
    public void atualizarCasaco(String nome, double valor, String marca, String tamanho, int quantiaEstocada){
        setNome(nome);
        setValor(valor);
        setMarca(marca);
        setTamanho(tamanho);
        setQuantiaEstocada(quantiaEstocada);
    }

    //Método para remover o casaco
    public void deletarCasaco(){
        setId(0);
        setNome(null);
        setValor(0);
        setMarca(null);
        setTipo_roupa(null);
        setTamanho(null);
        setQuantiaEstocada(0);
        setDataEstocada(null);
    }
}
