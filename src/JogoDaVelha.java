import java.util.Scanner;

public class JogoDaVelha {

    public static Scanner scan = new Scanner(System.in);
    public static int numeroTentativaX = 1, numeroTentativaY = 1, linha, coluna, rodada = 1, contador = 0, velha = 0;
    public static char jogador = 'X';
    public static char[][] tabuleiro = new char[3][3];

    public static void tabuleiro() {
        
        System.out.print(" ------------------------ ");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.println("    ");
            for (int j = 0; j < tabuleiro.length; j++) {
                System.out.print("|   " + tabuleiro[i][j] + "   | ");
            }
            System.out.println("   ");
        }
        System.out.print(" ------------------------ ");
        System.out.println("    ");

    }

    public static void iniciarJogo() {

        System.out.println("                     ");
        System.out.println("<<< JOGO DA VELHA >>>");
        System.out.println("O primeiro a jogar é o X");
        System.out.println("Passe a linha e coluna que");
        System.out.println("deseja fazer a jogada: ");
        
        tabuleiro();

        efetuarJogada(rodada, numeroTentativaX, numeroTentativaY);


    }

    public static void efetuarJogada(int rodada, int numeroTentativaX, int numeroTentativaY) {

        if (rodada % 2 == 0) {

            jogador = 'O';
            System.out.println("    ");
            System.out.print(numeroTentativaY + "º jogada da peça " + jogador + " --> Escolha a Linha (0 a 2): ");
            linha = scan.nextInt();
            System.out.print(numeroTentativaY + "º jogada da peça " + jogador + " --> Escolha a Coluna (0 a 2): ");
            coluna = scan.nextInt();    

            if (linha > 2 || coluna > 2) {
                System.out.println("    ");
                System.out.println("Posição inválida, tente novamente.");
                efetuarJogada(rodada, numeroTentativaX, numeroTentativaY);
            }
        
        } else {

            jogador = 'X';
            System.out.println("    ");
            System.out.print(numeroTentativaX + "º jogada da peça " + jogador + " --> Escolha a Linha (0 a 2): ");
            linha = scan.nextInt();
            System.out.print(numeroTentativaX + "º jogada da peça " + jogador + " --> Escolha a Coluna (0 a 2): ");
            coluna = scan.nextInt();
            
            if (linha > 2 || coluna > 2) {
                System.out.println("    ");
                System.out.println("Posição inválida, tente novamente.");
                efetuarJogada(rodada, numeroTentativaX, numeroTentativaY);
            }
        
        }

        validarJogada(rodada, jogador);

    }



    public static void validarJogada(int rodada, char jogador) {

        for (int i = 0; i < tabuleiro.length; i++) {
           
            for (int j = 0; j < tabuleiro.length; j++) {
                if (coluna == j && linha == i && tabuleiro[i][j] == 0) {
                    tabuleiro[i][j] = jogador;
                    contador = 1;
                }
            }

        }

        if (contador > 0) {

            rodada ++;
            tabuleiro();

            if (rodada % 2 == 0) {
                numeroTentativaX ++;
            } else {
                numeroTentativaY ++;
            }

            contador = 0;
            verificaStatus(rodada, numeroTentativaX, numeroTentativaY);

        } else {

            System.out.println("    ");
            System.out.println("Essa posição já está ocupada, tente novamente.");
            efetuarJogada(rodada, numeroTentativaX, numeroTentativaY);
        
        }

    }

    public static void verificaStatus(int rodada, int numeroTentativaX, int numeroTentativaY) {
        
        //FOR para verificar se o tabuleiro está totalmente preenchido
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j] != 0) {
                    velha ++;
                }    
            }
        }

        //Testando todas as possibilidades no tabuleiro
        if ((tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][0] == tabuleiro[0][2] && tabuleiro[0][0] != 0) ||
            (tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][0] == tabuleiro[1][2] && tabuleiro[1][0] != 0) ||
            (tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][0] == tabuleiro[2][2] && tabuleiro[2][0] != 0) ||
            (tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[0][0] == tabuleiro[2][0] && tabuleiro[0][0] != 0) ||
            (tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[0][1] == tabuleiro[2][1] && tabuleiro[0][1] != 0) ||
            (tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[0][2] == tabuleiro[2][2] && tabuleiro[0][2] != 0) ||
            (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2] && tabuleiro[0][0] != 0) ||
            (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0] && tabuleiro[0][2] != 0) 
            ) {

            ganhou(jogador);
        
        } else if (velha == 9) {

            empate();

        } else {

            velha = 0;
            efetuarJogada(rodada, numeroTentativaX, numeroTentativaY);

        }

    }

    public static void ganhou(char jogador) {

        
        System.out.println("                    ");
        System.out.println("                    ");
        System.out.println("<<< JOGADOR " + jogador + " >>>");
        System.out.println("  VOCÊ GANHOU!                 ");

        //FOR para limpar o tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        velha = 0;
        rodada = 1;
        numeroTentativaX = 1;
        numeroTentativaY = 1;

        App.menu(App.usuario);

    }

    public static void empate() {

        System.out.println("               ");
        System.out.println("               ");
        System.out.println(" <<< VELHA >>> ");
        System.out.println(" O JOGO EMPATOU");

        //FOR para limpar o tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        velha = 0;
        rodada = 1;
        numeroTentativaX = 1;
        numeroTentativaY = 1;

        App.menu(App.usuario);

    }

}