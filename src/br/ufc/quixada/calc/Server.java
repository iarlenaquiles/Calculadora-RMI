package br.ufc.quixada.calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calc {

	public Server() {
	}

	@Override
	public String sayHello() {
		return "Hello, world!";
	}

	@Override
	public double mul(double n1, double n2) throws RemoteException {
		return n1 * n2;
	}

	public static void main(String args[]) {
		try {
			Server obj = new Server();
			Calc stub = (Calc) UnicastRemoteObject.exportObject(obj, 0);

			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Calc", stub);

			System.err.println("Servidor pronto");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	@Override
	public double som(double n1, double n2) throws RemoteException {
		return n1 + n2;
	}

	@Override
	public double sub(double n1, double n2) throws RemoteException {
		return n1 - n2;
	}

	@Override
	public double div(double n1, double n2) throws RemoteException {
		if (n2 != 0)
			return n1 / n2;
		return 0;
	}
}
