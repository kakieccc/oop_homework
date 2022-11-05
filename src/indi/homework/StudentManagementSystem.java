package indi.homework;

import java.util.*;
import java.text.SimpleDateFormat;
import indi.homework.student.*;
import indi.homework.Serializer.*;
import indi.homework.comparator.*;


public class StudentManagementSystem {

    public static final String pathnameTXT = "./us.txt";
    public static final String pathnameJSON = "./gs.json";
    public static final String pathnameXML = "./ds.xml";
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    static ArrayList<UndergraduateStudent> undergraduateStudentList = new ArrayList<>();
    static ArrayList<GraduateStudent> graduateStudentList = new ArrayList<>();
    static ArrayList<DoctoralStudent> doctoralStudentList = new ArrayList<>();

    public StudentManagementSystem() {

        undergraduateStudentList = new ArrayList<UndergraduateStudent>();
        graduateStudentList = new ArrayList<GraduateStudent>();
        doctoralStudentList = new ArrayList<DoctoralStudent>();
    }
    public static void main(String[] args) {

        initialize();
        while(true) {
            menu();
            options();
        }
    }

    public static void initialize() {

        readTXT();
        readJSON();
        readXML();
    }

    public static void readTXT() {

        try {
            String str = FileManager.read(pathnameTXT, "utf-8");
            undergraduateStudentList = UndergraduateStudentSerializer.deserialize(str);
        } catch (Exception e) {
            System.err.println("读取文件出错");
            System.exit(0);
        }
        
    }

    public static void readJSON() {

        try {
            String str = FileManager.read(pathnameJSON, "utf-8");
            graduateStudentList = GraduateStudentSerializer.deserialize(str);
        } catch (Exception e) {
            System.err.println("读取文件出错");
            System.exit(0);
        }
    }

    public static void readXML() {

        try {
            String str = FileManager.read(pathnameXML, "utf-8");
            doctoralStudentList = DoctoralStudentSerializer.deserialize(str);
        } catch (Exception e) {
            System.err.println("读取文件出错");
            System.exit(0);
        }
    }

    public static void menu() {

        System.out.println
        ( "请输入你的选择\n"
        + "[1]打印全部学生信息\n"
        + "[2]新增一个本科生\n"
        + "[3]新增一个研究生\n"
        + "[4]新增一个博士生\n"
        + "[5]按学号查找学生\n"
        + "[6]按姓名查找学生\n"
        + "[7]学生排序\n"
        + "[0]退出");
    }

    public static void options() {
        
        try {
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    printStudents();break;
                case 2:
                    addUndergraduateStudent();break;
                case 3:
                    addGraduateStudent();break;
                case 4:
                    addDoctoralStudent();break;
                case 5:
                    searchByNum();break;
                case 6:
                    searchByName();break;
                case 7:
                    sortStudent();break;
                case 0:
                    exit();break;
                default:
                    System.out.println("输入不合法，请重新输入");
            }
        } catch (Exception e) {
            System.err.println("输入不合法，请重新输入");
        }
    }

    public static void printStudents() {

        System.out.println("本科生:");
        printTXT();
        System.out.println("研究生:");
        printJSON();
        System.out.println("博士生:");
        printXML();
    }

    public static void printTXT() {

        for(UndergraduateStudent student : undergraduateStudentList) {

            System.out.println(student);
        }
    }

    public static void printJSON() {
        
        for(GraduateStudent student : graduateStudentList) {

            System.out.println(student);
        }
    }

    public static void printXML() {

        for(DoctoralStudent student : doctoralStudentList) {

            System.out.println(student);
        }
    }

    public static void addUndergraduateStudent() {

        System.out.println("请按studentNumber_studentName_gender_birthday_academy_major_tutor的格式输入学生信息");
        try {
            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine(); 
            String[] info = str.split("_");
            String gender = info[2];
            Date date = dateFormat.parse(info[3]);
            UndergraduateStudent undergraduatestudent = new UndergraduateStudent(info[0],info[1],gender,date,info[4],info[5],info[6]);
            undergraduateStudentList.add(undergraduatestudent);

            String stu = UndergraduateStudentSerializer.serializer(undergraduateStudentList);
            FileManager.write(stu, pathnameTXT, "utf-8");
            System.out.println("录入信息成功");
        } catch (Exception e) {
            System.err.println("录入信息出错，请重试");
        }
    }

    public static void addGraduateStudent() {

        System.out.println("请按studentNumber_studentName_gender_birthday_academy_major_supervisor的格式输入学生信息");
        try {
            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine(); 
            String[] info = str.split("_");
            String gender = info[2];
            Date date = dateFormat.parse(info[3]);
            GraduateStudent graduateStudent = new GraduateStudent(info[0],info[1],gender,date,info[4],info[5],info[6]);
            graduateStudentList.add(graduateStudent);

            String stu = GraduateStudentSerializer.serializer(graduateStudentList);
            FileManager.write(stu, pathnameJSON, "utf-8");
            System.out.println("录入信息成功");
        } catch (Exception e) {
            System.err.println("录入信息出错，请重试");
        }
    }

    public static void addDoctoralStudent() {

        System.out.println("请按studentNumber_studentName_gender_birthday_academy_major_supervisor_researchFields的格式输入学生信息");
        try {
            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine(); 
            String[] info = str.split("_");
            String gender = info[2];
            Date date = dateFormat.parse(info[3]);
            DoctoralStudent doctoralStudent = new DoctoralStudent(info[0],info[1],gender,date,info[4],info[5],info[6],info[7]);
            doctoralStudentList.add(doctoralStudent);
            System.out.println("录入信息成功");
        } catch (Exception e) {
            System.err.println("录入信息出错，请重试");
        }
    }

    public static void searchByNum() {

        System.out.println("请输入要查找的学生学号");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        for (UndergraduateStudent us : undergraduateStudentList) {
            if (us.getStudentNumber().equals(id)) {
                System.out.println(us);
                break;
            }
        }
        for (GraduateStudent gs : graduateStudentList) {
            if (gs.getStudentNumber().equals(id)) {
                System.out.println(gs);
                break;
            }
        }
        for (DoctoralStudent ds : doctoralStudentList) {
            if (ds.getStudentNumber().equals(id)) {
                System.out.println(ds);
                break;
            }
        }
        System.out.println("找不到该学号的学生");
    }

    public static void searchByName() {

        System.out.println("请输入要查找的学生姓名");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (UndergraduateStudent us : undergraduateStudentList) {
            if (us.getStudentName().equals(name)) {
                System.out.println(us);
                break;
            }
        }
        for (GraduateStudent gs : graduateStudentList) {
            if (gs.getStudentName().equals(name)) {
                System.out.println(gs);
                break;
            }
        }
        for (DoctoralStudent ds : doctoralStudentList) {
            if (ds.getStudentName().equals(name)) {
                System.out.println(ds);
                break;
            }
        }
        System.out.println("找不到该姓名的学生");
    }

    public static void sortStudent() {

        System.out.println("本科生信息：");
        undergraduateStudentList.sort(new UndergraduateComparator());
        System.out.println(UndergraduateStudentSerializer.serializer(undergraduateStudentList));
        System.out.println("研究生信息：");
        graduateStudentList.sort(new GraduateComparator());
        System.out.println(GraduateStudentSerializer.serializer(graduateStudentList));
        System.out.println("博士生信息：");
        doctoralStudentList.sort(new DoctoralComparator());
        System.out.println(DoctoralStudentSerializer.serializer(doctoralStudentList));
    }

    public static void exit() {

        System.out.println("see you next time!");
        System.exit(0);
    }

}