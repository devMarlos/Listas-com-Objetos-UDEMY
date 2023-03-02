package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Instanciando a lista
		List<Employee> list = new ArrayList<>();
		
		// Registrando os funcionários
		System.out.println("How many employees will be registered? ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while(hasId(list,id)) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();	
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		// Id para incrementar um salário
		System.out.println("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();
		//Verificação do id
		Integer pos = position(list, idsalary);
		if(pos == null) {
			System.out.println("This id does not exist!");
		}
		else {
			// Incremento do salário
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employess: ");
		for(Employee emp : list) {
			System.out.println(emp);
		}
			
		
		sc.close();
	}
	// Validação da posição do id na lista
	public static Integer position(List<Employee> list, int id) {
		for (int i=0; i< list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	// Verificação de id repetido
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
