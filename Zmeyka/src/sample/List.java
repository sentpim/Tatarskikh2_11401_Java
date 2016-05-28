package sample;

public class List            // ������
{
    private ListNode First;      // ������ �������
    private ListNode Last;      // ��������� �������
    private ListNode Current;   // ������� �������
    private int Size;         // ���-�� ��������� � ������

    public List()                  // �����������
    {
        First   = null;                  // ��������� �������������
        Last   = null;                  //
        Current   = null;                  //
        Size   = 0;                  //
    }

    public class ListNode            // ������� ������
    {
        ListNode Next;                  // ���������
        ListNode Prev;                  // ����������
        Object Data;                  // ������ �������� � ���� ��������

        public ListNode()               // ����������� �������� ������
        {
            Next = null;               // ��������� �������������
            Prev = null;               //
            Data = null;               //
        }
    }

    public Object Last()            // ���������� �������� ���������� �������� (������)
    {
        if (Size != 0)                  // ���� ������ �� ����
            return Last.Data;
        else                        // ���� ������ ����
            return null;
    }

    public void deleteFirst()            // ������� ������ ������� ������ (�����)
    {
        if (First != null)               // ���� ������ ���� (� � ���� ������ �� ����)
        {
            First = First.Next;            // ����� ������
            if (First != null)            // ���� ����� ������ �� null
                First.Prev = null;         //
            Size--;
        }
    }

    public void add(Object data)      // ��������� � ����� ������ ����� �������
    {
        if (Size != 0)                  // ���� ������ �� ����
        {
            ListNode node = new ListNode();   // ����� �������
            node.Data = data;        //������� ������ � ������� �������
            Current=node;
            Last.Next=node;        // ������ ���������� ����� �������
            node.Prev = Last;                //������ ��������� ������� ��������� ���������� ������������ ������ ���a
            Last = node;
            //
            Size++;                      // ���� ���� �������
        }
        else                        // ���� ������ ����
        {
            ListNode New = new ListNode();   // ������� ����� �������
            New.Data = data;            // � ���� ������ ��� �������
            Current = New;               // ��������� ������� � ������
            First = New;               //
            Last = New;                  //
            Size ++;
        }
    }

    public void next()               // ������� � ����-�� �������� ������
    {
        if (Current != null)            // ���� ������ �� ����
        {
            if (hasNext())               // ���� ���� ����-� �������
            {
                Current = Current.Next;      // ������� � ����-��
            }
            else                     // ���� ����-�� ���
            {
                System.out.println("----------����� ������------(next)------");
            }
        }
        else                        // ���� ������ ����
        {
            System.out.println("-------------������ ����-------(next)--------");
        }
    }

    public boolean hasNext()         // ��������� ���� �� ����-�
    // ��������������, ��� ������ ��������
    {
        if (Current.Next != null)         // ���� ���� ����-�
        {
            return true;
        }
        else                        // ���� ��� ����-��
        {
            return false;
        }
    }

    public void prev()               // ������� � ����������� �������� ������
    {
        if (Current != null)            // ���� ������ �� ����
        {
            if (Current.Prev != null)      // ���� ���� ����-� �������
            {
                Current = Current.Prev;      // ������� � ����-��
            }
            else                     // ���� ����-�� ���
            {
                System.out.println("-------------������ ������--------(prev)-----------");
            }
        }
        else                        // ���� ������ ����
        {
            System.out.println("-------------������ ����---------(prev)---------");
        }
    }

    public Object current()            // ���������� �������� �������� ��������
    {
        if (Current != null)            // ���� ������ �� ����
        {
            return Current.Data;         // ���������� �������, ���������� � ������� ��������
        }
        else                        // ���� ������ ����
        {
            System.out.println("-------------������ ����-------(current)--------");
            return null;               // ���������� null
        }
    }

    public void toFirst()            // ������� � ������� ��������
    {
        if (Size != 0)                  // ���� ������ �� ����
        {
            Current = First;            // ������� � �������
        }
        else                        // ���� ������ ����
        {
            System.out.println("-----------------������ ����-------(toFirst)--------");
        }
    }

    public void toLast()            // ������� � ���������� ��������
    {
        if (Current != null)            // ���� ������ �� ����
        {
            Current = Last;               // ������� � ����������
        }
        else                        // ���� ������ ����
        {
            System.out.println("-------------������ ����-------(toLast)-----");
        }
    }

    public int size()               // ���������� ������ ������
    {
        return Size;
    }

}
