import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;


public class BiliotecaUEM {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int opcao;

        String documentoNumero = null;
        String documentoTipo = null;
        LocalDate dataNascimento = null;
        String tipoUsuario = null;
        String nomeUsuario = null;
        String funcao = null;
        String periodo = null;
        String livroEmprestado = null;
        LocalDate dataEmprestimo = null;
        LocalDate dataDevolucao = null;
        String devolucao = null;
        String isbndevolucao = null;
        LocalDate dataEmprestimodevolucao = null;
        LocalDate dataDevolucaoRealizada = null;
        int diasAtrasoDevolucao = 0;
        double valorMultaDevolucao = 0.0;


        do {

            System.out.println("===BEM-VINDO A BIBLIOTECA MONASTERIO DE SANTA CATARINA===");
            System.out.println();
            System.out.println("1 - Cadastro");
            System.out.println("2 - Consultar ");
            System.out.println("3 - Empréstimo");
            System.out.println("4 - Reservar");
            System.out.println("5 - Devolução");
            System.out.println("6 - Sair");
            System.out.println("7 - Sobre a Bibilioteca");
            System.out.println("8 - Carrinho");
            System.out.println();
            System.out.println("================================================================");

            System.out.println("Escolha a opção desejada: ");
            opcao = in.nextInt();
            in.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("============================================================================");
                    System.out.println("       Bem vindo ao cadastro da BIBLIOTECA MONASTERIO DE SANTA CATARINA     ");
                    System.out.println("============================================================================");
                    System.out.println();

                    String resposta;
                    do {
                        System.out.println("Já possui cadastro?");
                        resposta = in.nextLine();

                        if (resposta.isBlank()) {
                            System.out.println("Campo nao pode ser vazio");
                        }
                    } while (resposta.isBlank());

                    if (resposta.toUpperCase().equals("SIM")) {
                        String respostacadastro;
                        do {
                            System.out.println("Digite seu nome: ");
                            respostacadastro = in.nextLine();

                            if (respostacadastro.isBlank()) {
                                System.out.println("O nome não pode ser vazio. Tente novamente!");
                            }
                        } while (respostacadastro.isBlank());
                    } else {

                        String resposta2;
                        do {
                            System.out.println("Deseja fazer o cadastro?");
                            resposta2 = in.nextLine();

                            if (resposta2.isBlank()) {
                                System.out.println("Campo nao pode ser vazio");
                            }
                        } while (resposta2.isBlank());

                        if (resposta2.toUpperCase().equals("SIM")) {

                            //String tipoUsuario;
                            do {

                                System.out.println("Voce é Aluno, Professor ou Funcionario?");
                                tipoUsuario = in.nextLine();

                                if (tipoUsuario.isBlank()) {
                                    System.out.println("Campo nao pode ser vazio");
                                }
                            } while (tipoUsuario.isBlank());

                            if (tipoUsuario.toUpperCase().equals("ALUNO")) {
                                //String nomeUsuario;
                                do {
                                    System.out.println("Por favor, digite seu nome:");
                                    nomeUsuario = in.nextLine();

                                    if (nomeUsuario.isBlank()) {
                                        System.out.println("O Campo nao pode ser vazio");
                                    }
                                } while (nomeUsuario.isBlank());

                                DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                //LocalDate dataNascimento = null;

                                do {

                                    System.out.println("Digite sua data de nascimento (dd/MM/yyyy)");
                                    String dataNascimentoStr = in.nextLine();

                                    try {
                                        dataNascimento = LocalDate.parse(dataNascimentoStr, formato1);
                                    } catch (DateTimeParseException e) {
                                        System.out.println("ERROR: Formato inválido!");
                                    }
                                } while (dataNascimento == null);

                                //String funcao;
                                do {

                                    System.out.println("Por favor, digite seu Curso:");
                                    funcao = in.nextLine();

                                    if (funcao.isBlank()) {
                                        System.out.println("Campo nao pode ser vazio!");
                                    }
                                } while (funcao.isBlank());

                                //String periodo;
                                do {
                                    System.out.println("Por favor, digite seu periodo:");
                                    periodo = in.nextLine();

                                    if (periodo.isBlank()) {
                                        System.out.println("Campo nao pode ser vazio!");
                                    }
                                } while (periodo.isBlank());

                                //String documentoTipo;

                                do {
                                    System.out.println("Documentos, voce deseja se  cadastrar com seu CPF ou RG?");
                                    documentoTipo = in.nextLine();

                                    if (!documentoTipo.toUpperCase().equals("CPF") && !documentoTipo.toUpperCase().equals("RG")) {
                                        System.out.println("Opção inválida! Escreva exatamente CPF ou RG.");
                                    }

                                } while (!documentoTipo.toUpperCase().equals("CPF") && !documentoTipo.toUpperCase().equals("RG"));

                                if (documentoTipo.toUpperCase().equals("CPF")) {
                                    //String  documentoNumero;

                                    do {
                                        System.out.println("Por favor, digite seu CPF(apenas os 11 numeros): ");
                                        documentoNumero = in.nextLine();
                                        documentoNumero = documentoNumero.replaceAll("\\D", "");

                                        if (documentoNumero.length() != 11) {
                                            System.out.println("ERROR: numero de cpf inválido ");
                                        }

                                    } while (documentoNumero.length() != 11);
                                } else {
                                    //String  documentoNumero;

                                    do {
                                        System.out.println("Por favor, digite seu RG: ");
                                        documentoNumero = in.nextLine();
                                        documentoNumero = documentoNumero.replaceAll("\\D", "");

                                        if (documentoNumero.length() != 7) {
                                            System.out.println("ERROR: numero de rg inválido ");
                                        }

                                    } while (documentoNumero.length() != 7);

                                }
                            } else if (tipoUsuario.toUpperCase().equals("PROFESSOR")) {

                                //String nomeUsuario;
                                do {
                                    System.out.println("Por favor, digite seu nome:");
                                    nomeUsuario = in.nextLine();

                                    if (nomeUsuario.isBlank()) {
                                        System.out.println("Campo não pode ser vazia");
                                    }

                                } while (nomeUsuario.isBlank());


                                DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                //LocalDate dataNascimento = null;

                                do {

                                    System.out.println("Digite sua data de nascimento (dd/MM/yyyy)");
                                    String dataNascimentoStr2 = in.nextLine();

                                    try {
                                        dataNascimento = LocalDate.parse(dataNascimentoStr2, formato2);
                                    } catch (DateTimeParseException e) {
                                        System.out.println("ERROR: Formato inválido!");
                                    }
                                } while (dataNascimento == null);

                                //String funcao;
                                do {
                                    System.out.println("leciona qual matéria? ");
                                    funcao = in.nextLine();

                                    if (funcao.isBlank()) {
                                        System.out.println("Campo nao pode ser vazio!");
                                    }
                                } while ((funcao.isBlank()));


                                String resposta42;

                                do {
                                    System.out.println("Documentos, voce deseja se cadastrar com seu CPF ou RG?");
                                    documentoTipo = in.nextLine();

                                    if (!documentoTipo.toUpperCase().equals("CPF") && !documentoTipo.toUpperCase().equals("RG")) {
                                        System.out.println("Opção inválida, digite exatamente CPF ou RG:");
                                    }

                                } while (!documentoTipo.toUpperCase().equals("CPF") && !documentoTipo.toUpperCase().equals("RG"));


                                if (documentoTipo.toUpperCase().equals("CPF")) {
                                    //String documentoNumero;

                                    do {
                                        System.out.println("Por favor, digite seu CPF(apenas os 11 numeros): ");
                                        documentoNumero = in.nextLine();

                                        documentoNumero = documentoNumero.replaceAll("\\D", "");

                                        if (documentoNumero.length() != 11) {
                                            System.out.println("ERROR: numero de cpf inválido ");
                                        }

                                    } while (documentoNumero.length() != 11);
                                } else {
                                    //String documentoNumero;

                                    do {
                                        System.out.println("Por favor, digite seu RG: ");
                                        documentoNumero = in.nextLine();

                                        documentoNumero = documentoNumero.replaceAll("\\D", "");

                                        if (documentoNumero.length() != 7) {
                                            System.out.println("ERROR: numero de rg inválido ");
                                        }

                                    } while (documentoNumero.length() != 7);

                                }

                            } else {
                                //String nomeUsuario;

                                do {
                                    System.out.println("Por favor, digite seu nome:");
                                    nomeUsuario = in.nextLine();

                                    if (nomeUsuario.isBlank()) {
                                        System.out.println("ERROR: Nome não pode ser vazia");
                                    }
                                } while (nomeUsuario.isBlank());


                                DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                //LocalDate dataNascimento = null;


                                do {
                                    System.out.println("Digite sua data de nascimento (dd/MM/yyyy)");
                                    String dataNascimentoStr3 = in.nextLine();

                                    try {
                                        dataNascimento = LocalDate.parse(dataNascimentoStr3, formato3);
                                    } catch (DateTimeParseException e) {
                                        System.out.println("ERROR: Formato inválido!");
                                    }
                                } while (dataNascimento == null);

                                //String funcao;
                                do {
                                    System.out.println("É funcionario de qual setor da universidade? ");
                                    funcao = in.nextLine();

                                    if (funcao.isBlank()) {
                                        System.out.println("Campo nao pode ser vazio!");
                                    }
                                } while ((funcao.isBlank()));

                                //String documentoTipo ;
                                do {
                                    System.out.println("Documentos, voce deseja se cadastrar com seu CPF ou RG?");
                                    documentoTipo = in.nextLine();

                                    if (!documentoTipo.toUpperCase().equals("CPF") && !documentoTipo.toUpperCase().equals("RG")) {
                                        System.out.println("Opção inválida, digite exatamente CPF ou RG");
                                    }
                                } while (!documentoTipo.toUpperCase().equals("CPF") && !documentoTipo.toUpperCase().equals("RG"));

                                if (documentoTipo.toUpperCase().equals("CPF")) {
                                    //String documentoNumero;

                                    do {
                                        System.out.println("Por favor, digite seu CPF(apenas os 11 numeros): ");
                                        documentoNumero = in.nextLine();

                                        documentoNumero = documentoNumero.replaceAll("\\D", "");

                                        if (documentoNumero.length() != 11) {
                                            System.out.println("ERROR: numero de cpf inválido ");
                                        }

                                    } while (documentoNumero.length() != 11);

                                } else {
                                    //String documentoNumero;

                                    do {
                                        System.out.println("Por favor, digite seu RG: ");
                                        documentoNumero = in.nextLine();

                                        documentoNumero = documentoNumero.replaceAll("\\D", "");

                                        if (documentoNumero.length() != 7) {
                                            System.out.println("ERROR: numero de rg inválido ");
                                        }

                                    } while (documentoNumero.length() != 7);
                                }
                            }
                        } else {
                            System.out.println("Pressione ENTER para sair/");
                        }
                        break;
                    }

                case 2:
                    System.out.println("==Bem-vindo ao canal de consultas do acervo da  biblioteca M.S.C==");
                    System.out.println();

                    System.out.println("Como deseja buscar seu Livro, nomelivro/autor ou pela ISBN?");
                    String consultaLivro = in.nextLine();

                    if (consultaLivro.toUpperCase().equals("NOMELIVRO/AUTOR")) {
                        System.out.println("Digite o nomelivro/autor exatamente dessa forma, seguindo essas diretrizes:  ");
                        String consultaLivro1 = in.nextLine();
                    } else {

                        String isbn;
                        do {
                            System.out.println("Digite o numero do ISBN:  ");
                            isbn = in.nextLine();

                            isbn = isbn.replaceAll("\\D", "");

                            if (isbn.length() != 13) {
                                System.out.println("ERROR: numero inválido  ");
                            }
                        } while (isbn.length() != 13);
                    }
                    break;

                case 3:
                    System.out.println("============================================================================");
                    System.out.println("    Bem-vindo a area de empréstimo do acervo da  biblioteca de M.S.C    ");
                    System.out.println("============================================================================");
                    System.out.println("Lembrando que para tomar um livro emprestado é necessário ter um cadastro na biblioteca, voce já é cadastrado?");
                    String cadastro = in.nextLine();

                    if (cadastro.trim().toUpperCase().equals("SIM")) {
                        System.out.println("Como deseja buscar seu Livro para realizr o emprestimo, nomelivro/autor ou pela ISBN? ");
                        String cadastro1 = in.nextLine();

                        if (cadastro1.toUpperCase().equals("NOMELIVRO/AUTOR")) {
                            System.out.println("Digite o nomelivro/autor exatamente dessa forma, seguindo essas diretrizes:  ");
                            livroEmprestado = in.nextLine();

                        } else {
                            String isbn;
                            do {
                                System.out.println("Digite o numero do ISBN:  ");
                                isbn = in.nextLine();

                                isbn = isbn.replaceAll("\\D", "");

                                if (isbn.length() != 13) {
                                    System.out.println("ERROR: numero inválido  ");
                                }
                            } while (isbn.length() != 13);
                            livroEmprestado = "ISBN: " + isbn;
                        }

                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        //LocalDate dataDevolucao = null;
                        do {
                            System.out.println("Digite a data do emprestimo (dd/MM/yyyy)?");
                            String data = in.nextLine();

                            try {
                                dataEmprestimo = LocalDate.parse(data, formato);
                            } catch (DateTimeParseException e) {
                                System.out.println("ERROR: Formato de data inválido!");
                            }
                        } while (dataEmprestimo == null);


                        dataDevolucao = dataEmprestimo.plusDays(14);
                        System.out.println("Data limite para a devolução sem acréscimo de multa: " + dataDevolucao.format(formato));

                    } else {
                        System.out.println("Porfavor, voltar ao menu principal e realizar o cadastro");
                    }
                    break;


                case 4:
                    System.out.println("============================================================================");
                    System.out.println("    Bem-vindo ao canal de reservas do acervo da biblioteca M.S.C    ");
                    System.out.println("============================================================================");
                    System.out.println();
                    System.out.println("Para realizar uma reserva é necessário possuir um cadastro, voce possui um cadastro na biblioteca?");
                    String cadastroReserva = in.nextLine();

                    if (cadastroReserva.trim().toUpperCase().equals("SIM")) {
                        System.out.println("Lembrando que, de acordo com as diretrizes da biblioteca, só podemos reservar titulos que nao estejam disponiveis no momento,muito obrigado.\n" +
                                "Como deseja fazer sua busca, nomelivro/autor ou ISBN?");
                        String cadastroReserva1 = in.nextLine();

                        if (cadastroReserva1.toUpperCase().equals("NOMELIVRO/AUTOR")) {
                            System.out.println("Digite o nomelivro/autor exatamente dessa forma, seguindo essas diretrizes:  ");
                            String cadastroReserva3 = in.nextLine();
                        } else {
                            String isbn;
                            do {
                                System.out.println("Digite o numero do ISBN:  ");
                                isbn = in.nextLine();

                                isbn = isbn.replaceAll("\\D", "");

                                if (isbn.length() != 13) {
                                    System.out.println("ERROR: numero inválido  ");
                                }
                            } while (isbn.length() != 13);
                        }
                    } else {
                        System.out.println("Volte ao MENU inicial e faça o cadastro na biblioteca");
                    }

                    break;

                case 5:
                    System.out.println("============================================================================");
                    System.out.println("    Bem-vindo a area de devoluções do acervo da  biblioteca da M.S.C    ");
                    System.out.println("============================================================================");
                    System.out.println();

                    //String isbndevolucao;

                    do {

                        System.out.println("Para maior agilidade na devolução de titulos, os mesmos serão retornados via ISBN, portanto, digite os 13 numeros relacionados ao ISBN ?");
                        isbndevolucao = in.nextLine();
                        isbndevolucao = isbndevolucao.replaceAll("\\D", "");


                        if (isbndevolucao.length() != 13) {
                            System.out.println("ERROR: Numero inválido, tente novamente");

                        }
                    } while (isbndevolucao.length() != 13);

                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    //dataEmprestimoDevolucao = null;
                    do {

                        System.out.println("Digite a data de emprestimo como no formato(dd/MM/yyyy)");
                        String dataemprestimoStr = in.nextLine();

                        try {
                            dataEmprestimodevolucao = LocalDate.parse(dataemprestimoStr, formato);
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato inválido");
                        }

                    } while (dataEmprestimodevolucao == null);

                    dataDevolucaoRealizada = LocalDate.now();


                    int totalDiasEmprestado = (int) ChronoUnit.DAYS.between(dataEmprestimodevolucao, dataDevolucaoRealizada);
                    System.out.println(totalDiasEmprestado);

                    if (totalDiasEmprestado > 14) {
                        int diasAtrasado = totalDiasEmprestado - 14;
                        double valorMultaDiaria = 1.00;
                        double valorMulta = diasAtrasado * valorMultaDiaria;

                        System.out.println("Regulamento de empréstimos: Os livros devem ser devolvidos em até 14 dias corridos. Caso o prazo seja excedido, incidirá multa de R$ 1,00 para cada dia de atraso a contar do 15º dia.");
                        System.out.println("De acordo com nosso sistema, o Sr. esta em atraso por " + diasAtrasado + " dias, e o valor da multa será de " + valorMulta + " Reais");

                    } else {
                        int diasAtrasado = 0;
                        double valorMultaDiaria = 0.00;
                        System.out.println("Devolução realizada dentro do prazo! muito obrigado por utilizar as bibliotecas da UEM, volte sempre");
                    }
                    break;

                case 7:
                    System.out.println("============================================================================");
                    System.out.println("                               Sobre                                        ");
                    System.out.println("============================================================================");
                    System.out.println("Agora voce vai saber muito mais sobre a Biblioteca Monasterio de Santa Catarina");
                    System.out.println("A Biblioteca do Mosteiro de Santa Catarina (oficialmente Mosteiro da Santa Transfiguração ou Mosteiro da Sarça Ardente), localizada na península do Sinai," +
                            " no Egito, é reconhecida como a biblioteca em funcionamento contínuo mais antiga do mundo.   Fundada no século VI pelo imperador bizantino Justiniano I, ela resistiu a impérios," +
                            " guerras e intempéries climáticas por mais de 1.400 anos, mantendo sua coleção praticamente intacta. O Acervo Documental\n" +
                            "A biblioteca guarda a segunda maior coleção de manuscritos cristãos antigos do mundo, ficando atrás apenas da Biblioteca Apostólica Vaticana.\n" +
                            "\n" +
                            "Manuscritos Antigos: Abriga cerca de 3.300 a 3.500 manuscritos escritos em diversos idiomas antigos (grego, siríaco, árabe, georgiano, copta, armênio, etíope e latim). O Achtiname (A Carta de Proteção de Maomé)\n" +
                            "Um dos documentos mais historicamente valiosos guardados pela comunidade monástica é o Achtiname de Maomé. Preservação Digital e Modernização\n" +
                            "Nos últimos anos, o mosteiro firmou parcerias com instituições internacionais de pesquisa (como a UCLA, a Early Manuscripts Electronic Library e a Biblioteca do Congresso dos EUA) para digitalizar todo o seu acervo de manuscritos.");

                    break;

                case 8:
                    System.out.println("============================================================================");
                    System.out.println("              Seu Carrinho da Biblioteca/Resumo                             ");
                    System.out.println("============================================================================");
                    System.out.println();
                    System.out.println("--- Dados Cadastrais ---");
                    System.out.println();
                    if (tipoUsuario != null) {
                        System.out.println("Tipo de usuario: " + tipoUsuario);
                        if (nomeUsuario != null) System.out.println("Nome: " + nomeUsuario);
                        if (dataNascimento != null) System.out.println("Data de nascimento: " + dataNascimento);
                        if (funcao != null) System.out.println("Função/materia: " + funcao);
                        if (documentoTipo != null) System.out.println("Tipo de documento: " + documentoTipo);
                        if (documentoNumero != null) System.out.println("Numero do documento: " + documentoNumero);
                        if (periodo != null) System.out.println("Periodo: " + periodo);
                    } else {
                        System.out.println("Nenhum cadastro realizado!");
                    }

                    System.out.println("--- Dados do Empréstimo ---");
                    if(livroEmprestado != null) {
                        System.out.println("Livro emprestado: " + livroEmprestado);
                        System.out.println("Data do emprestimo: " + dataEmprestimo);
                        System.out.println("Data de devolução: " + dataDevolucao);

                    } else {
                        System.out.println("Nenhum empréstimo realizado!");
                    }

                    System.out.println("--- Dados da Devolução ---");
                    if(devolucao != null) {
                        System.out.println("Livro devolvido: " + isbndevolucao);
                        System.out.println("Data do emprestimo: " + dataEmprestimodevolucao);
                        System.out.println("Data da devolução: " + dataDevolucaoRealizada);
                    } else {
                        System.out.println("Nenhuma devolução registrada!");
                    }
                    break;
            }
        }while (opcao != 6) ;
    }
}