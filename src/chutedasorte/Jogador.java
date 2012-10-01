package chutedasorte;

import baralho.Carta;

/**
 * Classe que representa um jogador
 * @author Mateus
 */
public class Jogador {

    private String nome;
    private int ponto;
    private Carta carta;

    /**
     * Metodo que retorna o nome do jogador
     *
     * @return Nome do jogador
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo que altera o nome do Jogador
     *
     * @param nome Nome do jogador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo que adiciona um ponto aos pontos do jogador
     */
    public void setUmPonto() {
        this.ponto++;
    }

    /**
     * Metodo que adiciona dois pontos aos pontos do jogador
     */
    public void setDoisPontos() {
        this.ponto = this.ponto + 2;
    }

    /**
     * Metido que retorna os pontos do jogador
     *
     * @return pontos do jogador
     */
    public int getPonto() {
        return this.ponto;
    }

    /**
     * Metodo que Seta uma carta a ser adivinhada
     *
     * @param carta carta a ser adivinhada
     */
    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    /**
     * Metodo para ver o valor da carta
     *
     * @return valor
     */
    public String verValor() {
        return this.carta.toString();
    }
}
