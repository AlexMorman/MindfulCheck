import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class QuoteManager
{
    private Random random;

    private ArrayList<String> spiritual1 = new ArrayList<>();
    private ArrayList<String> bibleAnxious = new ArrayList<>();
    private ArrayList<String> bibleFaith = new ArrayList<>();

    private HashMap<String, ArrayList<String>> categoryMap = new HashMap<>();

    public QuoteManager() throws FileNotFoundException {
        random = new Random(System.currentTimeMillis());

        spiritual1.add("Placeholder spiritual1 quote");
        bibleAnxious.add("Placeholder bibleAnxious quote");
        bibleFaith.add("Placeholder bibleFaith quote");

        scanFile(spiritual1, "QuoteData/spiritual1.txt");
        scanFile(bibleAnxious, "QuoteData/bibleAnxious.txt");
        scanFile(bibleFaith, "QuoteData/bibleFaith.txt");

        categoryMap.put("spiritual1", spiritual1);
        categoryMap.put("bibleAnxious", bibleAnxious);
        categoryMap.put("bibleFaith", bibleFaith);
    }

    public void scanFile(ArrayList<String> list, String filePath) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File(filePath));

        while (scanner.hasNextLine())
        {
            list.add(scanner.nextLine());
        }

        scanner.close();
    }

    public String generateQuote(String category)
    {
        ArrayList<String> list = categoryMap.get(category);
        return list.get(random.nextInt(list.size()));
    }
}
