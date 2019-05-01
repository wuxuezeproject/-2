package cn.window.java;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

public class face_1 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox checkbox[];
	private JComboBox<Integer> comb_num,comb_max;
	private int num=1;
	private int max=10;
	private int style =0;
	private int iss=0;
	private JButton bcreat,bput;
	private JButton[] submit = new JButton[20];
	private JTextField[] timu=new JTextField[20],ans1=new JTextField[20],ans2=new JTextField[20],ans3=new JTextField[20];
	private test[] t=new test[20];
	
	public face_1()
	{
		super("����������");
		this.setSize(900,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JToolBar toolbar = new JToolBar();
		this.getContentPane().add(toolbar, "North");
		String str[][]={{"��Ŀ���� ��"},{"+","-","*","/","()","С��"},{" ���ֵ��"}};
		toolbar.add(new JLabel("   "));
		toolbar.add(new JLabel(str[0][0]));
		Integer num1[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		this.comb_num=new JComboBox<Integer>(num1);
		this.comb_num.addActionListener(this);
		toolbar.add(this.comb_num);
		toolbar.add(new JLabel("      ѡ����������������ͣ�"));
		this.checkbox=new JCheckBox[str[1].length];
		for (int i=0;i<str[1].length;i++)
		{
			this.checkbox[i]=new JCheckBox(str[1][i]);
			toolbar.add(this.checkbox[i]);
			this.checkbox[i].addActionListener(this);
		}
		toolbar.add(new JLabel("       "));
		toolbar.add(new JLabel(str[2][0]));
		Integer max1[]={10,50,100,1000,10000};
		this.comb_max=new JComboBox<Integer>(max1);
		this.comb_max.addActionListener(this);
		toolbar.add(this.comb_max);
		toolbar.add(new JLabel("     "));
		this.bcreat=new JButton("      ����        ");
		this.bcreat.addActionListener(this);
		toolbar.add(bcreat);
		toolbar.add(new JLabel("     "));
		this.bput=new JButton("      ��ӡ        ");
		this.bput.addActionListener(this);
		toolbar.add(bput);
		toolbar.add(new JLabel("     "));
		JPanel equ=new JPanel();
		this.getContentPane().add(equ, "Center");		
		equ.setLayout(new GridLayout(21, 7, 5, 5));
		equ.add(new JLabel("                ���") );
		equ.add(new JLabel("                ��Ŀ") );
		equ.add(new JLabel("           �ҵĴ�") );
		equ.add(new JLabel("                �ύ") );
		equ.add(new JLabel("                ���") );
		equ.add(new JLabel("          ��ȷ��") );
		String no[]={"                1","                2","                3","                4","                5","                6","                7","                8","                9","                10","                11","                12","                13","                14","                15","                16","                17","                18","                19","                20"};
		for (int i=0;i<20;i++)
		{			
			equ.add(new JLabel (no[i]));
			this.timu[i]=new JTextField ("��Ŀ�������");
			equ.add(this.timu[i]);
			this.ans1[i]=new JTextField ();
			this.ans1[i].addActionListener(this);
			equ.add(this.ans1[i]);
			this.submit[i]=new JButton("�ύ");
			this.submit[i].addActionListener(this);
			equ.add(this.submit[i]);
			this.ans2[i]=new JTextField ("�Բ����ύһ�²�֪��");
			this.ans2[i].addActionListener(this);
			equ.add(this.ans2[i]);
			this.ans3[i]=new JTextField ("��ȷ�𰸿������");
			this.ans3[i].addActionListener(this);
			equ.add(this.ans3[i]);
		}

		this.setVisible(true);
		
	}
	
	private void submit(int n)
	{
		if (n>=num) 
		{
			JOptionPane.showMessageDialog(this, "�˴�û����ĿŶ�������ύ��");
			return;
		}
		String str=this.ans1[n].getText();
		if (str.equals(""))
		{
			JOptionPane.showMessageDialog(this, "��д�𰸻��������ύ��");
			return;
		}
		String s=t[n].daan;
		if (str.equals(s)) //
		{
			this.ans2[n].setCaretColor(Color.blue);
			this.ans2[n].setText("��ȷ");
		}
		else 
		{
			this.ans2[n].setCaretColor(Color.red);
			this.ans2[n].setText("����");
		}
		this.ans3[n].setText(t[n].daan);
		this.ans3[n].setCaretColor(Color.darkGray);
		
	}
	
	public void bcreatsx()
	{
		if (style==0) 
		{
			JOptionPane.showMessageDialog(this, "��û��ѡ�����Ŷ���������ɣ�");
			return;
		}
		if (style==16||style==32) 
		{
			if (style==16)JOptionPane.showMessageDialog(this, "С���ѣ�ֻ�������ǲ��еΣ�");
			if (style==32)JOptionPane.showMessageDialog(this, "С���ѣ�ֻ��С���ǲ��еΣ�");
			return;
		}
		JOptionPane.showMessageDialog(this, "ԭ����Ŀ��û����Ŷ��");
		for (int i=0;i<num;i++)
		{
			this.ans1[i].setText("");
			this.ans2[i].setText("�Բ����ύһ�²�֪��");
			this.ans3[i].setText("��ȷ�𰸿������");
			t[i]=new test(max,style);//
			t[i].creat();
			this.timu[i].setText(t[i].ti);
		}
		iss++;
	}
	
    public  void charOutStream() throws Exception{
        // 1������File���ҵ�Ҫ�����Ķ���
            File file = new File("D:" + File.separator + "JAVA" + File.separator + "test.txt");
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            Writer out = new FileWriter(file);
            for (int i=0;i<num;i++)
            {
            	out.write("��Ŀ��");
            	out.write(t[i].ti);
            	out.write("         ��ȷ�𰸣�");
            	out.write(t[i].daan);
            	out.write("         �ҵĴ𰸣�");
            	out.write(this.ans1[i].getText());
            	out.write("\r\n");
            }
            out.close();
            JOptionPane.showMessageDialog(this, "�Ѿ���ӡ�ɹ��ˣ���D:JAVA:test.txt�С�");
        }
	
	
	public void actionPerformed(ActionEvent ev)
	{
		if (ev.getSource()==this.bcreat)
		{
			bcreatsx();//
		}
		if (ev.getSource()==this.bput)
		{
			if (iss==0) 
				{
				JOptionPane.showMessageDialog(this, "��û����ĿŶ�����ܴ�ӡ��");
				return ;
				}
			try {
				charOutStream();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//dayin
		}
		if (ev.getSource()instanceof JComboBox<?>||ev.getSource()instanceof JCheckBox||ev.getSource()instanceof JMenuItem)
		{
			Object obj1=this.comb_num.getSelectedItem();
			num=((Integer)obj1).intValue();
			Object obj2=this.comb_max.getSelectedItem();
			max=((Integer)obj2).intValue();
			if (ev.getActionCommand().equals("+")) style=style^1; 
			if (ev.getActionCommand().equals("-")) style=style^2; 
			if (ev.getActionCommand().equals("*")) style=style^4; 
			if (ev.getActionCommand().equals("/")) style=style^8; 
			if (ev.getActionCommand().equals("()")) style=style^16; 
			if (ev.getActionCommand().equals("С��")) style=style^32;
		}
		
		if (ev.getSource()==submit[0]) submit(0); 
		else if (ev.getSource()==submit[1]) submit(1); //
		else if (ev.getSource()==submit[2]) submit(2); 
		else if (ev.getSource()==submit[3]) submit(3); 
		else if (ev.getSource()==submit[4]) submit(4); 
		else if (ev.getSource()==submit[5]) submit(5); 
		else if (ev.getSource()==submit[6]) submit(6); 
		else if (ev.getSource()==submit[7]) submit(7); 
		else if (ev.getSource()==submit[8]) submit(8); 
		else if (ev.getSource()==submit[9]) submit(9); 
		else if (ev.getSource()==submit[10]) submit(10); 
		else if (ev.getSource()==submit[11]) submit(11); 
		else if (ev.getSource()==submit[12]) submit(12); 
		else if (ev.getSource()==submit[13]) submit(13); 
		else if (ev.getSource()==submit[14]) submit(14); 
		else if (ev.getSource()==submit[15]) submit(15); 
		else if (ev.getSource()==submit[16]) submit(16); 
		else if (ev.getSource()==submit[17]) submit(17); 
		else if (ev.getSource()==submit[18]) submit(18); 
		else if (ev.getSource()==submit[19]) submit(19); 
		
	}

	public static void main(String args[])
	{
		new face_1();
	}
}


