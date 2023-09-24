package application;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionarios;


public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Funcionarios func = null; //inicialização da variável objeto

		List<Funcionarios> list = new ArrayList<>();
		System.out.print("Quantos funcionários serão cadastrados?: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.printf("Funcionário %d:\n", i + 1);
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();

			func = new Funcionarios(id, nome, salario);
			list.add(func); /*a cada iteração do loop, todos os dados digitados e armazenados no construtor será
			adicionado na lista através desta funçaõ*/
		}
		
		System.out.println();
		System.out.print("Entre com o id do funcionário a ser aumentado: ");
		int idAumento = sc.nextInt();
		
		Integer pos = posicao(list, idAumento); /*foi passado para dentro da função 'posicao()' a 'list' e o 
		'idAumento' que serão os valores a serem utilizados como argumentos dentro da função 'posicao()'. O 'idAumento
		eu escrevi para comparação e a 'list' está armazenando todos os funcionários 'func'*/
		
		if(pos == null) {
			System.out.println();
			System.out.println("Id inexistente!");
		}else {
			System.out.print("Entre com a porcentagem: ");
			list.get(pos).aumento(sc.nextDouble()); /*Dentro da 'list' eu peguei a posição ('pos') que está 
			armazenando o retorno da função 'posicao()' que é o índice da lista onde o salário será calculado, 
			logo após, chamei a função dentro da classe 'Funcionarios' para efetuar o cálculo do salário */
		}
		
		System.out.println();
		for (Funcionarios x : list) { /*Para cada objeto de tipo 'Funcionarios' identificado por 'x', contido na 
		'list', faça:..*/
			System.out.println(x);			
		}

		sc.close();
	}
	
	public static Integer posicao(List<Funcionarios> lista, int idAumento) {
		for(int i = 0; i < lista.size();i++) {
			if(lista.get(i).getId() == idAumento) { /* a 'lista' vai pegar a posição do 'i' na função do 'getId'
			armazenada dentro da classe 'Funcionarios' para comparar se o 'id' passado como argumento é o
			mesmo que está dentro da list.*/
				return i; /*aqui retornará a posição desse 'id' pego na lista. A posição do 'id' capturado aqui
				será o índice do salário a ser calculado
				*/
			}
		}
		return null; //caso não encontre o 'id' digitado na lista, retornará null, ou seja, valor vazio
	}

}