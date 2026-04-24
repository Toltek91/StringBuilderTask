import java.util.Stack;

public class UndoStringBuilder {
    private StringBuilder sb;
    private Stack<StringBuilderSnapshot> history;
    private boolean isUndo;




    public UndoStringBuilder() {
        this.sb = new StringBuilder();
        this.history = new Stack<>();
        this.isUndo = false;
        saveSnapshot();// сохраняем начальное состояние
    }


    // Сохранение текущего состояния
    private void saveSnapshot() {
        if (!isUndo) {
            history.push(new StringBuilderSnapshot(sb.toString()));
        }
    }

    public boolean undo() {
        if (history.size() > 1){
            isUndo = true;
            history.pop();// удаляем текущее cостояние
            StringBuilderSnapshot previousState = history.peek();
            sb = new StringBuilder(previousState.getState());
            isUndo = false;
            return true;
        }
        return false; // Нет состояния для отмены
    }


    // Для демонстрации работы реализовал методы добавление, вставки, удаление подстроки по индексу и реверса

    public UndoStringBuilder append(String str){
        sb.append(str);
        saveSnapshot();
        return this;
    }

    public UndoStringBuilder insert(int offset, String str){
        sb.insert(offset, str);
        saveSnapshot();
        return this;
    }

    public UndoStringBuilder delete (int start, int end){
        sb.delete(start, end);
        saveSnapshot();
        return this;
    }

    public UndoStringBuilder reverse (){
        sb.reverse();
        saveSnapshot();
        return this;
    }



    //Метод для получения истории
    public void getHistory(){
        System.out.println("Размер стека: " + history.size());
    }

    @Override
    public String toString() {
        return sb.toString();
    }
    
}
