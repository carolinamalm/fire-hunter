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
        System.out.println("1 - INICIAR");
        System.out.println("2 - INSTRUÇÕES");
        System.out.println("3 - SAIR");
        escolha = teclado.nextInt();

        return escolha;
    }

    static void iniciar() {
        Scanner teclado = new Scanner(System.in);
        Random dado = new Random();
        int p1, p2, d1, d2;
        String e;
        System.out.println("escolha quem será o p1 e quem será o p2 \ndigite (0) "
                + "para girar os dois dados e ver que irá iniciar a batalha ");
        e = teclado.next();
        do {
            d1 = dado.nextInt(6) + 1;

            d2 = dado.nextInt(6) + 1;
        } while (d1 == d2);
        System.out.println("dado p1 : " + d1 + " dado p2: " + d2);

        /*Cria os atributos de cada personagem. Linha e condizente a cada personagem. 
        Sendo sua sequencia: (Mago, cavaleiro, ranger, druida).
        Coluna sao os seus atributos. (Vida, esculdo e cura).
         */
        int atributosPersonagens[][] = {{5, 5, 2}, {5, 4, 3}, {4, 4, 4}, {4, 3, 5}};

        /*
        Cria a vida e esculdo de cada jogador.
        Linha e o player.
        coluna e a vida e esculdo.
         */
        int vidasPersonagens[][] = {{10, 10}, {10, 10}};

        //contador personagem
        int contadorPersonagem = 0;
        if (d1 > d2) {

            System.out.println("p1 escolha seu personagem:\n 1:mago\n 2: caveleiro\n 3: druida\n 4: ranger");
            p1 = teclado.nextInt();
            System.out.println("p2 escolha seu personagem:\n 1:mago\n 2: caveleiro\n 3: druida\n 4: ranger");
            p2 = teclado.nextInt();
        } else {
            System.out.println("p2 escolha seu personagem:\n 1:mago\n 2: caveleiro\n 3: druida\n 4: ranger");
            p2 = teclado.nextInt();
            System.out.println("p1 escolha seu personagem:\n 1:mago\n 2: caveleiro\n 3: druida\n 4: ranger");
            p1 = teclado.nextInt();
        }
        escolhasjogador(p1, p2);
        Batalha(p1, p2, d1, d2, atributosPersonagens, vidasPersonagens);
    }

    static void escolhasjogador(int p1, int p2) {
        switch (p1) {
            case 1:
                System.out.println("mago");

                break;
            case 2:
                System.out.println("cavaleiro");
                break;
            case 3:
                System.out.println("ranger");
                break;
            case 4:
                System.out.println("druida");
                break;
            default:
                break;
        }
        System.out.println("VS");
        switch (p2) {
            case 1:
                System.out.println("mago");
                break;
            case 2:
                System.out.println("cavaleiro");
                break;
            case 3:
                System.out.println("ranger");
                break;
            case 4:
                System.out.println("druida");
                break;
            default:
                break;
        }
    }

    static void Batalha(int p1, int p2, int d1, int d2, int atributosPersonagens[][], int vidasPersonagens[][]) {
        int opcaoP1, opcaoP2, choose, jogarDado;
        Random dadoLuta = new Random();
        int ecolha1, escolha2;
        do{
        if (d1 > d2) {
                do{
                System.out.println("digite (0) e de enter para girar o dado P1");
                
                jogarDado = teclado.nextInt();
                }while(jogarDado != 0 );
                opcaoP1 = dadoLuta.nextInt(6) + 1;
                System.out.println("dado player 1: " + opcaoP1);
                int a = 1;
                acao(p1, atributosPersonagens, opcaoP1, vidasPersonagens, a);

                impressao(vidasPersonagens);
                
                do{
                System.out.println("digite (0) e de enter para girar o dado P2");
                
                jogarDado = teclado.nextInt();
                }while(jogarDado != 0 );
                
                opcaoP2 = dadoLuta.nextInt(6) + 1;
                System.out.println("dado player 2: " + opcaoP2);
                a = 0;
                acao(p2, atributosPersonagens, opcaoP2, vidasPersonagens, a);
                impressao(vidasPersonagens);
            

        } else {
                
                do{
                System.out.println("digite (0) e de enter para girar o dado P2");
                
                jogarDado = teclado.nextInt();
                }while(jogarDado != 0 );
                
                opcaoP2 = dadoLuta.nextInt(6) + 1;
                System.out.println("dado player 2: " + opcaoP2);
                int a = 0;
                acao(p2, atributosPersonagens, opcaoP2, vidasPersonagens, a);
                impressao(vidasPersonagens);
                
                do{
                System.out.println("digite (0) e de enter para girar o dado P1");
                
                jogarDado = teclado.nextInt();
                }while(jogarDado != 0 );
                
                opcaoP1 = dadoLuta.nextInt(6) + 1;
                System.out.println("dado player 1: " + opcaoP1);
                a = 1;
                acao(p1, atributosPersonagens, opcaoP1, vidasPersonagens, a);
                impressao(vidasPersonagens);
            } 
        }while (((vidasPersonagens[0][0] > 0) && (vidasPersonagens[0][1] > 0)) || ((vidasPersonagens[1][0] > 0) && !(vidasPersonagens[1][1] <= 0)));
        impressao(vidasPersonagens);
    }

    static void acao(int player, int atributosPersonagens[][], int opcao, int vidasPersonagens[][], int a) {
        int choose;
        switch (opcao) {

            case 1:
                System.out.println("1 - ataque no escudo \n ou \n 2- ataque na vida");
                choose = teclado.nextInt();
                if (choose == 1) {

                    vidasPersonagens[a][1] -= atributosPersonagens[player - 1][1];
                } else {

                    vidasPersonagens[a][0] -= atributosPersonagens[player - 1][0];
                }

                break;
            case 2:
                System.out.println("1- ataque no escudo \n ou \n 2- cura");
                choose = teclado.nextInt();
                if (choose == 1) {
                    vidasPersonagens[a][1] -= 2 + atributosPersonagens[player - 1][1];
                } else {
                    if (a == 0) {
                        a = 2;
                    }
                    if(vidasPersonagens[a - 1][0] <10){
                    vidasPersonagens[a - 1][0] += 2 + atributosPersonagens[player - 1][2];
                    }

                }
                break;
            case 3:
                System.out.println("1 - ataque na vida");
                choose = teclado.nextInt();
                if(choose == 1){
                vidasPersonagens[a][0] -= 3 + atributosPersonagens[player - 1][0];
                }
                break;
            case 4:
                System.out.println("cura");
                if (a == 0) {
                    a = 2;
                }
                if(vidasPersonagens[a - 1][0] <10){
                vidasPersonagens[a - 1][0] += 4 + atributosPersonagens[player - 1][2];
                }
                break;
            case 5:
                System.out.println("1 - ataque na vida \n ou \n 2- cura");
                choose = teclado.nextInt();
                if (choose == 1) {
                    vidasPersonagens[a][0] -= 5 + atributosPersonagens[player - 1][0];
                } else {
                    if (a == 0) {
                        a = 2;
                    }
                    if(vidasPersonagens[a - 1][0] <10){
                    vidasPersonagens[a - 1][0] += 5 + atributosPersonagens[player - 1][2];
                    }
                }
                break;
            case 6:
                System.out.println("1 - ataque no escudo \n ou \n 2- cura \n ou \n 3 - ataque na vida");
                choose = teclado.nextInt();
                if (choose == 1) {
                    vidasPersonagens[a][1] -= 6 + atributosPersonagens[player - 1][1];
                }
                if (choose == 2) {
                    if (a == 0) {
                        a = 2;
                        if(vidasPersonagens[a - 1][0] <10){
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
        for (int i = 0; i < vidasPersonagens.length; i++) {
            System.out.println("Jogardor (" + (i+1) + ")");
            System.out.println("");
            for (int j = 0; j < vidasPersonagens.length; j++) {
                if (j == 0) {
                    System.out.print("Vida (" + vidasPersonagens[i][j] + ")");
                } else {
                    System.out.print("  Esculdo (" + vidasPersonagens[i][j] + ")");
                    System.out.println("");
                }
            }
            System.out.println(" ");
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
