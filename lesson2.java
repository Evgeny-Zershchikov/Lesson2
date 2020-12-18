
import java.util.*;
import java.nio.file.*;
import java.io.IOException;


public class lesson2 {
    public static void main (String[] args) throws IOException{
        Scanner in = new Scanner(Paths.get("c:\\text.txt"), "UTF-8");
        List<String> textList = new ArrayList<>();
        while (in.hasNext()) {
            textList.add(in.next().toLowerCase());
        }
        System.out.println("Количество слов в тексте " + textList.size());
        System.out.println("Сортируем слова по алфавиту");
        textList.sort(String::compareToIgnoreCase);
        textList.forEach((v) -> System.out.print(" " + v));
        System.out.println();
        System.out.println("Сортируем слова по длине");
        Collections.sort(textList, (first, second) -> first.length() - second.length());
        textList.forEach((v) -> System.out.print(" " + v));
        System.out.println();
        Set textSet = new TreeSet(textList);
        System.out.println("Количество уникальных слов в тексте: " + textSet.size());
        Iterator iterator = textSet.iterator();
        int k = 0;
        String str = null;
        while (iterator.hasNext()){
            str = iterator.next().toString();
            for (int i = 0; i<textList.size(); i++ ){
                if (str.equalsIgnoreCase(textList.get(i))){
                    k++;
                }
            }
            System.out.printf("The word \"%s\" occurs %d times in the text. \n" , str, k);
            k = 0;
        }
        Scanner in1 = new Scanner(Paths.get("c:\\text.txt"), "UTF-8");
        List<String> reversLineList = new ArrayList<>();
        while(in1.hasNextLine()) reversLineList.add(in1.nextLine());
        for (int i = reversLineList.size() - 1; i >= 0; i-- ){
            System.out.println(reversLineList.get(i));
        }

        Scanner in2 = new Scanner(Paths.get("c:\\text.txt"), "UTF-8");
        List<String> reversTextList = new ArrayList<>();
        while(in2.hasNextLine()) reversTextList.add(in2.next());

        Iterator reversIterator = new ReversIterator(reversTextList);
        while (reversIterator.hasNext()) System.out.print(" " + reversIterator.next());
        System.out.println();

        Scanner inner = new Scanner(System.in);
        System.out.printf("Вывод номера строки из 0 to % d: ", reversLineList.size());
        int line = inner.nextInt() - 1;
        if(line > reversLineList.size() - 1 | line <= 0) System.out.println("Вы ввели неправильный номер строки");
        System.out.printf("Строка с номером %d:\n %s ", line + 1, reversLineList.get(line));
    }
}

