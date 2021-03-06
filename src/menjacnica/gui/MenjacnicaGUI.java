package menjacnica.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.bcel.internal.generic.FMUL;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenjacnicaGUI {

	private JFrame frmMenjacnica;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPanel panel;
	private JButton btnDodajKurs;
	private JButton btnObrisiKurs;
	private JScrollPane scrollPaneSouth;
	private JButton btnIzvrsiZamenu;
	private JTextArea txtStatus;
	private JScrollPane scrollPaneCenter;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmObrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;
	private MenjacnicaGUI glavniProzor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI window = new MenjacnicaGUI();
					window.frmMenjacnica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public MenjacnicaGUI() {
		initialize();
		this.glavniProzor=this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmMenjacnica = new JFrame();
		frmMenjacnica.setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/left-btn-selected.png")));
		frmMenjacnica.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				izlaz();
			}
		});
		frmMenjacnica.setTitle("Menjacnica");
		frmMenjacnica.setBounds(100, 100, 600, 450);
		frmMenjacnica.setLocationRelativeTo(null);
		frmMenjacnica.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMenjacnica.setJMenuBar(getMenuBar());
		frmMenjacnica.getContentPane().add(getPanel(), BorderLayout.EAST);
		frmMenjacnica.getContentPane().add(getScrollPaneSouth(), BorderLayout.SOUTH);
		frmMenjacnica.getContentPane().add(getScrollPaneCenter(), BorderLayout.CENTER);
	}

	private void izlaz() {
		int opcija = JOptionPane.showConfirmDialog(null, "Da li zelite da izadjete?", "Izlazak",
				JOptionPane.YES_NO_CANCEL_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("FIle");
			mnFile.setBackground(Color.GRAY);
			mnFile.setSelectedIcon(new ImageIcon(
					MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmNewMenuItem());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private void ucitaj() {
		JFileChooser fc = new JFileChooser();
		int opcija = fc.showOpenDialog(null);
		if (opcija == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			try {
				txtStatus.setText(txtStatus.getText() + "\n" + "Ucitan fajl: " + f);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(panel, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ucitaj();
					
				}
			});
			mntmOpen.setIcon(new ImageIcon(
					MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}

	private void sacuvaj() {
		JFileChooser fc = new JFileChooser();
		int opcija = fc.showSaveDialog(null);
		if (opcija == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			try {
				txtStatus.setText(txtStatus.getText() + "\n" + "Sacuvan fajl: " + f);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(panel, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Save");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				sacuvaj();
				}
			});
			mntmNewMenuItem.setIcon(new ImageIcon(
					MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
			mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmNewMenuItem;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					izlaz();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}
	
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(panel, "Autor:\n Nikola Madic");
				}
			});
		}
		return mntmAbout;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(120, 10));
			panel.setMinimumSize(new Dimension(100, 10));
			panel.setMaximumSize(new Dimension(110, 32767));
			panel.add(getBtnDodajKurs());
			panel.add(getBtnObrisiKurs());
			panel.add(getBtnIzvrsiZamenu());
		}
		return panel;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DodajKursGUI dkg = new DodajKursGUI(glavniProzor);
					dkg.setVisible(true);
				}
			});
			btnDodajKurs.setPreferredSize(new Dimension(115, 23));
		}
		return btnDodajKurs;
	}
	private JButton getBtnObrisiKurs() {
		if (btnObrisiKurs == null) {
			btnObrisiKurs = new JButton("Obrisi kurs");
			btnObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI okg = new ObrisiKursGUI(glavniProzor);
					okg.setVisible(true);
				}
			});
			btnObrisiKurs.setPreferredSize(new Dimension(115, 23));
		}
		return btnObrisiKurs;
	}
	private JScrollPane getScrollPaneSouth() {
		if (scrollPaneSouth == null) {
			scrollPaneSouth = new JScrollPane();
			scrollPaneSouth.setAutoscrolls(true);
			scrollPaneSouth.setViewportBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPaneSouth.setPreferredSize(new Dimension(0, 60));
			scrollPaneSouth.setViewportView(getTxtStatus());
		}
		return scrollPaneSouth;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI izg = new IzvrsiZamenuGUI(glavniProzor);
					izg.setVisible(true);
				}
			});
			btnIzvrsiZamenu.setHorizontalAlignment(SwingConstants.LEFT);
			btnIzvrsiZamenu.setPreferredSize(new Dimension(115, 23));
		}
		return btnIzvrsiZamenu;
	}
	private JTextArea getTxtStatus() {
		if (txtStatus == null) {
			txtStatus = new JTextArea();
		}
		return txtStatus;
	}
	public void ispisiNaKraj(String s) {
		txtStatus.setText(txtStatus.getText()+"\n"+s);
	}
	public void ispisi(String s) {
		txtStatus.setText(s);
		
	}
	private JScrollPane getScrollPaneCenter() {
		if (scrollPaneCenter == null) {
			scrollPaneCenter = new JScrollPane();
			scrollPaneCenter.setViewportView(getTable());
		}
		return scrollPaneCenter;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"\u0160ifra", "Kra\u0107i naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, Double.class, Double.class, Double.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			addPopup(table, getPopupMenu());
		}
		return table;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmObrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKursGUI dkg = new DodajKursGUI(glavniProzor);
					dkg.setVisible(true);	
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmObrisiKurs() {
		if (mntmObrisiKurs == null) {
			mntmObrisiKurs = new JMenuItem("Obrisi kurs");
			mntmObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI okg = new ObrisiKursGUI(glavniProzor);
					okg.setVisible(true);
				}
			});
		}
		return mntmObrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
			mntmIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI izg = new IzvrsiZamenuGUI(glavniProzor);
					izg.setVisible(true);
				}
			});
		}
		return mntmIzvrsiZamenu;
	}

	
}
