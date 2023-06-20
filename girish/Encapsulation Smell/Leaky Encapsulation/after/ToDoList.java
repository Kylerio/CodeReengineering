
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ToDoList {
    private Vector<ToDo> list;

    public ToDoList() {
        list = new Vector<>();
    }

    public List<ToDo> getList() {
        
        List<ToDo> copyList = new ArrayList<>(list.size());
        for (ToDo item : list) {
            ToDo copyItem = new ToDo(item.getName());
            copyList.add(copyItem);
        }
        return copyList;
    }

    public ToDo getByName(String name) {
        for (ToDo toDo : list) {
            if (toDo.getName().equals(name)) {
                return toDo;
            }
        }
        return null;
    }

    public void add(ToDo t) {
        list.add(t);
    }
}

