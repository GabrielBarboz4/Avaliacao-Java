package br.com.senai;

import java.util.Scanner;

public class Avaliacao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Variaveies 1 questão
        final int year = 2024;
        String haveChildren;
        String civilStatus = "";
        //Variaveis 2 questão
        final double loanLimit = 5001.83;
        String isAproved;
        String balanceDegree;

        System.out.println("################");
        System.out.println("Bem vindo ao SYSTEM NEW");
        System.out.println("Para prosseguirmos nos diga seu nome:");
        String clientName = input.nextLine();
        System.out.printf("Olá %s, ficamos felizes em revelo", clientName);
        System.out.println("""
                
                Digite qual a opção desejada
                1 - Cadastrar dados complementares;
                2 - Consultar a possibilidade de empréstimo;
                """);
        int enterdedValue = input.nextInt();

        switch (enterdedValue){
            case 1:
                System.out.println("Bem vindo " + clientName + " ao cadastro de dados complementares");
                System.out.println("Informe o ano que você nasceu");
                int birthYear = input.nextInt();
                int age = year - birthYear;
                String agePeriod;

                if (age <= 15) {
                    agePeriod = "criança";
                } else if (age <= 17) {
                    agePeriod = "jovem";
                } else if (age <= 63) {
                    agePeriod = "adulto";
                } else {
                    agePeriod = "idoso";
                }

                input.nextLine();
                System.out.println("Informe qual seu sexo (feminino, masculino, outro)");
                String clientGender = input.nextLine();
                System.out.println("Qual seu estado civil?");
                System.out.println("""
                        1 - Solteiro;
                        2 - Casado;
                        3 - Divorciado;
                        """);

                int state;
                boolean status = true;

                while (status) {
                    System.out.println("Digite o valor correspondete ao seu estado civil");
                    state =  input.nextInt();
                    switch (state) {
                        case 1:
                            civilStatus = "solteiro";
                            status = false;
                            break;
                        case 2:
                            civilStatus = "casado";
                            input.nextLine();
                            System.out.println("Infome o nome de seu conjugê");
                            String partnerName = input.nextLine();
                            System.out.println("Possui filhos? (DIGITE S/N)");
                            haveChildren = input.nextLine();

                            if (haveChildren.equalsIgnoreCase("s")) {
                                System.out.println("Quantos filhos?");
                                int howMany = input.nextInt();
                                System.out.println("\nCliente: " + clientName + " é do sexo " + clientGender);
                                System.out.println("Possui " + age + " anos de idade");
                                System.out.println("É " + civilStatus + " com " + partnerName + " o qual possuem " + howMany + " filhos, é classificado como: " + agePeriod);
                                System.exit(0);
                            }

                            System.out.println("\nCliente: " + clientName + " é do sexo " + clientGender);
                            System.out.println("Possui " + age + " anos de idade");
                            System.out.println("É " + civilStatus + " com " + partnerName +" e, não possuem filhos, " + clientName + " é classificado como: " + agePeriod);
                            System.exit(0);
                            break;
                        case 3:
                            input.nextLine();
                            civilStatus = "divorciado";
                            System.out.println("Possui filhos? (DIGITE S/N)");
                            haveChildren = input.nextLine();

                            if (haveChildren.equalsIgnoreCase("s")) {
                                System.out.println("Quantos filhos?");
                                int howMany = input.nextInt();
                                System.out.println("\nCliente: " + clientName + " é do sexo " + clientGender);
                                System.out.println("Possui " + age + " anos de idade");
                                System.out.println("É " + civilStatus + " e possui " + howMany + " filhos, é classificado como: " + agePeriod);
                                System.exit(0);
                            }

                            System.out.println("\nCliente: " + clientName + " é do sexo " + clientGender);
                            System.out.println("Possui " + age + " anos de idade");
                            System.out.println("É " + civilStatus + " não possui filhos, e é classificado como: " + agePeriod);
                            System.exit(0);
                            break;
                        default:
                            System.out.println("valor inválido");
                    }
                }
                System.out.println("\nCliente: " + clientName + " é do sexo " + clientGender);
                System.out.println("Possui " + age + " anos de idade");
                System.out.println("É " + civilStatus + " e é classificado como: " + agePeriod);
                break;
            case 2:
                System.out.println("CONSULTA DE EMPRESTIMO --- SYSTEM NEW");
                System.out.println("Digite seu o seu saldo atual:");
                double currentBalence = input.nextDouble();
                System.out.println("Informe o valor de empréstimo desejado:");
                double desiredLoan = input.nextDouble();
                System.out.println("De acordo com informamos que recebemos, aqui está seu resultado:");
                System.out.println("Cliente: " + clientName);
                System.out.println("Saldo: R$" + currentBalence);
                System.out.println("Limite disponível crédito: R$" + loanLimit);

                boolean aprovedLoan = true;
                if (desiredLoan > loanLimit || loanLimit > currentBalence) aprovedLoan = false;

                isAproved = (aprovedLoan) ? "aprovado" : "negado";
                balanceDegree = (aprovedLoan) ? "superior" : "inferior";

                System.out.println(clientName + " o valor solicitado de R$" + desiredLoan + " foi " + isAproved + " devido ao seu saldo ser " + balanceDegree);
                break;
            default:
                System.out.println("Valor digitado inválido");
        }
    }
}
