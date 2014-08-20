package SwingTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeCellEditor;

import SwingTest.IliaListeners;
import SwingTest.IliaListeners.iliaButtonAction;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.*;

import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
/**
 * @author ilia
 *
 */
public class IliaFrame extends JFrame {

	public static class DrawPanel extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		 int startX;
		 int startY;
		 int endX;
		 int endY;
		 
		public DrawPanel()
		{
			final TitledBorder border = BorderFactory.createTitledBorder("Draw Panel"); 
			setBorder(border);
			addMouseListener(new MouseListener(){

				 
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					startX = arg0.getX();
					startY = arg0.getY();
					border.setTitle("Start Point Is : "+ startX + ":" + startY);
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					endX = arg0.getX();
					endY = arg0.getY();
					border.setTitle("Square Is : "+ startX + ":" + startY + " to " + endX + ":" + endY);
					repaint();
				}

			});
		}
	    
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);       
	        g.setColor(Color.RED);
	        g.fillRect(startX, startY, endX-startX, endY-startY);  
	        g.setColor(Color.GREEN);
	        g.drawRect(startX, startY, endX-startX, endY-startY);
	    }  
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6830947047016638288L;

	public IliaFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public IliaFrame(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public IliaFrame(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public IliaFrame(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	private class IliaActionEvent extends ActionEvent
	{

		public IliaActionEvent(Object arg0, int arg1, String arg2) {
			super(arg0, arg1, arg2);
			// TODO Auto-generated constructor stub
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}
	
	public static class Echo extends DefaultHandler2 {
		BufferedWriter out;
		static int numOfTabs = 0;
        public Echo () {
            try {
            	out = new BufferedWriter(new FileWriter("c:/Documents and Settings/ilia/Desktop/Test.xml"));  
            } catch (IOException e) {
                System.out.println("IOException:");
                e.printStackTrace();
            }      	
        }
        
        
        public void startElement(	String namespaceURI,
        							String sName, // simple name
        							String qName, // qualified name
        							Attributes attrs) throws SAXException
        {
        	try {
        		
	        	String eName = sName; 	// element name
	        	for (int i= 0; i<numOfTabs; i++)
					out.write("\t");
	        	if ("".equals(eName)) 
	        		eName = qName; 		// not namespace-aware
				out.write("<"+eName);
	        	if (attrs != null) {
	        		for (int i = 0; i < attrs.getLength(); i++) {
	        			String aName = attrs.getLocalName(i); // Attr name
	        			if ("".equals(aName)) aName = attrs.getQName(i);
	        			out.write(" ");
	        			out.write(aName+"=\""+attrs.getValue(i)+"\"");
	        		}
	        	}
	        	out.write(">");
	        	out.write("\n");
	        	out.flush();
	        	numOfTabs++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        public void endElement(	String namespaceURI,
        						String sName, // simple name
        						String qName // qualified name
        						) throws SAXException
        {
	       	try {
	        	numOfTabs--;
	        	for (int i= 0; i<numOfTabs; i++)
					out.write("\t");
	        	String eName = sName; // element name
	        	if ("".equals(eName)) eName = qName; // not namespace-aware
	        		out.write("</"+eName+">");
		        out.write("\n");
		        out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	}
        
		public void characters (char buf [], int offset, int len) throws SAXException
		{
			try {
				String s = new String(buf, offset, len);
				System.out.println(s);
//				out.write(buf);
//				out.write(offset);
//				out.write(len);
//	        	out.flush();
			}catch (Exception e) {
                System.out.println("IOException:");
                e.printStackTrace();
            }      	
		}
		public void processingInstruction (String target, String data) throws SAXException
		{
//			try {
//				out.write(target);
//				out.write(data);
//			}catch (IOException e) {
//                System.out.println("IOException:");
//                e.printStackTrace();
//            }      	
		}
	}
	
	public static void testXML (String sFileName) {
		try {
			DefaultHandler2 handler = new Echo();
			SAXParser xmlParser = SAXParserFactory.newInstance().newSAXParser();
			xmlParser.parse(sFileName,handler);
		} catch (Exception e) {}
	}
	
	private static void createMenu (JFrame parentFrame)
	{
		JMenu menu1 = new JMenu("Menu 1");
		JMenu menu2 = new JMenu("Menu 2");
		JMenuBar menuBar = new JMenuBar();
		JMenuItem menuItem11 = new JMenuItem("menuItem11");
		JMenuItem menuItem12 = new JMenuItem("menuItem12");
		JMenuItem menuItem21 = new JMenuItem("menuItem21");
		JMenuItem menuItem22 = new JMenuItem("menuItem22");
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menu1.add(menuItem11);
		menu1.add(menuItem12);
		menu2.add(menuItem21);
		menu2.add(menuItem22);
		

		menuItem11.setAction(IliaListeners.getAction1("From menuItem11"));
		menuItem12.setAction(IliaListeners.getAction1("From menuItem12"));
		menuItem21.setAction(IliaListeners.getAction2("From menuItem21"));
		menuItem22.setAction(IliaListeners.getAction2("From menuItem22"));
		
		parentFrame.setJMenuBar(menuBar);
	}
	
	public static class MyFileFilter extends FileFilter 
	{
		String[] extensions;
		private MyFileFilter() {};
		public MyFileFilter(String[] extensions)
		{
			this.extensions = extensions;
		}
		
	    public String getExtension(File f) {
	        String ext = null;
	        String s = f.getName();
	        int i = s.lastIndexOf('.');

	        if (i > 0 &&  i < s.length() - 1) {
	            ext = s.substring(i+1).toLowerCase();
	        }
	        return ext;
	    }

		@Override
		public boolean accept(File f) {
			if (f.isDirectory()) {
				return true;
			}
			for(int i = 0; i < extensions.length; i++)
				if (getExtension(f).equals(extensions[i])) {
					return true;
				}
			return false;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public static void CreateAndShowGui ()
	{
		// TODO Auto-generated method stub
		IliaFrame iliaFrame = new IliaFrame("Ilia Frame");
		iliaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel iliaPanel = new JPanel();
		iliaFrame.add(iliaPanel);
		
		iliaPanel.setLayout(new GridBagLayout());
		
		createMenu(iliaFrame);
		
		// Labels
		JLabel l1 = new JLabel("Label 1");
		l1.setToolTipText("Label 1");
		JLabel l2 = new JLabel("Label 2");
		l2.setToolTipText("Label 2");
		JLabel l3 = new JLabel("Label 3");
		l3.setToolTipText("Label 3");
		DrawPanel drawPanel = new DrawPanel();
		
		// Text Fields 
		JTextField tf1 		= new JTextField();
		JPasswordField tpf1 = new JPasswordField();		

		Dimension d = new Dimension(100,50);
		tf1.setPreferredSize(d);
		tpf1.setPreferredSize(d);
		tf1.setBorder(BorderFactory.createTitledBorder("JTextField"));
		tpf1.setBorder(BorderFactory.createTitledBorder("JPasswordField"));
		
		Document tfModel = new PlainDocument();
		try {
			tfModel.insertString(0, "Ilia Bilia", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tf1.setDocument(tfModel);
		tpf1.setDocument(tfModel);
		
		// JTable
		JTable jt = new JTable();
		JScrollPane jsp = new JScrollPane(jt);
		jt.setFillsViewportHeight(true);
		jsp.setBorder(BorderFactory.createTitledBorder("JTable"));
		
		DefaultTableModel jtModel = new DefaultTableModel();
		DefaultTableModel jtRowHeadersModel = new DefaultTableModel();
		
		jtModel.addColumn("column1");
		jtModel.addColumn("column2");
		jtModel.addColumn("column3");

		Random r = new Random();
		Vector<String> rowName = new Vector<String>();
		for (int i = 0; i < 100; i++)
		{
			jtModel.addRow( new Object[]{r.nextDouble(),r.nextDouble(),r.nextDouble()});
			rowName.add("Row "+(i+1) );
		}
		
		jt.setModel(jtModel);
		jtRowHeadersModel.addColumn("Rows", rowName);
        JTable rowHeader = new JTable(jtRowHeadersModel);

		jsp.setRowHeaderView(rowHeader);
		
		//Listeners Panel
		IliaListeners listenersPanel = new IliaListeners();
		
		//Splitted Pane
		JButton jb = new JButton("Open Splitted Pane");
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JDialog jd = new JDialog();
				jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				jd.setPreferredSize(new Dimension(500,400));
				jd.show();
				
				DefaultMutableTreeNode jmtn1 = new DefaultMutableTreeNode("Root");
				jmtn1.add(new DefaultMutableTreeNode("Root - 1"));
				jmtn1.add(new DefaultMutableTreeNode("Root - 2"));
				DefaultMutableTreeNode jmtn4 = new DefaultMutableTreeNode("Root - 3");
				jmtn1.add(jmtn4);
				jmtn4.add(new DefaultMutableTreeNode("jmtn4 - 1"));
				jmtn4.add(new DefaultMutableTreeNode("jmtn4 - 2"));

				DefaultTreeSelectionModel dtsm = new DefaultTreeSelectionModel();
				DefaultTreeModel dtm = new DefaultTreeModel(jmtn1);

				final JTree jTree = new JTree();
				jTree.setModel(dtm);
				jTree.setSelectionModel(dtsm);
				
			    String elements[] = { "A", "B", "C", "D"} ;
			    JComboBox comboBox = new JComboBox(elements);
			    comboBox.setEditable(true);
			    TreeCellEditor comboEditor = new DefaultCellEditor(comboBox);
			    TreeCellEditor editor = new DefaultTreeCellEditor(jTree, null, comboEditor);
			    
				jTree.setCellEditor(editor);
				jTree.setEditable(true);
			    jTree.setRootVisible(true);
				
				final JTextArea sjta = new JTextArea(); 
				
				dtsm.addTreeSelectionListener(new TreeSelectionListener() {

					@Override
					public void valueChanged(TreeSelectionEvent arg0) {
						// TODO Auto-generated method stub
						sjta.append("Selected : "+((DefaultMutableTreeNode)jTree.getLastSelectedPathComponent()).isLeaf()+"\n");
					}
					
				});
				
				// Swing Worker Test
				JPanel jpWorker = new JPanel();
				final JButton bWorker = new JButton("start");
				final JTextArea taWorker = new JTextArea();
				jpWorker.setLayout(new BorderLayout());
				jpWorker.add(bWorker,BorderLayout.NORTH);
				jpWorker.add(taWorker,BorderLayout.SOUTH);
				bWorker.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						bWorker.setEnabled(false);
						taWorker.append("Sleep 5 Seconds ... ");
						
						SwingWorker worker = new SwingWorker<Integer, Void>() {
							@Override
							protected Integer doInBackground() throws Exception {
								Thread.sleep(5000);
								Random r = new Random();
								return new Integer(r.nextInt());
							}
							protected void done() {
								bWorker.setEnabled(true);
								try {
									taWorker.append("recieved Integer : "+get().intValue()+ " done !\n");
								} catch (Exception e) {}
							}
						};
						worker.execute();
					}					
				});
				
				JTabbedPane jtp1 = new JTabbedPane();
				jtp1.addTab("tab1", new JPanel());
				jtp1.addTab("tab2", new JLabel("KUKU"));
				jtp1.addTab("tab3", sjta);
				JTabbedPane jtp2 = new JTabbedPane();
				jtp2.addTab("tab21", jTree);
				jtp2.addTab("tab22", jpWorker);
				JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,	jtp1, jtp2);
				jSplitPane.setPreferredSize(new Dimension(500,400));
				jSplitPane.setDividerLocation(150);
				

				jSplitPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				
				jd.getContentPane().add(jSplitPane);
			}			
		});
		
		// XML File Chooser
		final JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setDialogTitle("Please Choose the XML file to Parse");
		jfc.setMultiSelectionEnabled(false);
		jfc.setCurrentDirectory(new File("c:/Documents and Settings/ilia/Desktop")); 
		jfc.addChoosableFileFilter(new MyFileFilter(new String[]{"xml","doc",""})); 

		JButton jfcb = new JButton("Open XML File...");
		jfcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = jfc.showOpenDialog(jfc);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	            	testXML (jfc.getSelectedFile().getAbsolutePath());
	            }
			}
		});
		
		// Layout
		iliaPanel.add(l1, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(l2, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(l3, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(drawPanel, new GridBagConstraints(0, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(tf1, new GridBagConstraints(0, 2, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(tpf1, new GridBagConstraints(0, 3, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(jsp, new GridBagConstraints(0, 4, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(listenersPanel, new GridBagConstraints(0, 5, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(jb, new GridBagConstraints(0, 6, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0) );
		iliaPanel.add(jfcb, new GridBagConstraints(0, 7, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0) );
		
		iliaFrame.pack();
		iliaFrame.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				CreateAndShowGui ();
			}
			
		});
	}
}
