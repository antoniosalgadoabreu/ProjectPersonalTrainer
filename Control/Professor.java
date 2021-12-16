package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Professor extends Pessoa {
	private String cref;

	public Professor(String cpf, String senha, String nome, String email, String caminho, String proximo, String tipo,
			String dataNasc, String cref) {
		super(cpf, senha, nome, email, caminho, proximo, tipo, dataNasc, cref);
		this.cref = cref;
	}
	public Professor() {
		// TODO Auto-generated constructor stub
	}
	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}
public boolean localizarCodigo(String caminhoLogin, String codigoBuscado) {
	
	String linha = null;
	String codigo = null;
	
		boolean verificador = false;
		
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhoLogin));
				while(br.ready()) {
					linha = br.readLine();
					String dados[] = linha.split("#");
					codigo =dados[0];
					
					if(codigo.equals(codigoBuscado)) {
							this.setCpf(dados[1]);
							this.setSenha(dados[2]);
							this.setTipo(dados[3]);
							this.setCaminho(caminhoLogin);
							this.setProximo(dados[0]);
							this.setNome(dados[4]);
							this.setEmail(dados[5]);	
							this.setDataNasc(dados[6]) ;
							this.cref = dados[7];
							
							break;
					}else {
						verificador = false;
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
public boolean editarArquivo(String caminhoLogin,String codigo ,String cpf, Object nome, String cref, String tipo, Date dataNasc, Object senha, Object email) {
	
	boolean verificador = false;
		
		String linhaSubstituicao=codigo+"#"+cpf+"#"+senha+"#"+tipo+"#"+nome+"#"+email+"#"+dataNasc+"#"+cref;
		try {
			String dado[] = linhaSubstituicao.split("#");
			String caminho2 = caminhoLogin.replace(".txt","2.txt");
			verificarArquivoTxt(caminho2);
			BufferedReader br = new BufferedReader(new FileReader(caminhoLogin));
			BufferedWriter bw = new BufferedWriter(new FileWriter(caminho2,true));
			
			while(br.ready()) {
				String linhaAux = br.readLine();
				String dadoAux[] = linhaAux.split("#");
				if(dado[0].equals(dadoAux[0])) {
					bw.write(linhaSubstituicao);
					bw.newLine();
					verificador = true;
				}else {
					bw.write(linhaAux);
					bw.newLine();
				}
			
			}
			
			bw.close();
			br.close();
			transferirArquivo(caminho2,caminhoLogin);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return verificador;
}
public void transferirArquivo(String caminho1, String caminho2) {
try {
	
	BufferedReader arq1 = new BufferedReader(new FileReader(caminho1));
	BufferedWriter arq2 = new BufferedWriter(new FileWriter(caminho2));
	String linha;
	while(arq1.ready()) {
		linha = arq1.readLine();
		arq2.write(linha);
		arq2.newLine();
	}
	arq1.close();
	arq2.close();	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
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
		verificador = true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		verificador = true;
	}
	return verificador;
}	
public boolean excluirArquivo(String caminhoLogin,String codigo) {
	
	boolean verificador = false;
		
		try {
			String caminho2 = caminhoLogin.replace(".txt","2.txt");
			verificarArquivoTxt(caminho2);
			BufferedReader br = new BufferedReader(new FileReader(caminhoLogin));
			BufferedWriter bw = new BufferedWriter(new FileWriter(caminho2,true));
			
			while(br.ready()) {
				String linhaAux = br.readLine();
				String dadoAux[] = linhaAux.split("#");
				if(dadoAux[0].equals(codigo)) {					
					verificador = true;
				}else {
					bw.write(linhaAux);
					bw.newLine();
				}
			
			}
			
			bw.close();
			br.close();
			transferirArquivo(caminho2,caminhoLogin);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return verificador;
}
}
