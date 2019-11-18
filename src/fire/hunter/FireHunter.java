package fire.hunter;

import java.util.Random;
import java.util.Scanner;

public class FireHunter {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha = menu();

        switch (escolha) {
            case 1:
                iniciar();
                break;
            case 2:
                instruções();
                break;

        }
    }

    static int menu() {
        int escolha;
        Scanner teclado = new Scanner(System.in);
        System.out.println("=================");
        System.out.println("  1 - INICIAR    ");
        System.out.println("  2 - INSTRUÇÕES ");
        System.out.println("  3 - SAIR       ");
        System.out.println("=================");
        escolha = teclado.nextInt();

        return escolha;
    }

    static void iniciar() {
        String SEPARADOR = "====================================================";

        Scanner teclado = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        Random dado = new Random();
        int p1, p2, d1, d2;
        String e;
        String nomeP1;
        String nomeP2;
        System.out.println("Digite o nome do jogador 1: ");
        nomeP1 = teclado.nextLine();
        System.out.println("Digite o nome do jogador 2: ");
        nomeP2 = teclado.nextLine();
        System.out.println(SEPARADOR);
        System.out.println("Digite (0) para girar os dois dados e ver quem irá iniciar a batalha. ");
        System.out.println("");
        System.out.println(SEPARADOR);
        e = teclado.next();

        do {
            d1 = dado.nextInt(6) + 1;

            d2 = dado.nextInt(6) + 1;
        } while (d1 == d2);
        System.out.println(SEPARADOR);
        System.out.println("Dado " + nomeP1 + ": " + d1 + " Dado " + nomeP2 + ": " + d2);

        /*Cria os atributos de cada personagem. Linha e condizente a cada personagem. 
        Sendo sua sequencia: (Mago, Templario, Ranger, Druida).
        Coluna sao os seus atributos. (Vida, esculdo e cura).
         */
        int atributosPersonagens[][] = {
            {5, 5, 2},
            {5, 4, 3},
            {4, 4, 4},
            {4, 3, 5}
        };

        /*
        Cria a vida e escudo de cada jogador.
        Linha e o player.
        coluna e a vida e esculdo.
         */
        int vidasPersonagens[][] = {
            {10, 10},
            {10, 10}
        };

        //contador personagem 
        if (d1 > d2) {
            //DADO COM O NUMERO MAIOR PARA JOGADOR 1

            System.out.println(SEPARADOR);
            System.out.println("Jogador 1: " +nomeP1 + " Venceu!");
            System.out.println(nomeP1 + " escolha seu personagem: ");
            listaPersonagens();
            p1 = teclado.nextInt();

            System.out.println(SEPARADOR);
            System.out.println("Jogador 2: " + nomeP2 + " escolha seu personagem: ");
            listaPersonagens();
            p2 = teclado.nextInt();

            //SE O PERSONAGEM FO JOGADOR 1 FOR IGUAL AO JOGADOR 2
            while (p1 == p2) {
                System.out.println(SEPARADOR);
                System.out.println(" O personagem já foi escolhido " + nomeP2 + " escolha outro personagem: ");
                listaPersonagens();

                p2 = teclado.nextInt();

            }
        } else {

            System.out.println(SEPARADOR);
            System.out.println("Jogador 1: " + nomeP2 + " Venceu!");
            System.out.println(nomeP2 + " escolha seu personagem: ");
            listaPersonagens();

            p2 = teclado.nextInt();

            System.out.println(SEPARADOR);
            System.out.println("Jogador 2: " + nomeP1 + " escolha seu personagem:");
            listaPersonagens();

            p1 = teclado.nextInt();
            System.out.println(SEPARADOR);

            while (p1 == p2) {
                System.out.println(SEPARADOR);
                System.out.println("O Personagem já foi escolhido," + nomeP1 + " escolha outro personagem");
                listaPersonagens();

                p1 = teclado.nextInt();
                System.out.println(SEPARADOR);
            }
        }
        escolhasjogador(p1, p2);
        Batalha(nomeP1, nomeP2, p1, p2, d1, d2, atributosPersonagens, vidasPersonagens);
    }

    static void listaPersonagens() {
        String SEPARADOR = "====================================================";

        String HISTORIA_MAGO = " Homem sábio vindo das terras da Pérsia,  que com o tempo obteve domínio das forças ocultas, e por isso possui poder de ler as estrelas e manipular destinos. Sua principal arma é seu cajado mágico, com ela o Mago  lança seus poderosos feitiços contra seus inimigos.";
        String HISTORIA_TEMPLARIO = "Cavaleiro vindo dos Templos de Salomão, fez um voto de castidade e devoção e daria a vida para proteger os seus aliados. Suas principais armas são seu escudo e sua  espada, estas são capazes de dizimar exércitos que venham em sua direção.";
        String HISTORIA_RANGER = "Arqueira, a mais veloz dos personagens, seu arco é sua principal arma, essa guerreira ainda conta com uma arma adicional que é a sua águia.";
        String HISTORIA_DRUIDA = "Homem vindo das áreas da Europa pré Romana, possui alto conhecimento sobre a natureza e a filosofia, sendo essa sua principal arma.";

        String ESPECIALIDADES_MAGO = "ESPECIALIDADES: vida: 5 | Escudo: 5 | Cura:2";
        String ESPECIALIDADES_TEMPLARIO = "ESPECIALIDADES: vida: 5 | Escudo: 4 | Cura:3";
        String ESPECIALIDADES_RANGER = "ESPECIALIDADES: vida: 4 | Escudo: 4 | Cura:4";
        String ESPECIALIDADES_DRUIDA = "ESPECIALIDADES:  vida: 4 | Escudo: 3 | Cura:5";

        String PONTOS_MAGO = "PONTO FORTE: diversidade nos tipos de ataque  à escudos e vidas | PONTO FRACO: poder de cura baixo.";
        String PONTOS_TEMPLARIO = "PONTO FORTE: Ataque à vida | PONTO FRACO: Poder de Cura ";
        String PONTOS_RANGER = "PONTO FORTE:Equilibrio na quantidade de ataques | PONTO FRACO: Menos força em seus ataques. ";
        String PONTOS_DRUIDA = "PONTO FORTE:Poder de Cura ";

        System.out.println(SEPARADOR);
        System.out.println("1:MAGO");
        System.out.println(HISTORIA_MAGO);
        System.out.println(ESPECIALIDADES_MAGO);
        System.out.println(PONTOS_MAGO);
        System.out.println(SEPARADOR);

        System.out.println("2:TEMPLÁRIO:");
        System.out.println(HISTORIA_TEMPLARIO);
        System.out.println(ESPECIALIDADES_TEMPLARIO);
        System.out.println(PONTOS_TEMPLARIO);
        System.out.println(SEPARADOR);

        System.out.println("3: RANGER:");
        System.out.println(HISTORIA_RANGER);
        System.out.println(ESPECIALIDADES_RANGER);
        System.out.println(PONTOS_RANGER);
        System.out.println(SEPARADOR);

        System.out.println("4:DRUIDA");
        System.out.println(HISTORIA_DRUIDA);
        System.out.println(ESPECIALIDADES_DRUIDA);
        System.out.println(PONTOS_DRUIDA);
        System.out.println(SEPARADOR);

    }

    static void escolhasjogador(int p1, int p2) {
        String SEPARADOR = "====================================================";
        System.out.println("A batalha será: ");
        switch (p1) {
            case 1:
                System.out.println("MAGO");

                break;
            case 2:
                System.out.println("TEMPLÁRIO");
                break;
            case 3:
                System.out.println("RANGER");
                break;
            case 4:
                System.out.println("DRUIDA");
                break;
            default:
                break;
        }

        System.out.println("VS");
        switch (p2) {
            case 1:
                System.out.println("MAGO");
                break;
            case 2:
                System.out.println("TEMPLÁRIO");
                break;
            case 3:
                System.out.println("RANGER");
                break;
            case 4:
                System.out.println("DRUIDA");
                break;
            default:
                break;
        }
        System.out.println(SEPARADOR);
    }

    static void Batalha(String nomeP1, String nomeP2, int p1, int p2, int d1, int d2, int atributosPersonagens[][], int vidasPersonagens[][]) {
        int opcaoP1, opcaoP2, choose, jogarDado;
        Random dadoLuta = new Random();
        int ecolha1, escolha2;
        while (((vidasPersonagens[0][0] > 0) || (vidasPersonagens[0][1] > 0)) && ((vidasPersonagens[1][0] > 0) || (vidasPersonagens[1][1] <= 0))) {
            impressao(vidasPersonagens);
            if (d1 > d2) {
                do {

                    System.out.println("Digite (0) e aperte enter para girar o dado " + nomeP1);

                    jogarDado = teclado.nextInt();

                } while (jogarDado != 0);
                opcaoP1 = dadoLuta.nextInt(6) + 1;
                System.out.println("Dado " + nomeP1 + ": " + opcaoP1);

                int a = 1;
                acao(p1, atributosPersonagens, opcaoP1, vidasPersonagens, a);

                impressao(vidasPersonagens);

                do {
                    System.out.println("Digite (0) e aperte enter para girar o dado " + nomeP2);

                    jogarDado = teclado.nextInt();

                } while (jogarDado != 0);

                opcaoP2 = dadoLuta.nextInt(6) + 1;

                System.out.println("Dado " + nomeP2 + ": " + opcaoP2);

                a = 0;
                acao(p2, atributosPersonagens, opcaoP2, vidasPersonagens, a);
                impressao(vidasPersonagens);

            } else {

                do {

                    System.out.println("Digite (0) e aperte enter para girar o dado " + nomeP2);

                    jogarDado = teclado.nextInt();

                } while (jogarDado != 0);

                opcaoP2 = dadoLuta.nextInt(6) + 1;

                System.out.println("Dado " + nomeP2 + ": " + opcaoP2);

                int a = 0;
                acao(p2, atributosPersonagens, opcaoP2, vidasPersonagens, a);
                impressao(vidasPersonagens);

                do {

                    System.out.println("Digite (0) e aperte enter para girar o dado " + nomeP1);

                    jogarDado = teclado.nextInt();

                } while (jogarDado != 0);

                opcaoP1 = dadoLuta.nextInt(6) + 1;

                System.out.println("Dado" + nomeP1 + ": " + opcaoP1);

                a = 1;
                acao(p1, atributosPersonagens, opcaoP1, vidasPersonagens, a);
                impressao(vidasPersonagens);
            }
        }
    }

    static void acao(int player, int atributosPersonagens[][], int opcao, int vidasPersonagens[][], int a) {
        int choose;
        switch (opcao) {

            case 1:

                System.out.println("1 - Ataque no escudo (" + (atributosPersonagens[player - 1][1] + opcao)
                        + ")\nou\n2- ataque na vida (" + (atributosPersonagens[player - 1][0] + opcao) + ")");
                choose = teclado.nextInt();

                if (choose == 1) {

                    vidasPersonagens[a][1] -= atributosPersonagens[player - 1][1];
                } else {

                    vidasPersonagens[a][0] -= atributosPersonagens[player - 1][0];
                }

                break;
            case 2:

                System.out.println("1- ataque no escudo (" + (atributosPersonagens[player - 1][1] + opcao) + ")\n"
                        + "ou\n2- cura ("
                        + (atributosPersonagens[player - 1][2] + opcao) + ")");
                choose = teclado.nextInt();

                if (choose == 1) {
                    vidasPersonagens[a][1] -= 2 + atributosPersonagens[player - 1][1];
                } else {
                    if (a == 0) {
                        a = 2;
                    }
                    if (vidasPersonagens[a - 1][0] < 10) {
                        vidasPersonagens[a - 1][0] += 2 + atributosPersonagens[player - 1][2];
                    }

                }
                break;
            case 3:

                System.out.println("1 - ataque na vida (" + (atributosPersonagens[player - 1][0] + opcao) + ")");
                choose = teclado.nextInt();

                if (choose == 1) {
                    vidasPersonagens[a][0] -= 3 + atributosPersonagens[player - 1][0];
                }
                break;
            case 4:

                System.out.println("1 - cura (" + (atributosPersonagens[player - 1][2] + opcao) + ")");
                choose = teclado.nextInt();
                if (a == 0) {
                    a = 2;
                }
                if (choose == 1) {
                    if (vidasPersonagens[a - 1][0] < 10) {
                        vidasPersonagens[a - 1][0] += 4 + atributosPersonagens[player - 1][2];
                    }
                }
                break;
            case 5:

                System.out.println("1 - ataque na vida (" + (atributosPersonagens[player - 1][0] + opcao)
                        + ")\nou\n2- cura (" + atributosPersonagens[player - 1][2] + opcao + ")");
                choose = teclado.nextInt();

                if (choose == 1) {
                    vidasPersonagens[a][0] -= 5 + atributosPersonagens[player - 1][0];
                } else {
                    if (a == 0) {
                        a = 2;
                    }
                    if (vidasPersonagens[a - 1][0] < 10) {
                        vidasPersonagens[a - 1][0] += 5 + atributosPersonagens[player - 1][2];
                    }
                }
                break;
            case 6:

                System.out.println("1 - ataque no escudo (" + (atributosPersonagens[player - 1][1] + opcao)
                        + ") \nou\n 2- cura(" + (atributosPersonagens[player - 1][2] + opcao)
                        + ") \nou\n 3 - ataque na vida(" + (atributosPersonagens[player - 1][0] + opcao) + ")");
                choose = teclado.nextInt();

                if (choose == 1) {
                    vidasPersonagens[a][1] -= 6 + atributosPersonagens[player - 1][1];
                }
                if (choose == 2) {
                    if (a == 0) {
                        a = 2;
                        if (vidasPersonagens[a - 1][0] < 10) {
                            vidasPersonagens[a - 1][0] += 6 + atributosPersonagens[player - 1][2];
                        }
                    } else {
                        vidasPersonagens[a][0] -= 6 + atributosPersonagens[player - 1][0];
                    }
                    break;

                }

        }
    }

    static void impressao(int vidasPersonagens[][]) {
        String SEPARADOR = "====================================================";
        for (int i = 0; i < vidasPersonagens.length; i++) {

            System.out.println("Jogador (" + (i + 1) + ")");

            for (int j = 0; j < vidasPersonagens.length; j++) {
                if (j == 0) {
                    System.out.println("Vida (" + vidasPersonagens[i][j] + ")");

                } else {

                    System.out.println("Escudo (" + vidasPersonagens[i][j] + ")");
                    System.out.println(SEPARADOR);
                }
            }
        }
    }

    static void instruções() {
        Scanner teclado = new Scanner(System.in);
        int esc;
        System.out.println("____O jogo apresentará 4 personagens______");
        System.out.println("____os dois jogadores - usuário 1 e 2 - jogarão o dado,"
                + "o jogador que tirar o maior número é o primeiro a escolher e inicia a partida____");
        System.out.println("____ambos jogadores escolhem seus personagens____");
        System.out.println("____quem tirou o número maior no dado inicia a partida____");
        System.out.println("____cada personagem inicia com 25 de escudo e 25 de vida____");
        System.out.println("____cada número do dado dará até 3 opções, dentre elas:"
                + " ataque a vida, ataque a escudo e cura____");
        System.out.println("____O personagem vencedor será o que conseguir zerar primeiro a"
                + " vida e o escudo do adversário____");
        System.out.println("____então o jogo apresentará o vencedor____");
        System.out.println("*******iniciar o jogo - 1, sair - 2*******");
        esc = teclado.nextInt();
        if (esc == 1) {
            iniciar();
        }

    }
}
//TESTE 2.
