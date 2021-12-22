import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        System.out.print("Digite o seu nome: ");
        usuario = sc.next();
        menu(usuario);

    }

    public static String usuario;
    public static Scanner sc = new Scanner(System.in);
    
    public static void menu(String usuario) {
        
        System.out.println("                 ");
        System.out.println( usuario + ", escolha o que deseja: ");
        System.out.println("(1) Jogo da Forca");
        System.out.println("(2) Jogo da Velha");
        System.out.println("(3) Sair         ");
        System.out.println("                 ");
        System.out.print("---> ");        
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                JogoDaForca.iniciarJogo();
                break;
            case 2:
                JogoDaVelha.iniciarJogo();
                break;
            case 3:
                sair();
                break;
            
            default:
                System.out.println("Opção inválida, vamos tentar novamente.");
                System.out.println();
                menu(usuario);
                break;
        }
    }    

    public static void sair() {
        
        System.out.println("        ");
        System.out.println("Até uma próxima " + usuario);
        System.out.println("        ");
        System.exit(0);
    
    }
    
}
