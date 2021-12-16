package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Cadastro {
	public boolean verificarExistenciaUsuario(String caminhologin, String cpf, String tipo) {
		boolean verificador = true;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(caminhologin));
			while(br.ready()) {
				String linha = br.readLine();
				String dado []= linha.split("#");
				if(dado[1].equals(cpf)&&dado[3].equals(tipo)) {
					verificador = false;
					break;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verificador;
	}
	public boolean metodoCadastro(String caminhologin, String nome, String cpf, String senha, String cref, String tipo, Date dataNasc, String email) {

		if(verificarExistenciaUsuario(caminhologin,cpf,tipo)) {
						
			try {
				String proximo = proximoCodigo(caminhologin);
				BufferedWriter bw = new BufferedWriter(new FileWriter(caminhologin,true));
				bw.write(proximo+"#"+cpf+"#"+senha+"#"+tipo+"#"+nome+"#"+email+"#"+dataNasc+"#"+cref);
				bw.newLine();
				bw.close();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
		
	}
	public String proximoCodigo(String caminhologin) {
		
		int proximo = 0;
		
		try {
			String linha="", codigo="";
			BufferedReader br = new BufferedReader(new FileReader(caminhologin));
			
			while(br.ready()) {
				linha = br.readLine();
				codigo = linha.substring(0,linha.indexOf("#"));
				if(proximo <= Integer.parseInt(codigo)) {
					proximo = Integer.parseInt(codigo);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Integer.toString(proximo+1));
	}
	
	
public boolean verificarArquivoTxt(String caminho) {
		
		boolean verificador = false;
		
		try {
			File arquivo = new File(caminho);
			if(arquivo.exists()) {
				verificador = true;
			}else {
				String caminho2 = caminho.substring(0,caminho.lastIndexOf("\\"));
				File arquivo2 = new File(caminho2);
				arquivo2.mkdirs();
				if(!arquivo.createNewFile()) {
					verificador = false;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return verificador;
	}
public boolean metodoCadastro(String caminhologin, String nome, String cpf, String senha, String tipo, Date dataNasc, String email, String altura, String peso, String aBracoD, String aBracoE, String bracoD, String bracoE, String cintura, String quadril, String torax, String pernaE, String pernaD, String panturrilhaE, String panturrilhaD, String obs, String dcAxilaMedial, String dcAbdominal, String dcBiceps, String dcCoxaMedial, String dcPanturrilhaMedial, String dcSubscapular, String dcSupraEspinal, String dcSupraIliaca, String dcTorax, String dcTriceps) {
	if(verificarExistenciaUsuario(caminhologin, cpf, tipo)) {
		try {
			String proximo = proximoCodigo(caminhologin);
			BufferedWriter bw = new BufferedWriter(new FileWriter(caminhologin,true));
			bw.write(proximo+"#"+cpf+"#"+senha+"#"+tipo+"#"+nome+"#"+email+"#"+dataNasc+"#"+altura+"#"+peso+"#"+aBracoD+"#"+aBracoE+"#"+bracoD+"#"+bracoE+"#"+cintura+"#"+quadril+"#"+torax+"#"+pernaE+"#"+pernaD+"#"+panturrilhaE+"#"+panturrilhaD+"#"+obs+"#"+dcAxilaMedial+"#"+dcAbdominal+"#"+dcBiceps+"#"+dcCoxaMedial+"#"+dcPanturrilhaMedial+"#"+dcSubscapular+"#"+dcSupraEspinal+"#"+dcSupraIliaca+"#"+dcTorax+"#"+dcTriceps);
			bw.newLine();
			bw.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}else {
		return false;
	}
}
}
