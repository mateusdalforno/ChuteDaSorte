package chutedasorte;

import baralho.Baralho;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Classe que executa o jogo "chute da Sorte"
 *
 * @author Mateus
 */
public class Jogo {

    private String opcao;
    Scanner teclado = new Scanner(System.in);

    /**
     * Metodo construtor da Classe Jogo.
     */
    public Jogo() {

    }

    /**
     * Metodo que chama o menu do jogo
     */
    public void menu() {

        opcao = "";

        System.out.println("==================================================");
        System.out.println("                CHUTE DA SORTE");
        System.out.println();
        System.out.println();
        System.out.println("1 - Jogar");
        System.out.println("2 - Regras");
        System.out.println("Q - Sair");
        System.out.println();
        System.out.print("Digite uma opcao: ");
        opcao = teclado.next();

        opcao = opcao.toUpperCase();

        switch (opcao) {
            case "1": {
                this.jogar();
                break;
            }
            case "2": {
                this.verRegras();
                break;
            }
            case "Q": {
                System.out.println("==================================================");
                System.out.println(" Obrigado por jogar o jogo. Ate a proxima! ");
                System.out.println();
                System.out.println();
                System.exit(0);
            }
            default: {
                System.out.println("Digite uma opção valida!");
                this.menu();
            }
        }
    }

    private void jogar() {
        System.out.println("==================================================");
        System.out.println("                CHUTE DA SORTE");
        System.out.println();
        Jogador jogador = new Jogador();
        System.out.print("Digite o seu nome: ");
        String nome = teclado.next();
        jogador.setNome(nome);

        Baralho baralho = new Baralho();
        baralho.embaralhar();
        String valor;
        String naipe;
        int j = 1;
        for (int i = 0; i < 52; i++) {
            System.out.println("-------------------------------");
            System.out.println("Rodada " + j);
            jogador.setCarta(baralho.getPrimeiraCarta());

            System.out.println("CARTA SELECIONADA!");

            System.out.println("Valores: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13.");
            System.out.println("Naipes: OUROS, PAUS, ESPADAS, COPAS.");
            System.out.println("Para encerrar o jogo, digite 'Q'");
            System.out.print("Digite o valor: ");
            valor = teclado.next();
            valor = valor.toUpperCase();
            if (valor.equals("Q")) {
                break;
            }

            System.out.print("Digite o naipe: ");
            naipe = teclado.next();

            naipe = naipe.toUpperCase();

            if (naipe.equals("Q")) {
                break;
            }
            String valorReal[] = jogador.verValor().split(Pattern.quote(", "));

            if (valor.equals(valorReal[0]) && naipe.equals(valorReal[1])) {
                jogador.setDoisPontos();
            } else if (valor.equals(valorReal[0])) {
                jogador.setUmPonto();
            } else if (naipe.equals(valorReal[1])) {
                jogador.setUmPonto();
            }
            System.out.println("A carta era: " + jogador.verValor());
            System.out.println("Seus pontos: " + jogador.getPonto());
            j++;
        }
        System.out.println("==================================================");
        System.out.println("                FIM DE JOGO");
        System.out.println("Seus pontos: " + jogador.getPonto());
        this.menu();
    }

    private void verRegras() {
        System.out.println("==================================================");
        System.out.println("                REGRAS DO JOGO");
        System.out.println();
        System.out.println();
        System.out.println("O jogo e baseado em adivinhacao. O jogador deve ");
        System.out.println("adivinhar qual e a naipe e o valor de uma de-");
        System.out.println("terminada carta que o sistema escolher.");
        System.out.println("Caso o jogador acerte o naipe e o valor, o mesmo");
        System.out.println("ganha 2 pontos, caso acerte o valor ou o naipe,");
        System.out.println("recebe 1 ponto.");
        System.out.println("Ao final, o sistema informa o resultado do jogo.");
        System.out.println();
        System.out.println();

        this.menu();
    }
}
