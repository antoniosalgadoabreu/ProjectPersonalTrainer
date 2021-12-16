package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import control.Aluno;
import control.Cadastro;
import control.Login;
import control.Pessoa;
import control.Professor;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;


public class TBase extends JFrame {
	
	private JPanel contentPane;
	TLogin tlg;
	String caminho = "C:\\Users\\anton\\Documents\\GitHub\\ProjectPersonalTrainer\\txt";
	Pessoa pessoa ;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TBase frame = new TBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public TBase() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, d.width, d.height);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		tlg = new TLogin(desktopPane,caminho);
		desktopPane.add(tlg);
		
		if(verificarArquivoTxt(caminho+"Aluno.txt",caminho+"Professor.txt",caminho+"Tabelas.txt")){
			JOptionPane.showMessageDialog(null, "Arquivo localizado.");
		}else {
			JOptionPane.showMessageDialog(null, "Arquivo criado.");
		}
	
	}

	public boolean verificarArquivoTxt(String caminhoAluno , String caminhoProf, String caminhoTabelas) {
		
		boolean verificador = false;
		
		try {
			File arquivo1 = new File(caminhoAluno);
			File arquivo2 = new File(caminhoProf);
			File arquivo3 = new File(caminhoTabelas);
			
			if(arquivo1.exists()&&arquivo2.exists()&&arquivo3.exists()) {
				verificador = true;
			}else {
				String caminhoAluno2 = caminho.substring(0,caminho.lastIndexOf("\\"));
				File arquivo4 = new File(caminhoAluno2);
				String caminhoProf2 = caminho.substring(0,caminho.lastIndexOf("\\"));
				File arquivo5 = new File(caminhoProf2);
				String caminhoTabelas2 = caminho.substring(0,caminho.lastIndexOf("\\"));
				
				File arquivo6 = new File(caminhoTabelas2);
				
				arquivo4.mkdirs();
				arquivo5.mkdirs();
				arquivo6.mkdirs();

				if(!arquivo1.createNewFile()&&!arquivo2.createNewFile()&&!arquivo3.createNewFile()) {
					verificador = false;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return verificador;
	}

}
