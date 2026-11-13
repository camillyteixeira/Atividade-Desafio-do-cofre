public class Cofre {
    private String senha;
    private String itens = "";
    private boolean aberto = false;
    private boolean trancado = false;
    private boolean bloqueado = false;
    private int tentativas = 0;

    public Cofre(String senhaInicial) {
        this.senha = senhaInicial;
    }

    public void abrir() {
        if (bloqueado) {
            System.out.println("O cofre está bloqueado");
        } else if (trancado) {
            System.out.println("O cofre está trancado,destranque-o com a senha");
        } else if (aberto) {
            System.out.println("O cofre já está aberto");
        } else {
            this.aberto = true;
            System.out.println("Cofre aberto");
        }
    }

    public void fechar() {
        if (aberto) {
            this.aberto = false;
            System.out.println("Cofre fechado,mas ainda destrancado");
        } else {
            System.out.println("O cofre já está fechado");
        }
    }

    public void trancar() {
        if (aberto) {
            this.aberto = false;
            this.trancado = true;
            System.out.println("Cofre fechado e trancado");
        } else {
            System.out.println("Para trancar, o cofre precisa estar aberto");
        }
    }

    public void destrancar(String senhaDigitada) {
        if (bloqueado) {
            System.out.println("Cofre bloqueado após 3 tentativas erradas");
            return;
        }

        if (!trancado) {
            System.out.println("O cofre já está destrancado");
            return;
        }

        if (this.senha.equals(senhaDigitada)) {
            this.trancado = false;
            this.tentativas = 0; // Reset de tentativas ao acertar
            System.out.println("Senha correta e cofre destrancado");
        } else {
            this.tentativas++;
            if (this.tentativas >= 3) {
                this.bloqueado = true;
                System.out.println("Senha incorreta,o limite de 3 tentativas foi atingido");
            } else {
                int restantes = 3 - this.tentativas;
                System.out.println("Senha incorreta,tentativas restantes: " + restantes);
            }
        }
    }

    public void guardarItem(String item) {
        if (aberto) {
            if (this.itens.isEmpty()) {
                this.itens = item;
            } else {
                this.itens = this.itens + ", " + item;
            }
            System.out.println("Item '" + item + "' guardado");
        } else {
            System.out.println("O cofre está fechado,abra-o para guardar itens");
        }
    }

    public void listarItens() {
        if (!aberto) {
            System.out.println("Abra o cofre para visualizar os itens guardados");
        } else if (this.itens.isEmpty()) {
            System.out.println("O cofre está vazio");
        } else {
            System.out.println("Itens no cofre: " + this.itens);
        }
    }

    public void verificarStatus() {
        System.out.println("Dados do Cofre");
        System.out.println("Aberto: " + (aberto ? "Sim" : "Não"));
        System.out.println("Trancado: " + (trancado ? "Sim" : "Não"));
        System.out.println("Bloqueado: " + (bloqueado ? "SIM (Segurança Ativada)" : "Não"));
        System.out.println("Tentativas falhas seguidas: " + tentativas + "/3");
    }
}