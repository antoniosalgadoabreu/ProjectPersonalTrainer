package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import control.Login;
import control.Pessoa;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TLogin extends JInternalFrame  {
	private JFormattedTextField txtCpf;
	private JTextField txtSenha;
	private String tipo = "";
	private MaskFormatter mascaraCpf;

	
	
	/**
	 * Create the frame.
	 * @param desktopPane 
	 * @param caminho 
	 * @wbp.parser.constructor
	 */
	public TLogin(JDesktopPane desktopPane, String caminho) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, d.width, d.height);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("CPF:");
		lblLogin.setBounds(100, 54, 46, 14);
		panel.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(100, 87, 46, 14);
		panel.add(lblSenha);
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(156, 51, 126, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(156, 84, 126, 20);
		panel.add(txtSenha);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtCpf.equals("")||txtSenha.equals("")||tipo.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor preencher as barras de texto do login, da senha e escolher seu tipo de usuario. ");
				}else {
					Login login = new Login();
					String caminhologin = "";
					String caminhoTabelas = caminho+"Tabelas.txt";
					if(tipo.equals("professor")) {	
						caminhologin = caminho+"Professor.txt" ;
					}else {
						caminhologin = caminho+"Aluno.txt" ;
					}
					if(login.verificarLogin(caminhologin,txtCpf.getText(),txtSenha.getText(),tipo)) {
						switch(tipo) {
						case "aluno":
							String codigoAluno = login.getCodigo();
							TAluno taluno = new TAluno(desktopPane,caminhologin, codigoAluno,caminhoTabelas);
							desktopPane.add(taluno);
							dispose();
							break;
						case "professor":
							String codigoProf = login.getCodigo();
							TProfessor tprofessor = new TProfessor(desktopPane, caminhologin, codigoProf, caminhoTabelas);
							desktopPane.add(tprofessor);
							dispose();
							break;
						}
					}else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos.");
					}
					
				}
			}
		});
		btnLogar.setBounds(51, 202, 89, 23);
		panel.add(btnLogar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TCadastrar cadastrarView = new TCadastrar(desktopPane, caminho);
				desktopPane.add(cadastrarView);
				dispose();
			}
		});
		btnCadastrar.setBounds(180, 202, 114, 23);
		panel.add(btnCadastrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(96, 123, 210, 45);
		panel.add(panel_1);
		
		JRadioButton rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = "professor";
			}
		});
		panel_1.add(rdbtnProfessor);
		
		JRadioButton rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = "aluno";
			}
		});
		panel_1.add(rdbtnAluno);
		setVisible(true);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnAluno);
		grupo.add(rdbtnProfessor);

	}

}
