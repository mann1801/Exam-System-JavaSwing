package Q;

public class LinkedList 
{
    Node head;
    class Node
    {
        int marks;
        int enrollment;
        Node next;
        Node prev;
        Node(int marks,int enrollment)
        {
            this.marks=marks;
            this.enrollment=enrollment;
        }
    }
    void insertInorder(int marks,int enrollment)
    {
        Node n=new Node(marks,enrollment);
        if(head==null)
        {
            head=n;
        }
        else if(head.marks>=n.marks)
        {
            n.next=head;
            head.prev=n;
            head=n;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null&&temp.next.marks<=n.marks)
            {
                temp=temp.next;
            }

            n.next=temp.next;
            n.prev=temp;
            if(temp.next!=null)
            {
                temp.next.prev=n;
            }
            temp.next=n;
        }

    }
    void find(int enroll)
    {
        if(head==null)
        {
            System.out.println("Empty linked list");
        }
        else if(head.enrollment==enroll)
        {
            System.out.println("Marks:"+head.marks);
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                if (temp.enrollment==enroll) 
                {
                    System.out.println("Marks:"+ temp.marks);
                }
                temp=temp.next;
            }
            if(temp.enrollment==enroll)
            {
                System.out.println("Marks:"+temp.marks);
            }
            else
            {
                System.out.println("No enrollment found");
            }
        }
    }
    void display()
    {
        if(head==null)
        {
            System.out.println("Empty linkedlist");
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                System.out.println("Enrollment:"+temp.enrollment+" "+"Marks:"+temp.marks);
                temp=temp.next;
            }
            System.out.println("Enrollment:"+temp.enrollment+" "+"Marks:"+temp.marks);
        }
    }
}