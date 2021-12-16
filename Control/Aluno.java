package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Aluno extends Pessoa {

		private String anteBracoD, anteBracoE, pernaD, pernaE, torax, quadril, cintura, panturrilhaD, panturrilhaE;
		private String dCTriceps, dCSubescapular, dCAbdominal, dCCoxaMedial, dCPanturrilhaMedial, dCTorax, dCBiceps;
		private String dCAxilaMedial, dCSupraIliaca, dCSupraEspinal,peso, altura, bracoD, bracoE, oBS;
		private String aBracoD;
		
		
		public String getAnteBracoD() {
			return anteBracoD;
		}


		public void setAnteBracoD(String anteBracoD) {
			this.anteBracoD = anteBracoD;
		}


		public String getAnteBracoE() {
			return anteBracoE;
		}


		public void setAnteBracoE(String anteBracoE) {
			this.anteBracoE = anteBracoE;
		}


		public String getPernaD() {
			return pernaD;
		}


		public void setPernaD(String pernaD) {
			this.pernaD = pernaD;
		}


		public String getPernaE() {
			return pernaE;
		}


		public void setPernaE(String pernaE) {
			this.pernaE = pernaE;
		}


		public String getTorax() {
			return torax;
		}


		public void setTorax(String torax) {
			this.torax = torax;
		}


		public String getQuadril() {
			return quadril;
		}


		public void setQuadril(String quadril) {
			this.quadril = quadril;
		}


		public String getCintura() {
			return cintura;
		}


		public void setCintura(String cintura) {
			this.cintura = cintura;
		}


		public String getPanturrilhaD() {
			return panturrilhaD;
		}


		public void setPanturrilhaD(String panturrilhaD) {
			this.panturrilhaD = panturrilhaD;
		}


		public String getPanturrilhaE() {
			return panturrilhaE;
		}


		public void setPanturrilhaE(String panturrilhaE) {
			this.panturrilhaE = panturrilhaE;
		}


		public String getdCTriceps() {
			return dCTriceps;
		}


		public void setdCTriceps(String dCTriceps) {
			this.dCTriceps = dCTriceps;
		}


		public String getdCSubescapular() {
			return dCSubescapular;
		}


		public void setdCSubescapular(String dCSubescapular) {
			this.dCSubescapular = dCSubescapular;
		}


		public String getdCAbdominal() {
			return dCAbdominal;
		}


		public void setdCAbdominal(String dCAbdominal) {
			this.dCAbdominal = dCAbdominal;
		}


		public String getdCCoxaMedial() {
			return dCCoxaMedial;
		}


		public void setdCCoxaMedial(String dCCoxaMedial) {
			this.dCCoxaMedial = dCCoxaMedial;
		}


		public String getdCPanturrilhaMedial() {
			return dCPanturrilhaMedial;
		}


		public void setdCPanturrilhaMedial(String dCPanturrilhaMedial) {
			this.dCPanturrilhaMedial = dCPanturrilhaMedial;
		}


		public String getdCTorax() {
			return dCTorax;
		}


		public void setdCTorax(String dCTorax) {
			this.dCTorax = dCTorax;
		}


		public String getdCBiceps() {
			return dCBiceps;
		}


		public void setdCBiceps(String dCBiceps) {
			this.dCBiceps = dCBiceps;
		}


		public String getdCAxilaMedial() {
			return dCAxilaMedial;
		}


		public void setdCAxilaMedial(String dCAxilaMedial) {
			this.dCAxilaMedial = dCAxilaMedial;
		}


		public String getdCSupraIliaca() {
			return dCSupraIliaca;
		}


		public void setdCSupraIliaca(String dCSupraIliaca) {
			this.dCSupraIliaca = dCSupraIliaca;
		}


		public String getdCSupraEspinal() {
			return dCSupraEspinal;
		}


		public void setdCSupraEspinal(String dCSupraEspinal) {
			this.dCSupraEspinal = dCSupraEspinal;
		}


		public String getPeso() {
			return peso;
		}


		public void setPeso(String peso) {
			this.peso = peso;
		}


		public String getAltura() {
			return altura;
		}


		public void setAltura(String altura) {
			this.altura = altura;
		}


		public String getBracoD() {
			return bracoD;
		}


		public void setBracoD(String bracoD) {
			this.bracoD = bracoD;
		}


		public String getoBS() {
			return oBS;
		}


		public void setoBS(String oBS) {
			this.oBS = oBS;
		}


		public String getBracoE() {
			return bracoE;
		}


		public void setBracoE(String bracoE) {
			this.bracoE = bracoE;
		}
	public boolean editarArquivo(String caminhoAluno, String codigo,String cpf, String senha, String nome, String email, String tipo,
			Date dataNasc, String anteBracoD, String anteBracoE, String pernaD, String pernaE, String torax, String quadril,
			String cintura, String panturrilhaD, String panturrilhaE, String dCTriceps, String dCSubescapular,
			String dCAbdominal, String dCCoxaMedial, String dCPanturrilhaMedial, String dCTorax, String dCBiceps,
			String dCAxilaMedial, String dCSupraIliaca, String dCSupraEspinal, String peso, String altura, String bracoD,
			String bracoE, String oBS ) {
			
			boolean verificador = false;
			String linhaSubstituicao = codigo+"#"+cpf+"#"+senha+"#"+tipo+"#"+nome+"#"+email+"#"+dataNasc+"#"+altura+"#"+peso+"#"+anteBracoD+"#"+anteBracoE+"#"+bracoD+"#"+bracoE+"#"+cintura+"#"+quadril+"#"+torax+"#"+pernaE+"#"+pernaD+"#"+panturrilhaE+"#"+panturrilhaD+"#"+oBS+"#"+dCAxilaMedial+"#"+dCAbdominal+"#"+dCBiceps+"#"+dCCoxaMedial+"#"+dCPanturrilhaMedial+"#"+dCSubescapular+"#"+dCSupraEspinal+"#"+dCSupraIliaca+"#"+dCTorax+"#"+dCTriceps;

				try {
					String dado[] = linhaSubstituicao.split("#");
					String caminho2 = caminhoAluno.replace(".txt","2.txt");
					verificarArquivoTxt(caminho2);
					BufferedReader br = new BufferedReader(new FileReader(caminhoAluno));
					BufferedWriter bw = new BufferedWriter(new FileWriter(caminho2,true));
					
					while(br.ready()) {
						String linhaAux = br.readLine();
						String dadoAux[] = linhaAux.split("#");
						if(dado[0].equals(dadoAux[0])) {
							bw.write(linhaSubstituicao);
							verificador = true;
							bw.newLine();
						}else {
							bw.write(linhaAux);
							bw.newLine();
						}
					
					}
					
					bw.close();
					br.close();
					transferirArquivo(caminho2,caminhoAluno);

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
	public Aluno(String cpf, String senha, String nome, String email, String caminho, String proximo, String tipo,
			String dataNasc, String anteBracoD, String anteBracoE, String pernaD, String pernaE, String torax, String quadril,
			String cintura, String panturrilhaD, String panturrilhaE, String dCTriceps, String dCSubescapular,
			String dCAbdominal, String dCCoxaMedial, String dCPanturrilhaMedial, String dCTorax, String dCBiceps,
			String dCAxilaMedial, String dCSupraIliaca, String dCSupraEspinal, String peso, String altura, String bracoD,
			String bracoE, String oBS) {
		super(cpf, senha, nome, email, caminho, proximo, tipo, dataNasc, oBS);
		this.anteBracoD = anteBracoD;
		this.anteBracoE = anteBracoE;
		this.pernaD = pernaD;
		this.pernaE = pernaE;
		this.torax = torax;
		this.quadril = quadril;
		this.cintura = cintura;
		this.panturrilhaD = panturrilhaD;
		this.panturrilhaE = panturrilhaE;
		this.dCTriceps = dCTriceps;
		this.dCSubescapular = dCSubescapular;
		this.dCAbdominal = dCAbdominal;
		this.dCCoxaMedial = dCCoxaMedial;
		this.dCPanturrilhaMedial = dCPanturrilhaMedial;
		this.dCTorax = dCTorax;
		this.dCBiceps = dCBiceps;
		this.dCAxilaMedial = dCAxilaMedial;
		this.dCSupraIliaca = dCSupraIliaca;
		this.dCSupraEspinal = dCSupraEspinal;
		this.peso = peso;
		this.altura = altura;
		this.bracoD = bracoD;
		this.bracoE = bracoE;
		this.oBS = oBS;
	}


	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	public boolean localizarCodigo(String caminhologin, String codigoBuscado) {

		boolean verificador = false;
		
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhologin));
				while(br.ready()) {
					String linha = br.readLine();
					String dados[] = linha.split("#");
					
					if(codigoBuscado.equals(dados[0])) {
						
						verificador = true;	
							
							String cpf =dados[1];
							String senha = dados[2];
							String nome = dados[4];
							String email = dados[5];	
							String dataNasc = dados[6] ;
							String proximo = dados[0];
							String peso = dados[8];
							String altura = dados[7];
							String bracoD = dados[11];
							String bracoE = dados[12];
							String oBS = dados[20];
							String anteBracoD= dados[9];
							String anteBracoE = dados[10];
							String pernaD = dados[17];
							String pernaE=dados[16];
							String torax = dados[29];
							String quadril = dados[14];
							String cintura = dados[13];
							String panturrilhaD = dados[19];
							String panturrilhaE = dados[18];
							String dCTriceps = dados[30];
							String dCSubescapular = dados[26];
							String dCAbdominal = dados[23];
							String dCCoxaMedial = dados[24];
							String dCPanturrilhaMedial = dados[25];
							String dCTorax = dados[29];
							String dCBiceps = dados[23];
							String dCAxilaMedial = dados[21];
							String dCSupraIliaca = dados[28];
							String dCSupraEspinal = dados[27];
							String caminho = caminhologin;
							String tipo = dados[3];
							
							this.setCpf(dados[1]);
							this.setSenha(dados[2]);
							this.setTipo(dados[3]);
							this.setProximo(dados[0]);
							this.setNome(dados[4]);
							this.setEmail(dados[5]);	
							this.setDataNasc(dados[6]) ;
							this.anteBracoD = anteBracoD;
							this.anteBracoE = anteBracoE;
							this.pernaD = pernaD;
							this.pernaE = pernaE;
							this.torax = torax;
							this.quadril = quadril;
							this.cintura = cintura;
							this.panturrilhaD = panturrilhaD;
							this.panturrilhaE = panturrilhaE;
							this.dCTriceps = dCTriceps;
							this.dCSubescapular = dCSubescapular;
							this.dCAbdominal = dCAbdominal;
							this.dCCoxaMedial = dCCoxaMedial;
							this.dCPanturrilhaMedial = dCPanturrilhaMedial;
							this.dCTorax = dCTorax;
							this.dCBiceps = dCBiceps;
							this.dCAxilaMedial = dCAxilaMedial;
							this.dCSupraIliaca = dCSupraIliaca;
							this.dCSupraEspinal = dCSupraEspinal;
							this.peso = peso;
							this.altura = altura;
							this.bracoD = bracoD;
							this.bracoE = bracoE;
							this.oBS = oBS;
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


	public String getaBracoD() {
		return aBracoD;
	}


	public void setaBracoD(String aBracoD) {
		this.aBracoD = aBracoD;
	}

}
