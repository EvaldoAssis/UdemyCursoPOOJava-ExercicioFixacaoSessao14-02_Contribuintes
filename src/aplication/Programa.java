package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Enter the number of tax payers: ");
		int N = sc.nextInt();
		
		Contribuinte contribuinte;
		List<Contribuinte> list = new ArrayList();
		
		for (int i = 1; i <= N; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (f/j)? ");
			char tipo = sc.next().charAt(0);
			System.out.print("Name: ");
			String nome = sc.next();
			System.out.print("Anual income: ");
			double rendaAnual = sc.nextDouble();
			
			if (tipo == 'f') {
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				contribuinte = new PessoaFisica(nome, rendaAnual, gastosSaude);
				list.add(contribuinte);
			}
			
			else {
				System.out.print("Number of employees: ");
				int numeroFuncionarios = sc.nextInt();
				contribuinte = new PessoaJuridica(nome, rendaAnual, numeroFuncionarios);
				list.add(contribuinte);
			}
			
		}
		
		System.out.println();
		System.out.println("TAXAS: ");
		
		double somaTaxas = 0;
		
		for (Contribuinte c : list) {
			System.out.println(c.getNome() + ": $ " + String.format("%.2f", c.taxa()));
			somaTaxas += c.taxa();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXAS: $ " + String.format("%.2f", somaTaxas));
		
	}

}
