package SwingTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class IliaListeners extends JPanel {

	private static final long serialVersionUID = 1L;
	static JTextArea jta1 = new JTextArea();
	static JTextArea jta2 = new JTextArea();

	JPanel  jp = new JPanel();
	JButton jb1 = new JButton("Button 1");
	JButton jb2 = new JButton("Button 2");

	public static class iliaButtonAction extends AbstractAction {
		private JTextArea p_jta;
		private String p_text;
		private iliaButtonAction(){};
		public iliaButtonAction(JTextArea jta)
		{
			p_jta = jta;
		}
		public iliaButtonAction(JTextArea jta, String text)
		{
			p_jta = jta;
			p_text = text;
			putValue(AbstractAction.NAME,text);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			p_jta.append(p_text+"\n");
		}
		
	}
	
	public static AbstractAction getAction1(String p_text)
	{
		return new iliaButtonAction(jta1, p_text);
	}
	public static AbstractAction getAction2(String p_text)
	{
		return new iliaButtonAction(jta2, p_text);
	}
	
	public IliaListeners() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("This Panel is In EDT :"+SwingUtilities.isEventDispatchThread()));
		
		jta1.setBorder(BorderFactory.createTitledBorder("JTA1"));
		jta2.setBorder(BorderFactory.createTitledBorder("JTA2"));
		jta1.setPreferredSize(new Dimension(450, 200));
		jta2.setPreferredSize(new Dimension(450, 200));
				
		jb1.setAction(getAction1("From Button 1"));
		jb2.setAction(getAction2("From Button 2"));
				
		jb1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jb2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		this.add(jta1,BorderLayout.EAST);
		this.add(jta2,BorderLayout.WEST);
		this.add(jp,BorderLayout.SOUTH);
		jp.add(jb1,BorderLayout.EAST);
		jp.add(jb2,BorderLayout.WEST);
	}
}
