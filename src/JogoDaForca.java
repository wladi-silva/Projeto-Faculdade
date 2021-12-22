import java.util.Scanner;

public class JogoDaForca {
    
    public static Scanner scan = new Scanner(System.in);
    public static boolean resposta = false, sair = false;
    public static char letra;
    public static char[] palavra;
    public static char[] vetorAuxiliar;
    public static char[] repetidas = new char[26];
    public static int numeroTentativa = 1, erros = 0, acertos = 0, contador = 0;


    public static void iniciarJogo() {
        
        System.out.println();
        System.out.println("<<< JOGO DA FORCA >>>");
        System.out.println("Você deverá acertar a palavra em ");
        System.out.println("6 tentativas para vencer o jogo: ");
        System.out.println("                    ");
        System.out.println("  _______           ");
        System.out.println(" |       |          ");
        System.out.println(" |                  ");
        System.out.println(" |                  ");
        System.out.println(" |                  ");
        System.out.println(" |                  ");
        System.out.println(" |                  ");
        System.out.println("_|___               ");

        obterPalavra();

    }

    public static void imprimeForca(char[] palavra, int erros) {
        
        switch (erros) {
            case 0:
                System.out.println("                    ");
                System.out.println("  _______           ");
                System.out.println(" |       |          ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println("_|___               ");
                System.out.println("                    ");    
                break;
            case 1:
                System.out.println("                    ");
                System.out.println("  _______           ");
                System.out.println(" |       |          ");
                System.out.println(" |       O          ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println("_|___               ");
                System.out.println("                    ");
                break;
            case 2:
                System.out.println("                    ");
                System.out.println("  _______           ");
                System.out.println(" |       |          ");
                System.out.println(" |       O          ");
                System.out.println(" |       |          ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println("_|___               ");
                System.out.println("                    ");
                break;
            case 3:
                System.out.println("                    ");
                System.out.println("  _______           ");
                System.out.println(" |       |          ");
                System.out.println(" |       O          ");
                System.out.println(" |      (|         ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println("_|___               ");
                System.out.println("                    ");
                break;
            case 4:
                System.out.println("                    ");
                System.out.println("  _______           ");
                System.out.println(" |       |          ");
                System.out.println(" |       O          ");
                System.out.println(" |      (|)         ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println(" |                  ");
                System.out.println("_|___               ");
                System.out.println("                    ");
                break;
            case 5:
                System.out.println("                    ");
                System.out.println("  _______           ");
                System.out.println(" |       |          ");
                System.out.println(" |       O          ");
                System.out.println(" |      (|)         ");
                System.out.println(" |       )          ");
                System.out.println(" |       `          ");
                System.out.println(" |                  ");
                System.out.println("_|___               ");
                System.out.println("                    ");
                break;
            case 6:
                System.out.println("                    ");
                System.out.println("  _______           ");
                System.out.println(" |       |          ");
                System.out.println(" |       O          ");
                System.out.println(" |      (|)         ");
                System.out.println(" |       ))         ");
                System.out.println(" |       ``         ");
                System.out.println(" |                  ");
                System.out.println("_|___               ");
                System.out.println("                    ");    
                break;
            default:
                System.out.println("Erro no sistema.");
                break;
        }
    }

    public static void obterPalavra() {

        System.out.println("                        ");
        System.out.print("Informe a palavra oculta: ");
        String oculta = scan.next();
        palavra = oculta.toCharArray();
        vetorAuxiliar = new char[palavra.length];
        
        // FOR Apenas para dar um espaço no console.
        for (int i = 0; i < 15; i++) {
            System.out.println(" ");
        }

        // FOR para mostra quantas letras tem a palavra.
        System.out.println("A palavra tem " + palavra.length + " letras:");
        for (int i = 0; i < palavra.length; i++) {
            System.out.print(" _ ");
        }
        System.out.println("                   ");
        System.out.println("                   ");
        System.out.println(" < VAMOS COMEÇAR > ");

        efetuarJogada(palavra, numeroTentativa);
    
    }

    public static void efetuarJogada(char[] palavra, int numeroTentativa) {
        
        do {
            System.out.println("                                                    ");
            System.out.println("Informe a letra da " + numeroTentativa + " tentativa");
            System.out.print("---> ");
            letra = scan.next().charAt(0);
            repetidas[numeroTentativa] = letra;
            contador = 0;

            for (int i = 0; i < repetidas.length; i++) {
                if (repetidas[i] == letra && i != numeroTentativa) {
                    contador = 1;
                    System.out.println("");
                    System.out.println("Essa letra já foi usada, tente novamente.");
                }
            }

            if (contador > 0) {
                sair = false;
            } else {
                sair = true;
            }

        } while (sair == false);

        sair = false;
        validarJogada(palavra, letra);
        
    }    
    public static void validarJogada(char[] palavra, char letra) {

        for (int i = 0; i < palavra.length; i++) {
            if (palavra[i] == letra) {
                resposta = true;
                acertos ++;
            } 
        }

        if (resposta == true) {
            
            resposta = false;
            forca(palavra, letra);
        
        } else {

            erros ++;
            enforcado(palavra, erros);
        
        }
    }

    public static void forca(char[] palavra, char letra) {

        //Incrementa no outro vetor
        for (int i = 0; i < palavra.length; i++) {
            if (palavra[i] == letra) {
                vetorAuxiliar[i] = letra;
            }
        }

        //Imprime na tela
        System.out.println("    ");
        for (int i = 0; i < vetorAuxiliar.length; i++) {
            
            if (vetorAuxiliar[i] == 0) {
                System.out.print(" _ ");
            } else {
                System.out.print(" " + vetorAuxiliar[i] + " ");
            }

        }

        System.out.println("    ");
        numeroTentativa ++;      
    
        imprimeForca(palavra, erros);
        verificaStatus(erros, acertos);

    }

    public static void enforcado(char[] palavra, int erros) {
        
        numeroTentativa ++;
        
        imprimeForca(palavra, erros);
        verificaStatus(erros, acertos);

    }

    public static void verificaStatus(int erros, int acertos) {
        
        if ((acertos == palavra.length) && (erros < 6)) {
            
            ganhou();

        } else if (erros >= 6) {
             
            perdeu();
        
        } else {

            efetuarJogada(palavra, numeroTentativa);

        }

    }

    public static void ganhou() {

        System.out.println("                    ");
        System.out.println("                    ");
        System.out.println("<<< VOCÊ GANHOU! >>>");
        System.out.println("                    ");
        
        numeroTentativa = 1;
        acertos = 0;
        erros = 0;
        
        //FOR para limpar o vetor.
        for (int i = 0; i < repetidas.length; i++) {
            repetidas[i] = 0;
        }

        App.menu(App.usuario);
    }

    public static void perdeu() {

        System.out.println("                   ");
        System.out.println("                   ");
        System.out.println("<<< VOCÊ PERDEU >>>");
        System.out.println("                   ");
        
        numeroTentativa = 1;
        acertos = 0;
        erros = 0;
        
        //FOR para limpar o vetor.
        for (int i = 0; i < repetidas.length; i++) {
            repetidas[i] = 0;
        }

        App.menu(App.usuario);
    }

}
