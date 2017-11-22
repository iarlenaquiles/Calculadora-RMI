package br.ufc.quixada.calc;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	private Client() {
	}

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			Calc proxy = (Calc) registry.lookup("Calc");
			String response = proxy.sayHello();
			System.out.println("Resposta: " + response);
			double resultado = proxy.mul(20, 35);
			System.out.println("Mul 20 * 35 = " + resultado);
			
			double resultSoma = proxy.som(20, 35);
			System.out.println("Som 20 + 35 = " + resultSoma);
			
			double resultSub = proxy.sub(20, 35);
			System.out.println("Sub 20 - 35 = " + resultSub);
			
			double resultDiv = proxy.div(20, 35);
			System.out.println("Div 20 / 35 = " + resultDiv);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
