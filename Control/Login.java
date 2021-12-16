package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login {
	private String codigo="";
	public boolean verificarLogin(String caminhologin, String loginTlogin, String senhaTlogin, String tipo) {
		
		boolean verificador = false;
		
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhologin));
				while(br.ready()) {
					String linha = br.readLine();
					String dados[] = linha.split("#");
					String cpf =dados[1];
					String senha = dados[2];
					
					if(cpf.equals(loginTlogin)&&senha.equals(senhaTlogin)) {
						verificador = true;
						codigo = dados[0];
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
