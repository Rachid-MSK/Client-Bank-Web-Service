package test;

import java.rmi.RemoteException;

import ws.BanqueServiceProxy;
import ws.Compte;

public class ClientWS {
	public static void main(String[] args) throws Exception {
		BanqueServiceProxy proxy= new BanqueServiceProxy();
		System.out.println(proxy.conversionEuroToDh(80));
		Compte compte= proxy.getCompte(3);
		System.out.println("Code= "+compte.getCode());
		System.out.println("Solde= "+compte.getSolde());
		Compte[] cptes= proxy.listeCompte();
		for(Compte cp:cptes) {
			System.out.println("********************");
			System.out.println("Code= "+cp.getCode());
			System.out.println("Solde= "+cp.getSolde());
		}
	}

}
