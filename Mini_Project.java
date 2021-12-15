import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

//-------------class node---------------------//
class Node {
    int id;
    String name;
    Node next;
    double sal;
    String desg;
    Long num;
    int leave_pre;
    int leave_past;
    int number1;
    int leave;
    String dept;
    int number2;
    int randomNum;

    Node() {
        Scanner sc = new Scanner(System.in);
        Random r1 = new Random();
        randomNum = r1.nextInt(100);
        System.out.println("Employee ID -> " + randomNum);
        System.out.println("Select your Department");
        System.out.println(
                "1.Accounting Department 2.Cash Department  3.Credit Department 4.Financial planning Department 5.Budget Department  ");
        number2 = sc.nextInt();
        switch (number2) {
        case 1:
            System.out.println("You Entered in Accounting Department");
            break;

        case 2:
            System.out.println("You Entered in Cash Department");
            break;

        case 3:
            System.out.println("You Entered in Credit Department");
            break;

        case 4:
            System.out.println("You Entered in Financial planning Department");
            break;
        case 5:
            System.out.println("You Entered in Budget Department");
            break;
        default:
            System.out.println("Select a valid Department");
            break;

        }
        System.out.println("Enter NAME of Employee");
        name = sc.next();
        System.out.println("Enter CONTACT of Employee");
        num = sc.nextLong();
        System.out.println("Enter Designation of Employee");
        desg = sc.next();
        System.out.println("Enter Salary of Employee");
        sal = sc.nextDouble();

        System.out.println("I want Leave");
        System.out.println("Give Reason behind leave");
        System.out.println("1.casual leave, 2.parental leave, 3.medical leave");
        number1 = sc.nextInt();
        System.out.println("Enter Number of leave you have in past ");
        leave_past = sc.nextInt();
        System.out.println("Enter Number of leave you want ");
        leave_pre = sc.nextInt();
        leave = leave_past + leave_pre;
        if (leave > 5) {
            System.out.println("Leave Request Rejected");
        } else {
            System.out.println("Leave Request Accepted");
            System.out.print("Remaining Leaves Are-> ");
            System.out.println(10 - leave);
        }

        next = null;
    }
}

class LinkedListEmptyException extends RuntimeException {
    public LinkedListEmptyException() {
        super();
    }

    public LinkedListEmptyException(String message) {
        super(message);
    }
}

// ------------------class LinkedList--------------------//
public class F_Project {
    Node head;
    int leave_past;
    int leave_pre;

    void printLinkedList() {
        System.out.println("Employee Details Using LinkedList");
        Node n = head;
        while (n != null) {
            System.out.println("");
            System.out.print("ID-> " + n.randomNum + "   ");
            System.out.print("Name-> " + n.name + "   ");
            System.out.print("Designation-> " + n.desg + "   ");
            System.out.print("Salary-> " + n.sal + "   ");
            System.out.print("Contact No.-> " + n.num + "   ");
            System.out.print("Leaves Taken Till Date-> " + n.leave + "   ");
            n = n.next;
        }
        System.out.println();
    }

    void fileWriter() {

        Node n = head;
        try {
            FileWriter fWriter = new FileWriter("F:\\CDAC Main Course\\Module 3\\Gym Management\\demo1.txt");
            while (n != null) {

                fWriter.write("ID-> " + n.randomNum + "   ");
                fWriter.write("Name-> " + n.name + "   ");
                fWriter.write("Designation-> " + n.desg + "   ");
                fWriter.write("Salary-> " + n.sal + "   ");
                fWriter.write("Contact No.-> " + n.num + "   ");
                fWriter.write("Leaves Taken Till Date-> " + n.leave + "   ");

                n = n.next;
            }
            fWriter.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        System.out.println("File is created successfully with the content.");

        // DisplayMember();
    }

    void insertAtBegining() {
        Node new_node = new Node();
        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
    }

    void insertAtEnd() {
        Node new_node = new Node();
        if (head == null) {
            head = new_node;
        } else {
            Node trav = head;
            while (trav.next != null) {

                trav = trav.next;
            }
            trav.next = new_node;
        }
    }

    void countEle() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }

    void deleteAtFirst() {

        if (head == null) {
            throw new LinkedListEmptyException("LinkedList doesn't contain any Nodes.");
        } else {

            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
            }
            printLinkedList();
        }
    }

    void deleteAtLast() {
        Node Trav;
        if (head == null) {
            throw new LinkedListEmptyException("LinkedList doesn't contain any Nodes.");
        } else {
            if (head.next == null)
                head = null;
            else {
                Trav = head;

                while (Trav.next.next != null) {
                    Trav = Trav.next;
                }
                Trav.next = null;
            }
        }
        printLinkedList();
    }

    public boolean SearchIterativeLL(int key) {
        int pos = 1;
        Node curr = head;

        while (curr != null) {
            if (curr.randomNum == key) {
                System.out.println("Employee Data Exists");
                return true;
            } else {
                pos++;
                curr = curr.next;
            }
            System.out.println("Employee Data Does Not Exist");

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F_Project L1 = new F_Project();

        boolean ch = true;

        while (ch) {
            System.out.println("********");
            System.out.println("*  WELCOME TO BANKING PORTAL  ***");
            System.out.println("********");

            System.out.println("Select One Option");
            System.out.println("\n 1.Management \n\n 2.Employee \n\n 3.exit");
            System.out.println("===========================================================");
            System.out.print("Your Option Is  ");
            int number3 = sc.nextInt();

            switch (number3) {
            case 1:
                System.out.println("===========================================================");
                System.out.println("Welcome To The Management Section");
                boolean check = true;
                while (check) {
                    System.out.println("===========================================================");

                    System.out.println("Select one Option");
                    System.out.println(
                            "1. Delete First Employee Record  \n2. Delete At Last \n3.Search For Employee  \n4. Exit");
                    System.out.print("Your Option Is  ");
                    int number4 = sc.nextInt();

                    switch (number4) {
                    case 1:

                        L1.deleteAtFirst();

                        break;
                    case 2:

                        L1.deleteAtLast();

                        break;
                    case 3:
                        System.out.println("Enter ID to Search");
                        int key = sc.nextInt();
                        L1.SearchIterativeLL(key);
                        break;
                    case 4:
                        check = false;
                        break;
                    default:
                        System.out.println("Enter valid Operation");

                    }
                }
                break;
            case 2:
                System.out.println("Welcome Employee");
                check = true;
                while (check) {
                    System.out.println("Enter Choice");
                    System.out.println("1 Insert Data At Beginning   2 Insert data At Last  3 Exit ");
                    int number5 = sc.nextInt();
                    switch (number5) {
                    case 1: {
                        L1.insertAtBegining();
                        L1.printLinkedList();
                        L1.fileWriter();
                        break;
                    }
                    case 2: {
                        L1.insertAtEnd();
                        L1.printLinkedList();
                        L1.fileWriter();
                        break;
                    }
                    case 3: {
                        check = false;
                        break;
                    }
                    default:
                        System.out.println("Enter valid Operation");
                    }
                }
                break;
            case 3:
                ch = false;
                break;
            }

            System.out.println("Number of records in list -> ");
            L1.countEle();
        }

    }

}