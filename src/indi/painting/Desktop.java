package indi.painting;
/**
 * @author llh
 * @date 2022/11/17
 */

import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import indi.homework5.*;
import java.awt.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Desktop {

    private static final String PATHNAME = "./team.dat";
	private static TeamFormatter teamFormatter;


    public Desktop() {

    }
    
    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        Container container = f.getContentPane();
        JButton b_read = new JButton();
        JButton b_text = new JButton();
        JButton b_HTML = new JButton();
        JButton b_XML = new JButton();
        String[] teams = {"Team001", "Team002", "Team003"};
        JComboBox<String> cmb=new JComboBox<>(teams);
        JTextArea text = new JTextArea();
        //简易版数据库，用于存储初始化所读取的队伍信息，存放到dataload中
        JTextArea dataload = new JTextArea("");
        JScrollPane scroll = new JScrollPane(text);
        frame(f);
        combobox(cmb);
        readButton(b_read);
        b_read.addActionListener(new ActionListener() {
            //读取dat文件数据并初始化，将字符串转化为对象
                public void actionPerformed(ActionEvent e){
                    dataload.setText(loadTeam());
                    text.setText("初始化队伍信息完成");
                }
            });
        formatterButton(b_text,10, 130, "Display team (Plain Text)");
        b_text.addActionListener(new ActionListener() {
            //添加监听，选择不同格式打印
            public void actionPerformed(ActionEvent e){
                setTeamFormatter(PlainTextTeamFormatter.getSingletonInstance());
                text.setText(displayTeam(cmb.getSelectedItem().toString(),deserialize(dataload.getText())));
            }
        });
        formatterButton(b_HTML,530, 130, "Display team (HTML)");
        b_HTML.addActionListener(new ActionListener() {
            //添加监听，选择不同格式打印
            public void actionPerformed(ActionEvent e){
                setTeamFormatter(HTMLTeamFormatter.getSingletonInstance());
                text.setText(displayTeam(cmb.getSelectedItem().toString(),deserialize(dataload.getText())));
            }
        });
        formatterButton(b_XML,1050, 130, "Display team (XML)");
        b_XML.addActionListener(new ActionListener() {
            //添加监听，选择不同格式打印
            public void actionPerformed(ActionEvent e){
                setTeamFormatter(XMLTeamFormatter.getSingletonInstance());
                text.setText(displayTeam(cmb.getSelectedItem().toString(),deserialize(dataload.getText())));
            }
        });
        teamText(text);
        setScroll(scroll);
        container.add(cmb);
        container.add(b_read);
        container.add(b_text);
        container.add(b_HTML);
        container.add(b_XML);
        container.add(scroll);
    }

    private static void frame(JFrame f) {

        f.setSize(1650,1080);   
        f.setResizable(false);   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        //开启JFrame的绝对定位，避免textarea的错位
        f.setLayout(null);
        f.setVisible(true);
    }

    private static void combobox(JComboBox<String> cmb) {

        cmb.setSize(500,100);
        cmb.setLocation(1050,10);
    }

    private static void readButton(JButton b) {

        b.setSize(200, 50);
        b.setBackground(new Color(0x409EFF));
        b.setLocation(10, 10);
        b.setText("读取文件");
        Font f = new Font("宋体",Font.BOLD,36);
        b.setFont(f);
        b.setVisible(true);
    }

    private static void formatterButton(JButton b, int x, int y, String text) {

        b.setSize(500,120);
        b.setBackground(new Color(0xffffff));
        b.setLocation(x, y);
        b.setText(text);
        Font f = new Font("宋体",Font.BOLD,36);
        b.setFont(f);
        b.setVisible(true);
    }

    private static void teamText(JTextArea t) {

        Font f = new Font("宋体",Font.BOLD,28);
        t.setFont(f);
        t.setLineWrap(true);
        t.setEditable(false);
    }

    private static void setScroll(JScrollPane sc) {

        sc.setBounds(75,400,1500, 600);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    private static void setTeamFormatter(TeamFormatter formatter) {

		teamFormatter = formatter;
	}

    /**
     * @return content.toString dat文件的字符串形式
     */
	private static String loadTeam() {

		StringBuffer content = new StringBuffer();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(PATHNAME),"UTF-8"));
			String line = null;
			while((line = br.readLine()) != null) {
				content.append(line)
					   .append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return content.toString();
	}

    /**
     * @param id,combobox的内容,用于选择显示特定id的队伍信息
     * @return s.toString 队伍信息的字符串
     */
	private static String displayTeam(String id, ArrayList<Team> teamList) {
        
        if(teamList == null) {
            return "请先初始化队伍信息";
        }
        else {
            StringBuilder s = new StringBuilder();
            for(Team team : teamList) {
                if(id.equals(team.getTeamId())) {
                    s.append(teamFormatter.formatTeam(team));
                }
            }
            return s.toString();
        }
	}

	/**
	 * 将dat文件读入的字符串反序列化为teamList
	 * @param str dat文件读入的字符串
	 * @return teamList 队伍信息的ArrayList
	 */
	private static ArrayList<Team> deserialize(String str) {

		ArrayList<Team> teamList = new ArrayList<>();
		ArrayList<Student> studentList = new ArrayList<>();
		ArrayList<Teacher> teacherList = new ArrayList<>();

		try {
            if(str.equals("")) {

                return null;
            }
			String[] lines = str.split("\n");
			for(String line : lines) {
				//跳过dat中的空行
				if(line.length() == 0){
					continue;
				}
				Teacher teacher = null;
				Student student = null;
				Student creator = null;
				String[] content = line.split("_");
				for(int i = 0; i < content.length; i++) {
					if(content[i].equals("Teacher")) {
						teacher = new Teacher(
							content[i+1], 
							content[i+2], 
							content[i+3], 
							content[i+4], 
							content[i+5], 
							content[i+6]);
						teacherList.add(teacher);
					}
					else if(content[i].equals("Student")) {
						student = new Student(
							content[i+1], 
							content[i+2], 
							content[i+3], 
							content[i+4], 
							content[i+5], 
							(content[i+6].equals("女")) ? true : false, 
							content[i+7], 
							content[i+8]);
						studentList.add(student);
					}
					else if(content[i].equals("Creator")) {
						creator = new Student(
							content[i+1], 
							content[i+2], 
							content[i+3], 
							content[i+4], 
							content[i+5], 
							(content[i+6].equals("女")) ? true : false, 
							content[i+7], 
							content[i+8]);
					}
				}
				Team team = new Team(
					content[1], 
					content[2], 
					content[3], 
					creator);
				for(Student person : studentList) {
					team.addStudent(person);
				}
				for(Teacher person : teacherList) {
					team.addTeacher(person);
				}
				teamList.add(team);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return teamList;
	}
}






