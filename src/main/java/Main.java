

public class Main {

    public static void main(String[] args) {

        UndoStringBuilder undoSb = new UndoStringBuilder();

        System.out.println("Начальное состояние: ' " + undoSb + "'");

        undoSb.append("World");
        System.out.println("После append: ' " + undoSb + "'");

        undoSb.insert(5, " good  ");
        System.out.println("После insert: ' " + undoSb + "'");

        undoSb.delete(0, 1);
        System.out.println("После delete: ' " + undoSb + "'");


        undoSb.reverse();
        System.out.println("После reverse: ' " + undoSb + "'");
        undoSb.getHistory();

        undoSb.undo();
        System.out.println("После отмены #1: ' " + undoSb + "'");
        undoSb.getHistory();

        undoSb.undo();
        System.out.println("После отмены #2: ' " + undoSb + "'");
        undoSb.getHistory();

        undoSb.undo();
        System.out.println("После отмены #3: '" + undoSb + "'");
        undoSb.getHistory();

        undoSb.undo();
        System.out.println("После отмены #4: '" + undoSb + "'");
        undoSb.getHistory();


        System.out.println("Попытка undo (нет истории): " +
                (undoSb.undo() ? "успешно" : "неудачно"));


    }
}
