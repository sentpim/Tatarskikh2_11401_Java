package sample;

public class List            // Список
{
    private ListNode First;      // Первый элемент
    private ListNode Last;      // Последний элемент
    private ListNode Current;   // Текущий элемент
    private int Size;         // Кол-во элементов в списке

    public List()                  // Конструктор
    {
        First   = null;                  // Начальная инициализация
        Last   = null;                  //
        Current   = null;                  //
        Size   = 0;                  //
    }

    public class ListNode            // Элемент списка
    {
        ListNode Next;                  // Следующий
        ListNode Prev;                  // Предыдущий
        Object Data;                  // Данные хранимые в этом элементе

        public ListNode()               // Конструктор элемента списка
        {
            Next = null;               // Начальная инициализация
            Prev = null;               //
            Data = null;               //
        }
    }

    public Object Last()            // Возвращает значение последнего элемента (голова)
    {
        if (Size != 0)                  // Если список не пуст
            return Last.Data;
        else                        // Если список пуст
            return null;
    }

    public void deleteFirst()            // Удаляет первый элемент списка (хвост)
    {
        if (First != null)               // Если первый есть (т е если список не пуст)
        {
            First = First.Next;            // Новый первый
            if (First != null)            // Если новый первый не null
                First.Prev = null;         //
            Size--;
        }
    }

    public void add(Object data)      // Добавляет в конец списка новый элемент
    {
        if (Size != 0)                  // Если список не пуст
        {
            ListNode node = new ListNode();   // Новый элемент
            node.Data = data;        //заносим объект в текущий элемент
            Current=node;
            Last.Next=node;        // текщим становится новый элемент
            node.Prev = Last;                //бывший последним элемент считается предыдущим относительно нового узлa
            Last = node;
            //
            Size++;                      // Плюс один элемент
        }
        else                        // Если список пуст
        {
            ListNode New = new ListNode();   // Создаем новый элемент
            New.Data = data;            // В него кладем наш квадрат
            Current = New;               // Добавляем элемент в список
            First = New;               //
            Last = New;                  //
            Size ++;
        }
    }

    public void next()               // Переход к след-му элементу списка
    {
        if (Current != null)            // Если список не пуст
        {
            if (hasNext())               // Если есть след-й элемент
            {
                Current = Current.Next;      // Переход к след-му
            }
            else                     // Если след-го нет
            {
                System.out.println("----------конец списка------(next)------");
            }
        }
        else                        // Если список пуст
        {
            System.out.println("-------------список пуст-------(next)--------");
        }
    }

    public boolean hasNext()         // Проверяет есть ли след-й
    // Предполагается, что список непустой
    {
        if (Current.Next != null)         // Если есть след-й
        {
            return true;
        }
        else                        // Если нет след-го
        {
            return false;
        }
    }

    public void prev()               // Переход к предыдущему элементу списка
    {
        if (Current != null)            // Если список не пуст
        {
            if (Current.Prev != null)      // Если есть пред-й элемент
            {
                Current = Current.Prev;      // Переход к пред-му
            }
            else                     // Если пред-го нет
            {
                System.out.println("-------------начало списка--------(prev)-----------");
            }
        }
        else                        // Если список пуст
        {
            System.out.println("-------------список пуст---------(prev)---------");
        }
    }

    public Object current()            // Возвращает значение текущего элемента
    {
        if (Current != null)            // Если список не пуст
        {
            return Current.Data;         // Возвращает квадрат, хранящийся в текущем элементе
        }
        else                        // Если список пуст
        {
            System.out.println("-------------список пуст-------(current)--------");
            return null;               // Возвращает null
        }
    }

    public void toFirst()            // Перейти к первому элементу
    {
        if (Size != 0)                  // Если список не пуст
        {
            Current = First;            // Переход к первому
        }
        else                        // Если список пуст
        {
            System.out.println("-----------------список пуст-------(toFirst)--------");
        }
    }

    public void toLast()            // Перейти к последнему элементу
    {
        if (Current != null)            // Если список не пуст
        {
            Current = Last;               // Переход к последнему
        }
        else                        // Если список пуст
        {
            System.out.println("-------------список пуст-------(toLast)-----");
        }
    }

    public int size()               // Возвращает размер списка
    {
        return Size;
    }

}
