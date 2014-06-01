package es.ull.etsii.iaa.proyecto.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Desktop.Action;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JProgressBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import es.ull.etsii.iaa.proyecto.fases.PCorpus;

public class Main {

	private JFrame frmAnalisisEmocional;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnArchivo = new JMenu("Archivo");
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panePrev = new JPanel();
	private final JPanel paneLearn = new JPanel();
	private final JPanel paneClassification = new JPanel();
	private final JButton btnNeg = new JButton("Negativo");
	private final JButton btnPos = new JButton("Positivo");
	private final JTextField textPos = new JTextField();
	private final JTextField textNeg = new JTextField();
	private final JButton btnProcess = new JButton("Procesar corpus");
	private final JProgressBar progressBar = new JProgressBar();
	private final JMenuItem mntmSalir = new JMenuItem("Salir");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmAnalisisEmocional.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAnalisisEmocional = new JFrame();
		frmAnalisisEmocional.setTitle("Analisis Emocional");
		frmAnalisisEmocional.setBounds(100, 100, 450, 300);
		frmAnalisisEmocional.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmAnalisisEmocional.setJMenuBar(this.menuBar);

		this.menuBar.add(this.mnArchivo);
		this.mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAnalisisEmocional.dispose();
			}
		});

		this.mnArchivo.add(this.mntmSalir);
		frmAnalisisEmocional.getContentPane().setLayout(new BorderLayout(0, 0));

		frmAnalisisEmocional.getContentPane().add(this.tabbedPane,
				BorderLayout.CENTER);

		this.tabbedPane.addTab("Previo", null, this.panePrev, null);
		GridBagLayout gbl_panePrev = new GridBagLayout();
		gbl_panePrev.columnWidths = new int[] { 0, 314, 0, 0, 0 };
		gbl_panePrev.rowHeights = new int[] { 55, 55, 0, 0, 0 };
		gbl_panePrev.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panePrev.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		this.panePrev.setLayout(gbl_panePrev);
		this.textPos.setEditable(false);
		this.textPos.setColumns(10);

		GridBagConstraints gbc_textPos = new GridBagConstraints();
		gbc_textPos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPos.insets = new Insets(0, 0, 5, 5);
		gbc_textPos.gridx = 1;
		gbc_textPos.gridy = 0;
		this.panePrev.add(this.textPos, gbc_textPos);

		GridBagConstraints gbc_btnPos = new GridBagConstraints();
		gbc_btnPos.insets = new Insets(0, 0, 5, 5);
		gbc_btnPos.gridx = 2;
		gbc_btnPos.gridy = 0;
		this.btnPos
				.setToolTipText("Selecciona el directorio con el corpus positivo");
		this.btnPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JFileChooser chooser = new JFileChooser();
				try {
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("Corpus positivo");
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					chooser.setAcceptAllFileFilterUsed(false);
					if (chooser.showOpenDialog(btnPos) == JFileChooser.APPROVE_OPTION) {
						textPos.setText(chooser.getSelectedFile().toString());
					}

				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		this.panePrev.add(this.btnPos, gbc_btnPos);
		this.textNeg.setEditable(false);
		this.textNeg.setColumns(10);

		GridBagConstraints gbc_textNeg = new GridBagConstraints();
		gbc_textNeg.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNeg.insets = new Insets(0, 0, 5, 5);
		gbc_textNeg.gridx = 1;
		gbc_textNeg.gridy = 1;
		this.panePrev.add(this.textNeg, gbc_textNeg);

		GridBagConstraints gbc_btnNeg = new GridBagConstraints();
		gbc_btnNeg.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeg.gridx = 2;
		gbc_btnNeg.gridy = 1;
		this.btnNeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				try {
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("Corpus negativo");
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					chooser.setAcceptAllFileFilterUsed(false);
					if (chooser.showOpenDialog(btnPos) == JFileChooser.APPROVE_OPTION) {
						textNeg.setText(chooser.getSelectedFile().toString());
					}

				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		this.btnNeg
				.setToolTipText("Selecciona el directorio con el corpus negativo");
		this.panePrev.add(this.btnNeg, gbc_btnNeg);

		GridBagConstraints gbc_btnProcess = new GridBagConstraints();
		gbc_btnProcess.gridwidth = 2;
		gbc_btnProcess.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnProcess.insets = new Insets(0, 0, 5, 5);
		gbc_btnProcess.gridx = 1;
		gbc_btnProcess.gridy = 2;
		this.btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PCorpus corpus = new PCorpus();
				corpus.searchFolder(textPos.getText());
				corpus.searchFolder(textNeg.getText());
			}
		});
		this.panePrev.add(this.btnProcess, gbc_btnProcess);

		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridwidth = 2;
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 3;
		this.panePrev.add(this.progressBar, gbc_progressBar);

		this.tabbedPane.addTab("Aprendizaje", null, this.paneLearn, null);
		this.paneLearn.setLayout(new GridLayout(1, 0, 0, 0));

		this.tabbedPane.addTab("Clasificación", null, this.paneClassification,
				null);
		this.paneClassification.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
